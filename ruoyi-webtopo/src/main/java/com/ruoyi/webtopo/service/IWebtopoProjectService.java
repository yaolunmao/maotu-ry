package com.ruoyi.webtopo.service;

import java.util.List;
import com.ruoyi.webtopo.domain.WebtopoProject;

/**
 * 项目列Service接口
 * 
 * @author yaolunmao
 * @date 2023-02-10
 */
public interface IWebtopoProjectService 
{
    /**
     * 查询项目列
     * 
     * @param projectId 项目列主键
     * @return 项目列
     */
    public WebtopoProject selectWebtopoProjectByProjectId(Long projectId);

    /**
     * 查询项目列列表
     * 
     * @param webtopoProject 项目列
     * @return 项目列集合
     */
    public List<WebtopoProject> selectWebtopoProjectList(WebtopoProject webtopoProject);

    /**
     * 新增项目列
     * 
     * @param webtopoProject 项目列
     * @return 结果
     */
    public int insertWebtopoProject(WebtopoProject webtopoProject);

    /**
     * 修改项目列
     * 
     * @param webtopoProject 项目列
     * @return 结果
     */
    public int updateWebtopoProject(WebtopoProject webtopoProject,boolean is_delete);

    /**
     * 批量删除项目列
     * 
     * @param projectIds 需要删除的项目列主键集合
     * @return 结果
     */
    public int deleteWebtopoProjectByProjectIds(Long[] projectIds);

    /**
     * 删除项目列信息
     * 
     * @param projectId 项目列主键
     * @return 结果
     */
    public int deleteWebtopoProjectByProjectId(Long projectId);
}
