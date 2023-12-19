package com.ruoyi.webtopo.controller;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;

import com.ruoyi.common.enums.BusinessType;

import com.ruoyi.framework.websocket.WebSocketServer;

import com.ruoyi.webtopo.domain.*;
import com.ruoyi.webtopo.service.IWebtopoDeviceSvgnodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


/**
 * 设备列表Controller
 * 
 * @author 咬轮猫
 */
@RestController
@RequestMapping("/webtopo/websocket")
public class WebtopoWebSocketController extends BaseController
{
    @Autowired
    private IWebtopoDeviceSvgnodeService webtopoDeviceSvgnodeService;
    /**
     * 模拟设备信息
     */
    @Log(title = "模拟设备信息", businessType = BusinessType.OTHER)
    @PostMapping("/simulationDeviceInfo")
    public AjaxResult simulationDeviceInfo(@RequestBody WebtopoWebSocket webtopoWebSocket,@RequestHeader("Authorization") String jwt)
    {
        WebtopoWebSocketDevice webtopoWebSocketDevice=new WebtopoWebSocketDevice();
        webtopoWebSocketDevice.setDeviceId(webtopoWebSocket.getDeviceId());
        webtopoWebSocketDevice.setProjectId(webtopoWebSocket.getProjectId());
        webtopoWebSocketDevice.setDeviceProp(webtopoWebSocket.getProps().stream().map(m->m.getType()).collect(Collectors.toList()));
        List<WebtopoDeviceSvgnode> list = webtopoDeviceSvgnodeService.selectWebtopoDeviceSvgnodeList(webtopoWebSocketDevice);
        WebtopoWebSocketMsg webtopoWebSocketMsg=new WebtopoWebSocketMsg();
        JSONArray jsonArray =new JSONArray();
        for (WebtopoWebSocketDeviceProps item:webtopoWebSocket.getProps()
             ) {
            List<WebtopoDeviceSvgnode> svgnodeList = list.stream().filter(f -> f.getDeviceProp().equals(item.getType())).collect(Collectors.toList());
            for (WebtopoDeviceSvgnode svgnode:svgnodeList
                 ) {
                JSONObject jsonObject=new JSONObject();
                jsonObject.put("id",svgnode.getSvgNodeId());
                jsonObject.put("attr",svgnode.getSvgNodeProp());
                if("onOff".equals(item.getType())||"ws_state".equals(item.getType())){
                    //开关转换为bool类型
                    jsonObject.put("val","true".equals(item.getVal())?true:false);
                }
                else {
                    jsonObject.put("val",item.getVal());
                }
                jsonArray.add(jsonObject);
            }
        }
        webtopoWebSocketMsg.setType("setNodeAttr");
        webtopoWebSocketMsg.setMsg(jsonArray);
        WebSocketServer ws=new WebSocketServer();
        try {
            ws.sendMessage(jwt.replace("Bearer ",""), JSON.toJSONString(webtopoWebSocketMsg));
        } catch (IOException e) {
            return toAjax(0);
        }
        return toAjax(1);
    }
}
