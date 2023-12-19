package com.ruoyi.webtopo.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.webtopo.mapper.WebtopoDeviceMapper;
import com.ruoyi.webtopo.domain.WebtopoDevice;
import com.ruoyi.webtopo.service.IWebtopoDeviceService;

import static com.ruoyi.common.utils.SecurityUtils.getUsername;

/**
 * 设备列表Service业务层处理
 * 
 * @author 咬轮猫
 * @date 2023-02-08
 */
@Service
public class WebtopoDeviceServiceImpl implements IWebtopoDeviceService 
{
    @Autowired
    private WebtopoDeviceMapper webtopoDeviceMapper;

    /**
     * 查询设备列表
     * 
     * @param id 设备列表主键
     * @return 设备列表
     */
    @Override
    public WebtopoDevice selectWebtopoDeviceById(Long id)
    {
        return webtopoDeviceMapper.selectWebtopoDeviceById(id);
    }

    /**
     * 查询设备列表列表
     * 
     * @param webtopoDevice 设备列表
     * @return 设备列表
     */
    @Override
    public List<WebtopoDevice> selectWebtopoDeviceList(WebtopoDevice webtopoDevice)
    {
        return webtopoDeviceMapper.selectWebtopoDeviceList(webtopoDevice);
    }

    /**
     * 新增设备列表
     * 
     * @param webtopoDevice 设备列表
     * @return 结果
     */
    @Override
    public int insertWebtopoDevice(WebtopoDevice webtopoDevice)
    {
        webtopoDevice.setCreateTime(DateUtils.getNowDate());
        return webtopoDeviceMapper.insertWebtopoDevice(webtopoDevice);
    }

    /**
     * 修改设备列表
     * 
     * @param webtopoDevice 设备列表
     * @return 结果
     */
    @Override
    public int updateWebtopoDevice(WebtopoDevice webtopoDevice)
    {
        webtopoDevice.setUpdateTime(DateUtils.getNowDate());
        webtopoDevice.setUpdateBy(getUsername());
        return webtopoDeviceMapper.updateWebtopoDevice(webtopoDevice);
    }

    /**
     * 批量删除设备列表
     * 
     * @param ids 需要删除的设备列表主键
     * @return 结果
     */
    @Override
    public int deleteWebtopoDeviceByIds(Long[] ids)
    {
        return webtopoDeviceMapper.deleteWebtopoDeviceByIds(ids);
    }

    /**
     * 删除设备列表信息
     * 
     * @param id 设备列表主键
     * @return 结果
     */
    @Override
    public int deleteWebtopoDeviceById(Long id)
    {
        return webtopoDeviceMapper.deleteWebtopoDeviceById(id);
    }
}
