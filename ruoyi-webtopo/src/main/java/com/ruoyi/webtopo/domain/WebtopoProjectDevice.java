package com.ruoyi.webtopo.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

import java.util.List;

/**
 * 项目关联设备对象 webtopo_project_device
 * 
 * @author yaolunmao
 * @date 2023-02-10
 */
public class WebtopoProjectDevice
{
    private static final long serialVersionUID = 1L;

    /** 项目id */
    private Long projectId;

    /** 设备id */
    private Long deviceId;

    private String deviceName;

    public void setDeviceName(String deviceName)
    {
        this.deviceName = deviceName;
    }

    public String getDeviceName()
    {
        return deviceName;
    }


    public void setProjectId(Long projectId)
    {
        this.projectId = projectId;
    }

    public Long getProjectId()
    {
        return projectId;
    }
    public void setDeviceId(Long deviceId) 
    {
        this.deviceId = deviceId;
    }

    public Long getDeviceId() 
    {
        return deviceId;
    }

    /** 关联表设备字典信息 */
    private List<WebtopoProjectDeviceDict> deviceDictList;

    public List<WebtopoProjectDeviceDict> getDeviceDictList()
    {
        return deviceDictList;
    }

    public void setDeviceDictList(List<WebtopoProjectDeviceDict> deviceDictList)
    {
        this.deviceDictList = deviceDictList;
    }
    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("projectId", getProjectId())
            .append("deviceId", getDeviceId())
            .append("deviceDictList", getDeviceDictList())
            .toString();
    }
}
