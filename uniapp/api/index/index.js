import request from '@/common/request.js'
export function login(data,success,fail,complete) {
  return request({
    url: '/account/login',
    method: 'post',
    data,
    success,
	fail,
    complete
  })
}

export function getUserInfo(data,success,fail,complete) {
  return request({
    url: '/account/getUserInfo',
    method: 'Post',
    data ,
    success,
	fail,
    complete
  })
}

export function getPhone(data,success,fail,complete) {
  return request({
    url: '/account/getPhone',
    method: 'Post',
    data ,
    success,
	fail,
    complete
  })
}

export function bindPhone(data,success,fail,complete) {
  return request({
    url: '/account/bindPhone',
    method: 'Post',
    data ,
    success,
	fail,
    complete
  })
}
export function oAuthLogin(data,success,fail,complete) {
  return request({
    url: '/account/oAuthLogin',
    method: 'Post',
    data ,
    success,
	fail,
    complete
  })
}