import request from '@/utils/request'

// 查询项目列表列表
export function listProject(query) {
  return request({
    url: '/webtopo/project/list',
    method: 'get',
    params: query
  })
}

// 查询项目列表详细
export function getProject(projectId) {
  return request({
    url: '/webtopo/project/' + projectId,
    method: 'get'
  })
}

// 新增项目列表
export function addProject(data) {
  return request({
    url: '/webtopo/project',
    method: 'post',
    data: data
  })
}

// 修改项目列表
export function updateProject(data) {
  return request({
    url: '/webtopo/project',
    method: 'put',
    data: data
  })
}

// 删除项目列表
export function delProject(projectId) {
  return request({
    url: '/webtopo/project/' + projectId,
    method: 'delete'
  })
}

// 保存项目修改
export function saveProject(data) {
  return request({
    url: '/webtopo/project/save',
    method: 'put',
    data: data
  })
}