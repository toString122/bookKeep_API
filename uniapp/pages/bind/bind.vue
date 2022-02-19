<template>
	<view class="content">
		<StatusBar title="绑定手机号" bgColor="light bg-brown"></StatusBar>
		<view>
			
			<view class="cu-form-group margin-top">
				<view class="title">姓名</view>
				<input style="height: 35px;" v-model="nickName" name="input" type="text"></input>
			</view>
			
			<view class="cu-form-group margin-top">
				<view class="title">手机号</view>
				<input style="height: 35px;" v-model="phone" name="input" type="text"></input>
				<button class='cu-btn bg-green shadow' open-type="getPhoneNumber"
					@getphonenumber="getPhoneNumber">获取手机号</button>
			</view>
			
			<view class="cu-form-group margin-top">
				<view class="title">密码</view>
				<input style="height: 35px;" v-model="password" name="input"  type="password"></input>
			</view>
			
			<button class="cu-btn block bg-blue margin-tb-sm lg" @click="savePhone">
				提交
			</button>
		</view>
	</view>
</template>

<script>
	import StatusBar from '../components/statusBar.vue'
	import {
		getPhone,getUserInfo,bindPhone
	} from '@/api/index/index.js'; //引入需要的api
	export default {
		components: {
			StatusBar
		},
		data() {
			return {
				code: "",
				sessionKey: '',
				encryptedData: "",
				iv: "",
				OpenId: '',
				nickName: null,
				avatarUrl: null,
				phone:"",
				password:""
			}
		},
		onLoad(option) {
			console.log("option", option)
			this.login()
		},
		methods: {
			savePhone:function(){
				var data = {
					phone: this.phone,
					password: this.password,
					nickName:this.nickName
				};
				bindPhone(data, (res) => {
					if (res.result === true) {
						console.log(res);
						uni.showToast({
							title: "绑定成功",
							duration: 2000,
							icon: 'none'
						});
					} else {
						uni.showToast({
							title: "绑定失败",
							duration: 2000,
							icon: 'none'
						});
					}
				})
			},
			login() {
				let _this = this;
				uni.showLoading({
					title: '登录中...'
				});
				uni.login({
					provider: 'weixin',
					success: function(loginRes) {
						console.log("登录", loginRes.code)
						_this.code = loginRes.code;
						//获取
						let code = loginRes.code;
						let appid = "wxcca7a9f80f6ef8f0" //需替换
						let secret = "3c89ceb8d5fbafe337ef7487647f0792" //需替换
						let url = 'https://api.weixin.qq.com/sns/jscode2session?appid=' + appid +
							'&secret=' + secret +
							'&js_code=' +
							code + '&grant_type=authorization_code';
						uni.request({
							url: url, // 请求路径
							success: res0 => {
								console.log(res0);
								_this.OpenId = res0.data.openid;
								console.log("_this.OpenId------------"+_this.OpenId);
								_this.sessionKey = res0.data.session_key;
								console.log("_this.sessionKey------------"+_this.sessionKey);
								getUserInfo({}, (res) => {
									if (res.result === true) {
										console.log(res);
										console.log(res.data.phone);
										_this.phone=res.data.phone;
										_this.nickName=res.data.nickName;
										_this.password=res.data.password;
									} else {
										uni.showToast({
											title: "获取手机号失败",
											duration: 2000,
											icon: 'none'
										});
									}
								})
								
								
							}
						})
						uni.hideLoading();
					},
				})
			},
			getPhoneNumber: function(e) {
				this.encryptedData = e.detail.encryptedData
				this.iv = e.detail.iv
				console.log("this.encryptedData:----------" + this.encryptedData)
				console.log("this.iv:----------" + this.iv)
				console.log("this.sessionKey:----------" + this.sessionKey)
				//解密
				var data = {
					encryptedData: this.encryptedData,
					iv: this.iv,
					sessionKey: this.sessionKey
				};
				getPhone(data, (res) => {
					if (res.result === true) {
						console.log(res);
						uni.showToast({
							title: "绑定成功",
							duration: 2000,
							icon: 'none'
						});
					} else {
						uni.showToast({
							title: res.msg,
							duration: 2000,
							icon: 'none'
						});
					}
				})
			}

		}
	}
</script>

<style>
</style>
