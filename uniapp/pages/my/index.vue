<template>
	<view class="content">
		<view class="bg-img flex align-center userbackground"
			style="background-image:url('https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fwww.zhiu.cn%2Fueditor%2Fphp%2Fupload%2Fimage%2F20190509%2F1557369063567162.jpg&refer=http%3A%2F%2Fwww.zhiu.cn&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1631375852&t=37df4cf223e6b9c75f1eec4db1da9c7f');height: 414upx;">
			<view class="padding-xl text-white">
				<view class="padding">
					<view class="cu-avatar round lg margin-left"
						:style="'background-image:url('+userInfo.avatarUrl+')'">
						<view class="cu-tag badge"
							:class="[userInfo.gender===2?'cuIcon-female bg-pink':'',userInfo.gender===1?'cuIcon-male bg-blue':'']">
						</view>
					</view>
					<view class="lg margin-sm ">
						{{userInfo.nickName}}
					</view>
				</view>
				<view class="padding-xs text-lg">

					<!-- Only the guilty need fear me. -->
				</view>
			</view>
		</view>
		<view class="cu-list menu" :class="[ 'sm-border', 'card-menu margin-top']">
			<view class="cu-item" :class=" 'arrow' ">
				<view class="content">
					<image src="/static/images/wujiao.png" class="png" mode="aspectFit"></image>
					<text class="text-grey">我的账单</text>
				</view>
			</view>
			<view class="cu-item" :class=" 'arrow' ">
				<view class="content">
					<image src="/static/images/cardbao.png" class="png" mode="aspectFit"></image>
					<text class="text-grey">我的卡包</text>
				</view>
			</view>
			<view class="cu-item" :class=" 'arrow' ">
				<view class="content">
					<image src="/static/images/qianbao.png" class="png" mode="aspectFit"></image>
					<text class="text-grey">我的积分</text>
				</view>
			</view>
			<view class="cu-item" :class=" 'arrow' ">
				<button class="cu-btn content" open-type="share">
					<image src="/static/images/feiji.png" class="png" mode="aspectFit"></image>
					<text class="text-grey">邀请好友</text>
				</button>
			</view>
			<!-- #ifdef MP-WEIXIN -->
			<view class="cu-item" :class=" 'arrow' " @click='goTo' data-url='/pages/bind/bind'>
				<view class="content">
					<image src="/static/images/user.png" class="png" mode="aspectFit"></image>
					<text class="text-grey">绑定手机</text>
				</view>
			</view>
			<!-- #endif -->
			<view class="cu-item" :class=" 'arrow' ">
				<button class="cu-btn content" open-type="contact">
					<image src="/static/images/kefu.png" class="png" mode="aspectFit"></image>
					<text class="text-grey">联系客服</text>
				</button>
			</view>

			<view class="cu-item" @click="exit" data-url="/pages/login/login">
				<view class="content">
					<image src="/static/images/exit.png" class="png" mode="aspectFit"></image>
					<text class="text-grey">退出</text>
				</view>
			</view>
		</view>

        <view class="cu-list menu" :class="[ 'sm-border', 'card-menu margin-top']" v-show="isShow" >
			<view class="cu-item" :class="adminMenuClass" @click="showAdminMenu">
				<view class="content">
					<image src="/static/images/guanliyuan.png" class="png" mode="aspectFit"></image>
					<text class="text-grey">后台管理员</text>
				</view>
			</view>
			<view class="cu-list grid col-3 no-border" v-show="isShowAdminMenu">
				<view class="cu-item">
					<view class="cuIcon-cardboardfill text-red">
						<view class="cu-tag badge">99+</view>
					</view>
					<text>会员管理</text>
				</view>
				<view class="cu-item">
					<view class="cuIcon-questionfill text-orange" @click='goTo' data-url='/pages/help/help_list'>
						<view class="cu-tag badge"></view>
					</view>
					<text>帮助管理</text>
				</view>
				<view class="cu-item">
					<view class="cuIcon-moneybag text-yellow">
					</view>
					<text>积分管理</text>
				</view>
			</view>
		</view>



		<view class="cu-list menu" :class="[ 'sm-border', 'card-menu margin-top']">

			<view class="cu-item" :class=" 'arrow'" @click='goTo' data-url='/pages/about/about'>
				<view class="content">
					<image src="/static/images/about.png" class="png" mode="aspectFit"></image>
					<text class="text-grey">关于开发者</text>
				</view>
			</view>

			<view class="cu-item" :class="'arrow'" @click='goTo' data-url='/pages/help/help'>
				<view class="content">
					<image src="/static/images/help.png" class="png" mode="aspectFit"></image>
					<text class="text-grey">帮助中心</text>
				</view>
			</view>
		</view>

	</view>
</template>

<script>
	import {
		getUserInfo
	} from "@/api/index/index.js"
	export default {
		data() {
			return {
				adminMenuClass: 'arrow',
				isShowAdminMenu:false,
				isShow: false,
				title: 'Hello',
				userInfo: {
					avatarUrl: '',
					nickName: ''
				},
			}
		},
		onLoad() {

		},
		created() {
			this.getUserInfo();
		},
		methods: {
			showAdminMenu:function(e){
				var that = this;
				if(!that.isShowAdminMenu){
					that.adminMenuClass='';
					that.isShowAdminMenu=true;
				}else{
					that.adminMenuClass='arrow';
					that.isShowAdminMenu=false;
				}
			},
			goTo: function(e) {
				uni.navigateTo({
					url: e.currentTarget.dataset.url
				})
			},
			exit: function(e) {
				uni.removeStorageSync("slToken");
				console.log(e.currentTarget.dataset.url);
				//this.$router.push({path:});
				uni.redirectTo({
					url: e.currentTarget.dataset.url
				});
			},
			getUserInfo: function() {
				var that = this;
				getUserInfo({}, res => {
					console.log("getUserInfo返回数据", res);
					if(res.data.role==='admin'){
						that.isShow=true;
					}else{
						that.isShow=false;
					}
					that.userInfo = res.data;
				})
			},
			alertShow: function() {

				uni.showToast({
					title: '测试',
					duration: 2000,
					icon: 'none'
				});
			}

		}
	}
</script>

<style scoped>
	.userbackground {
		border-bottom-left-radius: 25%;
		border-bottom-right-radius: 25%;
	}
</style>
