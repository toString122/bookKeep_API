import request from '@/common/request.js'

export function getHelpDetail(data, success, fail, complete) {
	return request({
		url: '/help/getHelpDetail',
		method: 'Post',
		data,
		success,
		fail,
		complete
	})
}
export function uploadFile(header, data, filePaths, success, fail) {
	
}
