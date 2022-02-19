import request from '@/common/request.js'
 
export function bookSave(data,success,fail,complete) {
  return request({
    url: '/book/save',
    method: 'Post',
    data ,
    success,
	fail,
    complete
  })
}

export function getBookList(data,success,fail,complete) {
  return request({
    url: '/book/getBookList',
    method: 'Post',
    data ,
    success,
	fail,
    complete
  })
}
export function deleteBook(data,success,fail,complete) {
  return request({
    url: '/book/deleteBook',
    method: 'Post',
    data ,
    success,
	fail,
    complete
  })
}