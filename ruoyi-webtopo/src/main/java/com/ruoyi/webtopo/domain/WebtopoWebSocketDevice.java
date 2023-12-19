package com.ruoyi.webtopo.domain;

import java.util.List;

public class WebtopoWebSocketDevice {
    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public Long getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Long deviceId) {
        this.deviceId = deviceId;
    }

    public List<String> getDeviceProp() {
        return deviceProp;
    }

    public void setDeviceProp(List<String> deviceProp) {
        this.deviceProp = deviceProp;
    }

    private Long projectId;
    private Long deviceId;
    private List<String> deviceProp;
}
