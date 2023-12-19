package com.ruoyi.webtopo.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.webtopo.domain.WebtopoDeviceSvgnode;
import com.ruoyi.webtopo.service.IWebtopoDeviceSvgnodeService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * svg与设备绑定Controller
 * 
 * @author yaolunmao
 * @date 2023-02-15
 */
@RestController
@RequestMapping("/webtopo/svgnode")
public class WebtopoDeviceSvgnodeController extends BaseController
{
    @Autowired
    private IWebtopoDeviceSvgnodeService webtopoDeviceSvgnodeService;

    /**
     * 查询svg与设备绑定列表
     */
    @GetMapping("/list")
    public AjaxResult list(WebtopoDeviceSvgnode webtopoDeviceSvgnode)
    {
//        startPage();
        List<WebtopoDeviceSvgnode> list = webtopoDeviceSvgnodeService.selectWebtopoDeviceSvgnodeList(webtopoDeviceSvgnode);
        return success(list);
//        return getDataTable(list);
    }

    /**
     * 导出svg与设备绑定列表
     */
    @PreAuthorize("@ss.hasPermi('webtopo:svgnode:export')")
    @Log(title = "svg与设备绑定", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, WebtopoDeviceSvgnode webtopoDeviceSvgnode)
    {
        List<WebtopoDeviceSvgnode> list = webtopoDeviceSvgnodeService.selectWebtopoDeviceSvgnodeList(webtopoDeviceSvgnode);
        ExcelUtil<WebtopoDeviceSvgnode> util = new ExcelUtil<WebtopoDeviceSvgnode>(WebtopoDeviceSvgnode.class);
        util.exportExcel(response, list, "svg与设备绑定数据");
    }

    /**
     * 获取svg与设备绑定详细信息
     */
    @GetMapping(value = "/{projectId}")
    public AjaxResult getInfo(@PathVariable("projectId") Long projectId)
    {
        return success(webtopoDeviceSvgnodeService.selectWebtopoDeviceSvgnodeByProjectId(projectId));
    }

    /**
     * 新增svg与设备绑定
     */
    @PreAuthorize("@ss.hasPermi('webtopo:svgnode:add')")
    @Log(title = "svg与设备绑定", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody WebtopoDeviceSvgnode webtopoDeviceSvgnode)
    {
        return toAjax(webtopoDeviceSvgnodeService.insertWebtopoDeviceSvgnode(webtopoDeviceSvgnode));
    }

    /**
     * 修改svg与设备绑定
     */
    @PreAuthorize("@ss.hasPermi('webtopo:svgnode:edit')")
    @Log(title = "svg与设备绑定", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody WebtopoDeviceSvgnode webtopoDeviceSvgnode)
    {
        return toAjax(webtopoDeviceSvgnodeService.updateWebtopoDeviceSvgnode(webtopoDeviceSvgnode));
    }

    /**
     * 删除svg与设备绑定
     */
    @PreAuthorize("@ss.hasPermi('webtopo:svgnode:remove')")
    @Log(title = "svg与设备绑定", businessType = BusinessType.DELETE)
	@DeleteMapping("/{projectIds}")
    public AjaxResult remove(@PathVariable Long[] projectIds)
    {
        return toAjax(webtopoDeviceSvgnodeService.deleteWebtopoDeviceSvgnodeByProjectIds(projectIds));
    }

    /**
     * 解除svg与设备绑定
     */
    @PreAuthorize("@ss.hasPermi('webtopo:svgnode:remove')")
    @Log(title = "解除svg与设备绑定", businessType = BusinessType.DELETE)
    @DeleteMapping("/unbind")
    public AjaxResult unbind(@RequestBody WebtopoDeviceSvgnode webtopoDeviceSvgnode)
    {
        return toAjax(webtopoDeviceSvgnodeService.unbindWebtopoDeviceSvgnode(webtopoDeviceSvgnode));
    }
}
