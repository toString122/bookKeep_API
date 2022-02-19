//uni.request 封装
//如在config.js中 我们导出了一个基础域名
// process.env.NODE_ENV = prod




export const baseUrl = 'https://pojo.space:8090';

// export const baseUrl = 'http://127.0.0.1:8090';




const request = (parameter) => {
	uni.showLoading({
		title: '加载中...',
		mask: true,
	});
	return new Promise((resolve, reject) => {
		const token = uni.getStorageSync('slToken');
		if (parameter.header==undefined) {
			parameter.header={Authorization: "Bearer " + token};
		} else {
			parameter.header.Authorization = "Bearer " + token;
		}
		// parameter.header ? parameter.header.Authorization= 

		if (process.env.NODE_ENV === 'development') {
			console.log('网络参数', {
				method: parameter.method,
				url: baseUrl + parameter.url,
				data: parameter.data,
				header: parameter.header,
				dataType: 'json',
			})
		}

		uni.request({
			method: parameter.method,
			url: baseUrl + parameter.url,
			data: parameter.data,
			header: parameter.header,
			dataType: 'json',
		}).then((resData) => {
			//  
			var statusCode = 200;
			if (resData[1].statusCode === 200) {
				setTimeout(function() {
					uni.hideLoading();
				}, 2000);
				let [error, res] = resData;
				uni.hideLoading();
				parameter.success && parameter.success(res.data);
				resolve(res.data);
			} else if (resData[1].statusCode === 401) {
				//未登陆跳转到登陆 或者有token token过期 换取新的token 
				resolve(reLogin(parameter));
			} else {
				uni.showToast({
					title: '请求失败',
					duration: 2000,
					icon: 'none'
				});
				reject("出错了")
			}
		}).catch(error => {
			let [err, res] = error;
			uni.hideLoading();
			uni.showToast({
				title: '请求失败',
				duration: 2000,
				icon: 'none'
			});
			parameter.fail && parameter.fail(err);
			reject(err)
		})
	});
}

var count = 0;
const reLogin = async function(parameter) {
	const token = uni.getStorageSync('refreshToken');
	if (token && token.length > 0) { //token&&token.length>0 
		count++;
		//有老的token 
		await uni.request({
			method: "post",
			url: baseUrl + "/account/refreshToken?token=" + token,
			data: {},
			dataType: 'json',
		}).then((resData) => {
			console.log("-------------");
			console.log(resData);
			console.log("-------------");
			let [error, res] = resData;
			if (res.data.result === true) {
				console.log("-----true--------");
				uni.setStorageSync('slToken', res.data.data.accessToken);
				uni.setStorageSync('refreshToken', res.data.data.refreshToken);
				request(parameter)
				console.log("-----true--------");
			} else {
				//请求失败跳转到登陆页面
				uni.hideLoading();
				let routes = getCurrentPages();
				uni.navigateTo({
					url: "/pages/login/login?backurl=/" + routes[routes.length - 1].route
				});
			}

		}).catch(error => {
			let [err, res] = error;
			uni.hideLoading();
			uni.showToast({
				title: '请求失败',
				duration: 2000,
				icon: 'none'
			});
		})

		//request(res);
	} else {
		//没有token 跳转到登陆页面进行登陆
		uni.hideLoading();
		let routes = getCurrentPages();
		uni.navigateTo({
			url: "/pages/login/login?backurl=/" + routes[routes.length - 1].route
		});
	}
}

export default request