<template>
	<view class="content">
		<StatusBar title="关于开发者"  bgColor="bg-gradual-blue shadow-blur"></StatusBar>
		<view class="bg-img flex justify-center userbackground" style="background-image:url('https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fwww.zhiu.cn%2Fueditor%2Fphp%2Fupload%2Fimage%2F20190509%2F1557369063567162.jpg&refer=http%3A%2F%2Fwww.zhiu.cn&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1631375852&t=37df4cf223e6b9c75f1eec4db1da9c7f');height: 414upx;">
			<view class="justify-center text-white">
				<view class="padding">
					<view class="cu-avatar round lg" style="background-image:url('https://img1.baidu.com/it/u=466375822,957363774&fm=26&fmt=auto&gp=0.jpg')">
						<view class="cu-tag badge cuIcon-female bg-pink"></view>
					</view>
					<view class="lg margin-sm ">
						测试
					</view>
				</view>
				<view class="padding-xs text-lg">
					青春永不回来
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
			
		}
	}
</script>

<style>
	
</style>
