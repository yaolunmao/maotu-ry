package com.ruoyi.webtopo.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import com.ruoyi.common.utils.StringUtils;
import org.springframework.transaction.annotation.Transactional;
import com.ruoyi.webtopo.domain.WebtopoProjectDevice;
import com.ruoyi.webtopo.mapper.WebtopoProjectMapper;
import com.ruoyi.webtopo.domain.WebtopoProject;
import com.ruoyi.webtopo.service.IWebtopoProjectService;

/**
 * 项目列Service业务层处理
 * 
 * @author yaolunmao
 * @date 2023-02-10
 */
@Service
public class WebtopoProjectServiceImpl implements IWebtopoProjectService 
{
    @Autowired
    private WebtopoProjectMapper webtopoProjectMapper;

    /**
     * 查询项目列
     * 
     * @param projectId 项目列主键
     * @return 项目列
     */
    @Override
    public WebtopoProject selectWebtopoProjectByProjectId(Long projectId)
    {
        return webtopoProjectMapper.selectWebtopoProjectByProjectId(projectId);
    }

    /**
     * 查询项目列列表
     * 
     * @param webtopoProject 项目列
     * @return 项目列
     */
    @Override
    public List<WebtopoProject> selectWebtopoProjectList(WebtopoProject webtopoProject)
    {
        return webtopoProjectMapper.selectWebtopoProjectList(webtopoProject);
    }

    /**
     * 新增项目列
     * 
     * @param webtopoProject 项目列
     * @return 结果
     */
    @Transactional
    @Override
    public int insertWebtopoProject(WebtopoProject webtopoProject)
    {
        webtopoProject.setCreateTime(DateUtils.getNowDate());
        int rows = webtopoProjectMapper.insertWebtopoProject(webtopoProject);
        insertWebtopoProjectDevice(webtopoProject);
        return rows;
    }

    /**
     * 修改项目列
     * 
     * @param webtopoProject 项目列
     * @return 结果
     */
    @Transactional
    @Override
    public int updateWebtopoProject(WebtopoProject webtopoProject,boolean is_delete)
    {
        webtopoProject.setUpdateTime(DateUtils.getNowDate());
        if(is_delete){
            webtopoProjectMapper.deleteWebtopoProjectDeviceByProjectId(webtopoProject.getProjectId());
            insertWebtopoProjectDevice(webtopoProject);
        }
        return webtopoProjectMapper.updateWebtopoProject(webtopoProject);
    }

    /**
     * 批量删除项目列
     * 
     * @param projectIds 需要删除的项目列主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteWebtopoProjectByProjectIds(Long[] projectIds)
    {
        webtopoProjectMapper.deleteWebtopoProjectDeviceByProjectIds(projectIds);
        return webtopoProjectMapper.deleteWebtopoProjectByProjectIds(projectIds);
    }

    /**
     * 删除项目列信息
     * 
     * @param projectId 项目列主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteWebtopoProjectByProjectId(Long projectId)
    {
        webtopoProjectMapper.deleteWebtopoProjectDeviceByProjectId(projectId);
        return webtopoProjectMapper.deleteWebtopoProjectByProjectId(projectId);
    }

    /**
     * 新增项目关联设备信息
     * 
     * @param webtopoProject 项目列对象
     */
    public void insertWebtopoProjectDevice(WebtopoProject webtopoProject)
    {
        List<WebtopoProjectDevice> projectDeviceList = webtopoProject.getDeviceList();
        Long projectId = webtopoProject.getProjectId();
        if (StringUtils.isNotNull(projectDeviceList))
        {
            List<WebtopoProjectDevice> list = new ArrayList<WebtopoProjectDevice>();
            for (WebtopoProjectDevice webtopoProjectDevice : projectDeviceList)
            {
                webtopoProjectDevice.setProjectId(projectId);
                list.add(webtopoProjectDevice);
            }
            if (list.size() > 0)
            {
                webtopoProjectMapper.batchWebtopoProjectDevice(list);
            }
        }
    }
}
