package com.ruoyi.webtopo.mapper;

import java.util.List;
import com.ruoyi.webtopo.domain.WebtopoDeviceSvgnode;
import com.ruoyi.webtopo.domain.WebtopoWebSocketDevice;

/**
 * svg与设备绑定Mapper接口
 * 
 * @author yaolunmao
 * @date 2023-02-15
 */
public interface WebtopoDeviceSvgnodeMapper 
{
    /**
     * 查询svg与设备绑定
     * 
     * @param projectId svg与设备绑定主键
     * @return svg与设备绑定
     */
    public WebtopoDeviceSvgnode selectWebtopoDeviceSvgnodeByProjectId(Long projectId);

    /**
     * 查询svg与设备绑定列表
     * 
     * @param webtopoDeviceSvgnode svg与设备绑定
     * @return svg与设备绑定集合
     */
    public List<WebtopoDeviceSvgnode> selectWebtopoDeviceSvgnodeList(WebtopoDeviceSvgnode webtopoDeviceSvgnode);

    /**
     * 新增svg与设备绑定
     * 
     * @param webtopoDeviceSvgnode svg与设备绑定
     * @return 结果
     */
    public int insertWebtopoDeviceSvgnode(WebtopoDeviceSvgnode webtopoDeviceSvgnode);

    /**
     * 修改svg与设备绑定
     * 
     * @param webtopoDeviceSvgnode svg与设备绑定
     * @return 结果
     */
    public int updateWebtopoDeviceSvgnode(WebtopoDeviceSvgnode webtopoDeviceSvgnode);

    /**
     * 删除svg与设备绑定
     * 
     * @param projectId svg与设备绑定主键
     * @return 结果
     */
    public int deleteWebtopoDeviceSvgnodeByProjectId(Long projectId);

    /**
     * 批量删除svg与设备绑定
     * 
     * @param projectIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteWebtopoDeviceSvgnodeByProjectIds(Long[] projectIds);

    /**
     * 解除svg与设备绑定
     *
     * @param webtopoDeviceSvgnode svg与设备绑定
     * @return 结果
     */
    public int unbindWebtopoDeviceSvgnode(WebtopoDeviceSvgnode webtopoDeviceSvgnode);

    /**
     * 查询svg与设备绑定列表
     *
     * @return svg与设备绑定集合
     */
    public List<WebtopoDeviceSvgnode> selectWebtopoDeviceSvgnodeByPropList(WebtopoWebSocketDevice webtopoWebSocketDevice);
}
