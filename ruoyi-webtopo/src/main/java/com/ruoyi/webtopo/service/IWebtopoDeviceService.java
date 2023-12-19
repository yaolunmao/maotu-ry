package com.ruoyi.webtopo.service;

import java.util.List;
import com.ruoyi.webtopo.domain.WebtopoDevice;

/**
 * 设备列表Service接口
 * 
 * @author 咬轮猫
 * @date 2023-02-08
 */
public interface IWebtopoDeviceService 
{
    /**
     * 查询设备列表
     * 
     * @param id 设备列表主键
     * @return 设备列表
     */
    public WebtopoDevice selectWebtopoDeviceById(Long id);

    /**
     * 查询设备列表列表
     * 
     * @param webtopoDevice 设备列表
     * @return 设备列表集合
     */
    public List<WebtopoDevice> selectWebtopoDeviceList(WebtopoDevice webtopoDevice);

    /**
     * 新增设备列表
     * 
     * @param webtopoDevice 设备列表
     * @return 结果
     */
    public int insertWebtopoDevice(WebtopoDevice webtopoDevice);

    /**
     * 修改设备列表
     * 
     * @param webtopoDevice 设备列表
     * @return 结果
     */
    public int updateWebtopoDevice(WebtopoDevice webtopoDevice);

    /**
     * 批量删除设备列表
     * 
     * @param ids 需要删除的设备列表主键集合
     * @return 结果
     */
    public int deleteWebtopoDeviceByIds(Long[] ids);

    /**
     * 删除设备列表信息
     * 
     * @param id 设备列表主键
     * @return 结果
     */
    public int deleteWebtopoDeviceById(Long id);
}
