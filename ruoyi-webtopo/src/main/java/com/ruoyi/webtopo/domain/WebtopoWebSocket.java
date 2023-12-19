package com.ruoyi.webtopo.domain;

import com.ruoyi.common.annotation.Excel;

import java.util.List;

public class WebtopoWebSocket {
    /** 项目id */
    private Long projectId;

    public Long getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Long deviceId) {
        this.deviceId = deviceId;
    }

    /** 设备id */
    private Long deviceId;

    public List<WebtopoWebSocketDeviceProps> getProps() {
        return props;
    }

    public void setProps(List<WebtopoWebSocketDeviceProps> props) {
        this.props = props;
    }

    /** 设备属性信息 */
    private List<WebtopoWebSocketDeviceProps> props;

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

}
