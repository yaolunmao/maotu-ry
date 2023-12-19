import request from '@/utils/request'

export function websocketSendMsgApi(query) {
  return request({
    url: '/webtopo/websocket/sendmsg',
    method: 'post',
    params: query
  })
}

export function simulationDeviceInfoApi(query) {
  return request({
    url: '/webtopo/websocket/simulationDeviceInfo',
    method: 'post',
    data: query
  })
}