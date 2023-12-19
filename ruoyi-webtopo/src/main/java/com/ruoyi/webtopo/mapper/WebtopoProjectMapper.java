package com.ruoyi.webtopo.mapper;

import java.util.List;
import com.ruoyi.webtopo.domain.WebtopoProject;
import com.ruoyi.webtopo.domain.WebtopoProjectDevice;

/**
 * 项目列Mapper接口
 * 
 * @author yaolunmao
 * @date 2023-02-10
 */
public interface WebtopoProjectMapper 
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
    public int updateWebtopoProject(WebtopoProject webtopoProject);

    /**
     * 删除项目列
     * 
     * @param projectId 项目列主键
     * @return 结果
     */
    public int deleteWebtopoProjectByProjectId(Long projectId);

    /**
     * 批量删除项目列
     * 
     * @param projectIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteWebtopoProjectByProjectIds(Long[] projectIds);

    /**
     * 批量删除项目关联设备
     * 
     * @param projectIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteWebtopoProjectDeviceByProjectIds(Long[] projectIds);
    
    /**
     * 批量新增项目关联设备
     * 
     * @param projectDeviceList 项目关联设备列表
     * @return 结果
     */
    public int batchWebtopoProjectDevice(List<WebtopoProjectDevice> projectDeviceList);
    

    /**
     * 通过项目列主键删除项目关联设备信息
     * 
     * @param projectId 项目列ID
     * @return 结果
     */
    public int deleteWebtopoProjectDeviceByProjectId(Long projectId);
}
