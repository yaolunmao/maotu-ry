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
import com.ruoyi.webtopo.domain.WebtopoDevice;
import com.ruoyi.webtopo.service.IWebtopoDeviceService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 设备列表Controller
 * 
 * @author 咬轮猫
 * @date 2023-02-08
 */
@RestController
@RequestMapping("/webtopo/device")
public class WebtopoDeviceController extends BaseController
{
    @Autowired
    private IWebtopoDeviceService webtopoDeviceService;

    /**
     * 查询设备列表列表
     */
    @PreAuthorize("@ss.hasPermi('webtopo:device:list')")
    @GetMapping("/list")
    public TableDataInfo list(WebtopoDevice webtopoDevice)
    {
        startPage();
        List<WebtopoDevice> list = webtopoDeviceService.selectWebtopoDeviceList(webtopoDevice);
        return getDataTable(list);
    }
    /**
     * 查询全部设备列表列表
     */
    @PreAuthorize("@ss.hasPermi('webtopo:device:list')")
    @GetMapping("/listAll")
    public TableDataInfo listAll(WebtopoDevice webtopoDevice)
    {
        List<WebtopoDevice> list = webtopoDeviceService.selectWebtopoDeviceList(webtopoDevice);
        return getDataTable(list);
    }
    /**
     * 导出设备列表列表
     */
    @PreAuthorize("@ss.hasPermi('webtopo:device:export')")
    @Log(title = "设备列表", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, WebtopoDevice webtopoDevice)
    {
        List<WebtopoDevice> list = webtopoDeviceService.selectWebtopoDeviceList(webtopoDevice);
        ExcelUtil<WebtopoDevice> util = new ExcelUtil<WebtopoDevice>(WebtopoDevice.class);
        util.exportExcel(response, list, "设备列表数据");
    }

    /**
     * 获取设备列表详细信息
     */
    @PreAuthorize("@ss.hasPermi('webtopo:device:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(webtopoDeviceService.selectWebtopoDeviceById(id));
    }

    /**
     * 新增设备列表
     */
    @PreAuthorize("@ss.hasPermi('webtopo:device:add')")
    @Log(title = "设备列表", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody WebtopoDevice webtopoDevice)
    {
        return toAjax(webtopoDeviceService.insertWebtopoDevice(webtopoDevice));
    }

    /**
     * 修改设备列表
     */
    @PreAuthorize("@ss.hasPermi('webtopo:device:edit')")
    @Log(title = "设备列表", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody WebtopoDevice webtopoDevice)
    {
        return toAjax(webtopoDeviceService.updateWebtopoDevice(webtopoDevice));
    }

    /**
     * 删除设备列表
     */
    @PreAuthorize("@ss.hasPermi('webtopo:device:remove')")
    @Log(title = "设备列表", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(webtopoDeviceService.deleteWebtopoDeviceByIds(ids));
    }
}
