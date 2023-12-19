import request from '@/utils/request'

// 查询svg与设备绑定列表
export function listSvgnode(query) {
  return request({
    url: '/webtopo/svgnode/list',
    method: 'get',
    params: query
  })
}

// 查询svg与设备绑定详细
export function getSvgnode(projectId) {
  return request({
    url: '/webtopo/svgnode/' + projectId,
    method: 'get'
  })
}

// 新增svg与设备绑定
export function addSvgnode(data) {
  return request({
    url: '/webtopo/svgnode',
    method: 'post',
    data: data
  })
}

// 修改svg与设备绑定
export function updateSvgnode(data) {
  return request({
    url: '/webtopo/svgnode',
    method: 'put',
    data: data
  })
}

// 删除svg与设备绑定
export function delSvgnode(projectId) {
  return request({
    url: '/webtopo/svgnode/' + projectId,
    method: 'delete'
  })
}
//解除与设备绑定
export function unBindSvgnode(data) {
  return request({
    url: '/webtopo/svgnode/unbind',
    method: 'delete',
    data: data
  })
}