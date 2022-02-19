<template>
	<view class="content">
		<StatusBar title="帮助中心" bgColor="light bg-brown"></StatusBar>
		<view>
			<view class="cu-card article">
				<view class="cu-item shadow">
					<view class="title">
						<view style="text-align: center;">无意者 烈火焚身;以正义的烈火拔出黑暗。我有自己的正义，见证至高的烈火吧。</view>
					</view>
					<view class="content">
						折磨生出苦难，苦难又会加剧折磨，凡间这无穷的循环，将有我来终结！真正的恩典因不完整而美丽，因情感而真诚，因脆弱而自由！
						折磨生出苦难，苦难又会加剧折磨，凡间这无穷的循环，将有我来终结！真正的恩典因不完整而美丽，因情感而真诚，因脆弱而自由！
						折磨生出苦难，苦难又会加剧折磨，凡间这无穷的循环，将有我来终结！真正的恩典因不完整而美丽，因情感而真诚，因脆弱而自由！
						折磨生出苦难，苦难又会加剧折磨，凡间这无穷的循环，将有我来终结！真正的恩典因不完整而美丽，因情感而真诚，因脆弱而自由！
						折磨生出苦难，苦难又会加剧折磨，凡间这无穷的循环，将有我来终结！真正的恩典因不完整而美丽，因情感而真诚，因脆弱而自由！
					</view>
				</view>
			</view>
		</view>
	</view>
</template>

<script>
	import StatusBar from '../components/statusBar.vue'
	import {
		getHelpDetail
	} from "@/api/help/help.js"
	export default {
		components: {
			StatusBar
		},
		onLoad(option) {
			this.id = option.id;
			console.log(this.id);
			//获取详情信息
			getHelpDetail({'id':this.id}, res => {
				console.log("getHelpDetail返回数据", res)
				
			})

		},
		data() {
			return {
				id: 1
			}
		},
		methods: {

		}
	}
</script>

<style>

</style>
