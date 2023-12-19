package com.ruoyi.webtopo.domain;

import java.util.List;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 项目列对象 webtopo_project
 * 
 * @author yaolunmao
 * @date 2023-02-10
 */
public class WebtopoProject extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 项目id */
    private Long projectId;

    /** 项目名称 */
    @Excel(name = "项目名称")
    private String projectName;

    /** 缩略图 */
    @Excel(name = "缩略图")
    private String thumbnail;

    /** 数据模型 */
    @Excel(name = "数据模型")
    private String dataModel;
    /** 项目关联设备信息 */
    private List<WebtopoProjectDevice> deviceList;

    public List<WebtopoProjectDevice> getDeviceList() {
        return deviceList;
    }

    public void setDeviceList(List<WebtopoProjectDevice> deviceList) {
        this.deviceList = deviceList;
    }

    public void setProjectId(Long projectId) 
    {
        this.projectId = projectId;
    }

    public Long getProjectId() 
    {
        return projectId;
    }
    public void setProjectName(String projectName) 
    {
        this.projectName = projectName;
    }

    public String getProjectName() 
    {
        return projectName;
    }
    public void setThumbnail(String thumbnail) 
    {
        this.thumbnail = thumbnail;
    }

    public String getThumbnail() 
    {
        return thumbnail;
    }
    public void setDataModel(String dataModel) 
    {
        this.dataModel = dataModel;
    }

    public String getDataModel() 
    {
        return dataModel;
    }


    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("projectId", getProjectId())
            .append("projectName", getProjectName())
            .append("thumbnail", getThumbnail())
            .append("dataModel", getDataModel())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .append("deviceList", getDeviceList())
            .toString();
    }
}
