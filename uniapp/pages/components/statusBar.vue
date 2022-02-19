<template>
	<view class="cu-custom" :style="[{height:CustomBar + 'px'}]">
		<view class="cu-bar fixed" :style="style" :class="[bgImage!=''?'none-bg text-white bg-img':'',bgColor]">
			<view class="action" @tap="BackPage" v-if="isBack">
				<text class="cuIcon-back"></text>
				<slot name="backText">{{title}}</slot>
			</view>
		</view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				StatusBar: this.StatusBar,
				CustomBar: this.CustomBar,
			};
		},
		name: 'cu-custom',
		computed: {
			style() {
				var StatusBar = this.StatusBar;
				var CustomBar = this.CustomBar;
				var bgImage = this.bgImage;
				var style = `height:${CustomBar}px;padding-top:${StatusBar}px;`;
				if (this.bgImage) {
					style = `${style}background-image:url(${bgImage});`;
				}
				return style
			}
		},
		props: {
			bgColor: {
				type: String,
				default: 'bg-white'
			},
			isBack: {
				type: [Boolean, String],
				default: true
			},
			bgImage: {
				type: String,
				default: ''
			},
			title: {
				type: String,
				default: '返回'
			}
		},
		methods: {
			BackPage() {
				if (getCurrentPages().length < 2 && 'undefined' !== typeof __wxConfig) {
					let url = '/' + __wxConfig.pages[0]
					console.log("++++++++"+url)
					return uni.redirectTo({
						url
					})
				}else{
					console.log("000000000000000000000")
				}
				uni.navigateBack({
					delta: 1
				});
			}
		}
	}
</script>

<style>
</style>
