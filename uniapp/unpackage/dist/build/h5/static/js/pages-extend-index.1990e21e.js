(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["pages-extend-index"],{"0099":function(e,n,t){var i=t("24fb");n=i(!1),n.push([e.i,".backgroundimage[data-v-50d5186c]{width:100%;height:auto}",""]),e.exports=n},"6b0b":function(e,n,t){"use strict";(function(e){Object.defineProperty(n,"__esModule",{value:!0}),n.default=void 0;var i=t("42e1"),a={data:function(){return{title:"Hello",userInfo:{Email:"",IsVip:!1,Token:"",VIPExpirationTime:"0001-01-01",create_sig_time:"2020-12-14",deptname:"总公司",fk_DepartmentID:1,id:"",isok:0,login_name:"",remark:"",status:2,style:"1",suffix:"txl",true_name:"",usersig:"",worknum:""}}},onLoad:function(){},methods:{getUserInfo:function(){e("log","点击"," at pages/extend/index.vue:46");var n=this;(0,i.login)({}).then((function(t){e("log",t," at pages/extend/index.vue:49"),n.userInfo=t.Result}))},userLogin:function(){var n=this;(0,i.login)({Phone:"15617541119",Password:"123456",LoginType:1}).then((function(t){e("log",t," at pages/extend/index.vue:60"),n.userInfo=t.Result}))},alertShow:function(){uni.showLoading({title:"加载中"})}}};n.default=a}).call(this,t("0de9")["log"])},"9a0f":function(e,n,t){"use strict";var i;t.d(n,"b",(function(){return a})),t.d(n,"c",(function(){return o})),t.d(n,"a",(function(){return i}));var a=function(){var e=this,n=e.$createElement,t=e._self._c||n;return t("v-uni-view",{staticClass:"content"},[t("v-uni-view",[e._v("extend")])],1)},o=[]},a76d:function(e,n,t){var i=t("0099");"string"===typeof i&&(i=[[e.i,i,""]]),i.locals&&(e.exports=i.locals);var a=t("4f06").default;a("881cdfe6",i,!0,{sourceMap:!1,shadowMode:!1})},d754:function(e,n,t){"use strict";t.r(n);var i=t("9a0f"),a=t("eec1");for(var o in a)"default"!==o&&function(e){t.d(n,e,(function(){return a[e]}))}(o);t("f0ac");var u,r=t("f0c5"),s=Object(r["a"])(a["default"],i["b"],i["c"],!1,null,"50d5186c",null,!1,i["a"],u);n["default"]=s.exports},eec1:function(e,n,t){"use strict";t.r(n);var i=t("6b0b"),a=t.n(i);for(var o in i)"default"!==o&&function(e){t.d(n,e,(function(){return i[e]}))}(o);n["default"]=a.a},f0ac:function(e,n,t){"use strict";var i=t("a76d"),a=t.n(i);a.a}}]);