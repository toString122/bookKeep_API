(global["webpackJsonp"]=global["webpackJsonp"]||[]).push([["pages/login/login"],{"1dd1":function(e,o,n){"use strict";n.r(o);var t=n("b9d0"),c=n("b781");for(var r in c)"default"!==r&&function(e){n.d(o,e,(function(){return c[e]}))}(r);n("2866");var a,s=n("f0c5"),i=Object(s["a"])(c["default"],t["b"],t["c"],!1,null,"7f40a079",null,!1,t["a"],a);o["default"]=i.exports},2866:function(e,o,n){"use strict";var t=n("eda5"),c=n.n(t);c.a},"541f":function(e,o,n){"use strict";(function(e){n("885c");t(n("66fd"));var o=t(n("1dd1"));function t(e){return e&&e.__esModule?e:{default:e}}wx.__webpack_require_UNI_MP_PLUGIN__=n,e(o.default)}).call(this,n("543d")["createPage"])},8244:function(e,o,n){"use strict";(function(e){Object.defineProperty(o,"__esModule",{value:!0}),o.default=void 0;var t=n("42e1"),c={data:function(){return{title:"Hello",backUrl:"",userModel:{phone:"",password:"",loginType:1}}},onLoad:function(e){console.log("option",e),this.backUrl=e.backurl||"/pages/index/index"},methods:{appUserLogin:function(){var o=this;(0,t.login)(o.userModel,(function(n){!0===n.result?(e.setStorageSync("slToken",n.data.accessToken),e.setStorageSync("refreshToken",n.data.refreshToken),e.showToast({title:"登录成功",duration:2e3,icon:"none"}),e.redirectTo({url:o.backUrl})):e.showToast({title:n.msg,duration:2e3,icon:"none"})}))},alertShow:function(){e.showLoading({title:"加载中"})},userLogin:function(o){var n=this;e.login({timeout:1e4,provider:"weixin",success:function(o){console.log("要获取openId");var c=o.code,r="wxcca7a9f80f6ef8f0",a="3c89ceb8d5fbafe337ef7487647f0792",s="https://api.weixin.qq.com/sns/jscode2session?appid="+r+"&secret="+a+"&js_code="+c+"&grant_type=authorization_code";e.request({url:s,success:function(o){console.log(o);var c=o.data.openid;e.getUserInfo({success:function(o){console.log(o.userInfo),o.userInfo.openId=c,(0,t.oAuthLogin)({code:o.code,oAuthType:1,userInfo:o.userInfo},(function(o){console.log(o),!0===o.result?(console.log("------------- start "),console.log("-------------"+n.backUrl),e.setStorageSync("slToken",o.data.accessToken),e.setStorageSync("refreshToken",o.data.refreshToken),e.redirectTo({url:n.backUrl}),e.showToast({title:"登录成功",duration:2e3,icon:"none"})):e.showToast({title:o.Msg,duration:2e3,icon:"none"})}))},fail:function(){e.showToast({title:"授权登录失败",duration:2e3,icon:"none"})}})}})},fail:function(o){e.showToast({title:"授权登录失败",duration:2e3,icon:"none"})}})}}};o.default=c}).call(this,n("543d")["default"])},b781:function(e,o,n){"use strict";n.r(o);var t=n("8244"),c=n.n(t);for(var r in t)"default"!==r&&function(e){n.d(o,e,(function(){return t[e]}))}(r);o["default"]=c.a},b9d0:function(e,o,n){"use strict";var t;n.d(o,"b",(function(){return c})),n.d(o,"c",(function(){return r})),n.d(o,"a",(function(){return t}));var c=function(){var e=this,o=e.$createElement;e._self._c},r=[]},eda5:function(e,o,n){}},[["541f","common/runtime","common/vendor"]]]);