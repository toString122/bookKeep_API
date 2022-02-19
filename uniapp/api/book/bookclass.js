import request from '@/common/request.js'
 
export function getBookClassList(data,success,fail,complete) {
  return request({
    url: '/bookClass/getBookClassList',
    method: 'Post',
    data ,
    success,
	fail,
    complete
  })
}