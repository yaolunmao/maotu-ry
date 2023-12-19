package com.ruoyi.webtopo.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 设备列表对象 webtopo_device
 * 
 * @author 咬轮猫
 * @date 2023-02-08
 */
public class WebtopoDevice extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 设备id */
    private Long deviceId;

    /** 设备名称 */
    @Excel(name = "设备名称")
    private String name;

    /** 设备分类 */
    @Excel(name = "设备分类")
    private String type;

    /** 设备状态 */
    @Excel(name = "设备状态")
    private String state;

    public void setId(Long deviceId)
    {
        this.deviceId = deviceId;
    }

    public Long getId() 
    {
        return deviceId;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setType(String type) 
    {
        this.type = type;
    }

    public String getType() 
    {
        return type;
    }
    public void setState(String state) 
    {
        this.state = state;
    }

    public String getState() 
    {
        return state;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("deviceId", getId())
            .append("name", getName())
            .append("type", getType())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("state", getState())
            .append("remark", getRemark())
            .toString();
    }
}
