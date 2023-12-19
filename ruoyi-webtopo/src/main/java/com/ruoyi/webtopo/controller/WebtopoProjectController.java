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
import com.ruoyi.webtopo.domain.WebtopoProject;
import com.ruoyi.webtopo.service.IWebtopoProjectService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 项目列Controller
 * 
 * @author yaolunmao
 * @date 2023-02-10
 */
@RestController
@RequestMapping("/webtopo/project")
public class WebtopoProjectController extends BaseController
{
    @Autowired
    private IWebtopoProjectService webtopoProjectService;

    /**
     * 查询项目列列表
     */
    @PreAuthorize("@ss.hasPermi('webtopo:project:list')")
    @GetMapping("/list")
    public TableDataInfo list(WebtopoProject webtopoProject)
    {
        startPage();
        List<WebtopoProject> list = webtopoProjectService.selectWebtopoProjectList(webtopoProject);
        return getDataTable(list);
    }

    /**
     * 导出项目列列表
     */
    @PreAuthorize("@ss.hasPermi('webtopo:project:export')")
    @Log(title = "项目列", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, WebtopoProject webtopoProject)
    {
        List<WebtopoProject> list = webtopoProjectService.selectWebtopoProjectList(webtopoProject);
        ExcelUtil<WebtopoProject> util = new ExcelUtil<WebtopoProject>(WebtopoProject.class);
        util.exportExcel(response, list, "项目列数据");
    }

    /**
     * 获取项目列详细信息
     */
    @PreAuthorize("@ss.hasPermi('webtopo:project:query')")
    @GetMapping(value = "/{projectId}")
    public AjaxResult getInfo(@PathVariable("projectId") Long projectId)
    {
        return success(webtopoProjectService.selectWebtopoProjectByProjectId(projectId));
    }

    /**
     * 新增项目列
     */
    @PreAuthorize("@ss.hasPermi('webtopo:project:add')")
    @Log(title = "项目列", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody WebtopoProject webtopoProject)
    {
        return toAjax(webtopoProjectService.insertWebtopoProject(webtopoProject));
    }

    /**
     * 修改项目列
     */
    @PreAuthorize("@ss.hasPermi('webtopo:project:edit')")
    @Log(title = "项目列", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody WebtopoProject webtopoProject)
    {
        return toAjax(webtopoProjectService.updateWebtopoProject(webtopoProject,true));
    }

    /**
     * 删除项目列
     */
    @PreAuthorize("@ss.hasPermi('webtopo:project:remove')")
    @Log(title = "项目列", businessType = BusinessType.DELETE)
	@DeleteMapping("/{projectIds}")
    public AjaxResult remove(@PathVariable Long[] projectIds)
    {
        return toAjax(webtopoProjectService.deleteWebtopoProjectByProjectIds(projectIds));
    }

    /**
     * 保存项目信息
     */
    @PreAuthorize("@ss.hasPermi('webtopo:project:edit')")
    @Log(title = "保存项目信息", businessType = BusinessType.UPDATE)
    @PutMapping("/save")
    public AjaxResult save(@RequestBody WebtopoProject webtopoProject)
    {
        return toAjax(webtopoProjectService.updateWebtopoProject(webtopoProject,false));
    }
}
