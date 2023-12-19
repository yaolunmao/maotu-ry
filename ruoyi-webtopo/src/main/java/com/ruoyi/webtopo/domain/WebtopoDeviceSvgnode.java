package com.ruoyi.webtopo.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * svg与设备绑定对象 webtopo_device_svgnode
 * 
 * @author yaolunmao
 * @date 2023-02-15
 */
public class WebtopoDeviceSvgnode
{
    private static final long serialVersionUID = 1L;

    /** 项目id */
    @Excel(name = "项目id")
    private Long projectId;

    /** 设备id */
    @Excel(name = "设备id")
    private Long deviceId;

    /** 节点id */
    @Excel(name = "节点id")
    private String svgNodeId;

    /** 节点属性 */
    @Excel(name = "节点属性")
    private String svgNodeProp;

    /** 设备属性 */
    @Excel(name = "设备属性")
    private String deviceProp;

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
    public void setSvgNodeId(String svgNodeId) 
    {
        this.svgNodeId = svgNodeId;
    }

    public String getSvgNodeId() 
    {
        return svgNodeId;
    }
    public void setSvgNodeProp(String svgNodeProp) 
    {
        this.svgNodeProp = svgNodeProp;
    }

    public String getSvgNodeProp() 
    {
        return svgNodeProp;
    }
    public void setDeviceProp(String deviceProp) 
    {
        this.deviceProp = deviceProp;
    }

    public String getDeviceProp() 
    {
        return deviceProp;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("projectId", getProjectId())
            .append("deviceId", getDeviceId())
            .append("svgNodeId", getSvgNodeId())
            .append("svgNodeProp", getSvgNodeProp())
            .append("deviceProp", getDeviceProp())
            .toString();
    }
}
