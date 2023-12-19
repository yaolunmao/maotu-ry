import request from '@/utils/request'

// 查询设备列列表
export function listDevice(query) {
  return request({
    url: '/webtopo/device/list',
    method: 'get',
    params: query
  })
}

// 查询设备列详细
export function getDevice(id) {
  return request({
    url: '/webtopo/device/' + id,
    method: 'get'
  })
}

// 新增设备列
export function addDevice(data) {
  return request({
    url: '/webtopo/device',
    method: 'post',
    data: data
  })
}

// 修改设备列
export function updateDevice(data) {
  return request({
    url: '/webtopo/device',
    method: 'put',
    data: data
  })
}

// 删除设备列
export function delDevice(id) {
  return request({
    url: '/webtopo/device/' + id,
    method: 'delete'
  })
}
//获取全部设备
export function listDeviceAll() {
  return request({
    url: '/webtopo/device/listAll',
    method: 'get'
  })
}