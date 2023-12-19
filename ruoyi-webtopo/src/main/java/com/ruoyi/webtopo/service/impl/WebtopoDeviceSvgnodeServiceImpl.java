package com.ruoyi.webtopo.service.impl;

import java.util.List;

import com.ruoyi.webtopo.domain.WebtopoWebSocketDevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.webtopo.mapper.WebtopoDeviceSvgnodeMapper;
import com.ruoyi.webtopo.domain.WebtopoDeviceSvgnode;
import com.ruoyi.webtopo.service.IWebtopoDeviceSvgnodeService;

/**
 * svg与设备绑定Service业务层处理
 * 
 * @author yaolunmao
 * @date 2023-02-15
 */
@Service
public class WebtopoDeviceSvgnodeServiceImpl implements IWebtopoDeviceSvgnodeService 
{
    @Autowired
    private WebtopoDeviceSvgnodeMapper webtopoDeviceSvgnodeMapper;

    /**
     * 查询svg与设备绑定
     * 
     * @param projectId svg与设备绑定主键
     * @return svg与设备绑定
     */
    @Override
    public WebtopoDeviceSvgnode selectWebtopoDeviceSvgnodeByProjectId(Long projectId)
    {
        return webtopoDeviceSvgnodeMapper.selectWebtopoDeviceSvgnodeByProjectId(projectId);
    }

    /**
     * 查询svg与设备绑定列表
     * 
     * @param webtopoDeviceSvgnode svg与设备绑定
     * @return svg与设备绑定
     */
    @Override
    public List<WebtopoDeviceSvgnode> selectWebtopoDeviceSvgnodeList(WebtopoDeviceSvgnode webtopoDeviceSvgnode)
    {
        return webtopoDeviceSvgnodeMapper.selectWebtopoDeviceSvgnodeList(webtopoDeviceSvgnode);
    }

    /**
     * 新增svg与设备绑定
     * 
     * @param webtopoDeviceSvgnode svg与设备绑定
     * @return 结果
     */
    @Override
    public int insertWebtopoDeviceSvgnode(WebtopoDeviceSvgnode webtopoDeviceSvgnode)
    {
        return webtopoDeviceSvgnodeMapper.insertWebtopoDeviceSvgnode(webtopoDeviceSvgnode);
    }

    /**
     * 修改svg与设备绑定
     * 
     * @param webtopoDeviceSvgnode svg与设备绑定
     * @return 结果
     */
    @Override
    public int updateWebtopoDeviceSvgnode(WebtopoDeviceSvgnode webtopoDeviceSvgnode)
    {
        return webtopoDeviceSvgnodeMapper.updateWebtopoDeviceSvgnode(webtopoDeviceSvgnode);
    }

    /**
     * 批量删除svg与设备绑定
     * 
     * @param projectIds 需要删除的svg与设备绑定主键
     * @return 结果
     */
    @Override
    public int deleteWebtopoDeviceSvgnodeByProjectIds(Long[] projectIds)
    {
        return webtopoDeviceSvgnodeMapper.deleteWebtopoDeviceSvgnodeByProjectIds(projectIds);
    }

    /**
     * 删除svg与设备绑定信息
     * 
     * @param projectId svg与设备绑定主键
     * @return 结果
     */
    @Override
    public int deleteWebtopoDeviceSvgnodeByProjectId(Long projectId)
    {
        return webtopoDeviceSvgnodeMapper.deleteWebtopoDeviceSvgnodeByProjectId(projectId);
    }

    /**
     * 解除svg与设备绑定
     *
     * @param webtopoDeviceSvgnode svg与设备绑定
     * @return 结果
     */
    @Override
    public int unbindWebtopoDeviceSvgnode(WebtopoDeviceSvgnode webtopoDeviceSvgnode){
        return webtopoDeviceSvgnodeMapper.unbindWebtopoDeviceSvgnode(webtopoDeviceSvgnode);
    }
    /**
     * 查询svg与设备绑定列表
     *
     * @return svg与设备绑定集合
     */
    @Override
    public List<WebtopoDeviceSvgnode> selectWebtopoDeviceSvgnodeList(WebtopoWebSocketDevice webtopoWebSocketDevice) {
        return webtopoDeviceSvgnodeMapper.selectWebtopoDeviceSvgnodeByPropList(webtopoWebSocketDevice);
    }
}
