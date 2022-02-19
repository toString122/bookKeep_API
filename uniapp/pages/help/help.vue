<template>
	<view class="content">
		<StatusBar title="帮助中心" bgColor="light bg-brown"></StatusBar>
		<view>
			<view class="cu-card article">
				<view class="cu-item shadow" @click="showDatail" data-url='/pages/help/help_detail'>
					<view class="title">
						<view class="text-cut">无意者 烈火焚身;以正义的烈火拔出黑暗。我有自己的正义，见证至高的烈火吧。</view>
					</view>
					<view class="content">
						<image src="https://ossweb-img.qq.com/images/lol/web201310/skin/big10006.jpg"></image>
						<view class="desc">
							<view class="text-content" style="height: 6.5em;">
								折磨生出苦难，苦难又会加剧折磨，凡间这无穷的循环，将有我来终结！真正的恩典因不完整而美丽，因情感而真诚，因脆弱而自由！
							</view>
						</view>
					</view>
				</view>
				<view class="cu-item shadow">
					<view class="title">
						<view class="text-cut">无意者 烈火焚身;以正义的烈火拔出黑暗。我有自己的正义，见证至高的烈火吧。</view>
					</view>
					<view class="content">
						<image src="https://ossweb-img.qq.com/images/lol/web201310/skin/big10006.jpg"></image>
						<view class="desc">
							<view class="text-content" style="height: 6.5em;">
								折磨生出苦难，苦难又会加剧折磨，凡间这无穷的循环，将有我来终结！真正的恩典因不完整而美丽，因情感而真诚，因脆弱而自由！
							</view>
						</view>
					</view>
				</view>
				<view class="cu-item shadow">
					<view class="title">
						<view class="text-cut">无意者 烈火焚身;以正义的烈火拔出黑暗。我有自己的正义，见证至高的烈火吧。</view>
					</view>
					<view class="content">
						<image src="https://ossweb-img.qq.com/images/lol/web201310/skin/big10006.jpg"></image>
						<view class="desc">
							<view class="text-content" style="height: 6.5em;">
								折磨生出苦难，苦难又会加剧折磨，凡间这无穷的循环，将有我来终结！真正的恩典因不完整而美丽，因情感而真诚，因脆弱而自由！
							</view>
						</view>
					</view>
				</view>
			</view>
		</view>
	</view>
</template>

<script>
	import StatusBar from '../components/statusBar.vue'
	export default {
		components: {
			StatusBar
		},
		data() {
			return {

			}
		},
		methods: {
			showDatail:function(e){
				console.log("111111111111");
				console.log(e.currentTarget.dataset.url);
				uni.navigateTo({
					url: e.currentTarget.dataset.url+"?id=1999"
				})
				console.log("222222222");
			}
		}
	}
</script>

<style>

</style>
