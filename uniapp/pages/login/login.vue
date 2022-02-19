<template>

	<!-- //微信登陆 -->
	<view class="content">

		<!-- #ifdef MP-WEIXIN -->
		<view class="mp_login">
			<cu-custom bgColor="bg-white" :isBack="true">
				<block slot="backText">返回</block>
				<block slot="content">登录</block>
			</cu-custom>
			<view class="flex padding justify-center" style="height: 400upx;">

			</view>

			<view class="flex padding justify-center">
				<view class="cu-avatar round xl bg-yellow iconfont icon-jizhangben text-white"></view>
			</view>
			<button class="cu-btn block bg-yellow margin-xl lg text-white " @getuserinfo="userLogin"
				open-type="getUserInfo">
				<!-- cuIcon-loading2 -->
				<text class="cuIconfont-spin"></text> 授权登录
			</button>
		</view>
		<!-- #endif -->
		<!-- #ifdef APP-PLUS || H5 -->
		<view class="applogin margin">
			<view class="flex padding justify-center" style="height: 200upx;">

			</view>
			<view class="flex padding justify-center">
				<view class="cu-avatar round xl bg-yellow iconfont icon-jizhangben text-white"></view>
			</view>
			<form>
				<view class="cu-form-group margin-top">
					<view class="title">用户名</view>
					<input style="height: 35px;" placeholder="登录名/手机号" v-model="userModel.phone" name="input"></input>
				</view>
				<view class="cu-form-group">
					<view class="title">密码</view>
					<input style="height: 35px;" placeholder="请输入密码" type="password" v-model="userModel.password"
						name="input"></input>
				</view>
				<button class="cu-btn block bg-yellow margin-top lg text-white " @click="appUserLogin">
					<!-- cuIcon-loading2 -->
					<text class="cuIconfont-spin"></text> 登录
				</button>
			</form>
		</view>
		<!-- #endif -->
	</view>


</template>

<script>
	import {
		login,
		getUserInfo,
		oAuthLogin
	} from '@/api/index/index.js'; //引入需要的api

	export default {
		data() {
			return {
				title: 'Hello',
				backUrl: '',
				userModel: {
					phone: '',
					password: '',
					loginType: 1
				}
			}
		},
		onLoad(option) {
			console.log("option", option)
			this.backUrl = option.backurl || '/pages/index/index'
		},
		methods: {
			appUserLogin: function() {
				var that = this;
				login(that.userModel, (res) => {
					if (res.result === true) {
						uni.setStorageSync("slToken", res.data.accessToken)
						uni.setStorageSync("refreshToken", res.data.refreshToken)
						uni.showToast({
							title: '登录成功',
							duration: 2000,
							icon: 'none'
						});
						uni.redirectTo({
							url: that.backUrl
						});
					} else {
						uni.showToast({
							title: res.msg,
							duration: 2000,
							icon: 'none'
						});
					}
				})
			},
			alertShow: function() {

				/* uni.showToast({
				    title: '测试',
				    duration: 2000,
					icon:'none'
				}); */
				uni.showLoading({
					title: '加载中'
				});
			},
			userLogin: function(e) {
				uni.login({
					timeout: 10000,
					provider: 'weixin', //如果是uniapp，在这里需要标明平台的类型，支持的参数请查阅uniapp官网的uni.login()文档
					success: (res1) => {
						console.log("要获取openId")
						let code = res1.code;
						let appid = "wxd7265bbb6f983342" //需替换
						let secret = "81e2e51775616aac7ce30e08b2ab60b9" //需替换
						let url = 'https://api.weixin.qq.com/sns/jscode2session?appid=' + appid +
							'&secret=' + secret +
							'&js_code=' +
							code + '&grant_type=authorization_code';
						uni.request({
							url: url, // 请求路径
							success: res0 => {
								console.log(res0);
								let openId = res0.data.openid
								//登陆成功的回调
								uni.getUserInfo({
									success: (res) => {
										console.log(res.userInfo);
										res.userInfo.openId = openId;
										//再获取下手机号试试
										oAuthLogin({
											code: res.code,
											oAuthType: 1,
											userInfo: res.userInfo
										}, res => {
											console.log(res);
											if (res.result === true) {
												console.log(
													"------------- start "
													);
												console.log(
													"-------------" +
													this.backUrl);
												uni.setStorageSync(
													"slToken", res.data
													.accessToken)
												uni.setStorageSync(
													"refreshToken", res
													.data
													.refreshToken)
												uni.redirectTo({
													url: this
														.backUrl
												});
												uni.showToast({
													title: '登录成功',
													duration: 2000,
													icon: 'none'
												});

											} else {
												uni.showToast({
													title: res.Msg,
													duration: 2000,
													icon: 'none'
												});
											}
										});
									},
									fail: () => {
										uni.showToast({
											title: '授权登录失败',
											duration: 2000,
											icon: 'none'
										});
									}
								});
							}
						});
					},
					fail: (err) => {
						uni.showToast({
							title: '授权登录失败',
							duration: 2000,
							icon: 'none'
						});
					}
				})



			}

		}
	}
</script>

<style scoped>
	.backgroundimage {
		width: 100%;
		height: auto;
	}

	.cu-form-group .title {
		min-width: calc(4em + 15px);
	}
</style>
