(global["webpackJsonp"]=global["webpackJsonp"]||[]).push([["pages/addmbook/addmbook"],{"11eb":function(t,e,o){"use strict";(function(t){Object.defineProperty(e,"__esModule",{value:!0}),e.default=void 0;var n=o("8646"),s=o("c510"),i=o("89ec"),l={data:function(){return{model:{billType:1,money:"0",remark:"",consumptionTime:this.getDate(),classId:""},classLength:30,InputBottom:0,bookinclasslist:[],bookoutclasslist:[],bookclasslist:[],currentClass:{}}},methods:{tabSelect:function(t){this.model.billType=t.currentTarget.dataset.id,2===parseInt(this.model.billType)?this.bookclasslist=this.bookinclasslist:1===parseInt(this.model.billType)&&(this.bookclasslist=this.bookoutclasslist),this.currentClass=this.bookclasslist[0],this.model.classId=this.currentClass.id},InputFocus:function(t){this.InputBottom=t.detail.height},InputBlur:function(t){this.InputBottom=0},bindDateChange:function(t){this.model.consumptionTime=t.target.value},getDate:function(t){var e=new Date,o=e.getFullYear(),n=e.getMonth()+1,s=e.getDate();return"start"===t?o-=60:"end"===t&&(o+=2),n=n>9?n:"0"+n,s=s>9?s:"0"+s,"".concat(o,"-").concat(n,"-").concat(s)},InputText:function(e){var o=e.currentTarget.dataset.text;if(this.model.money+="",this.model.money.length>14)return t.showToast({title:"输入金额过大",duration:2e3,icon:"none"}),!1;switch(o){case"+":if("0"===this.model.money)return!1;this.model.money=this.Calculation(this.model.money);break;case"-":if("0"===this.model.money)return!1;this.model.money=this.Calculation(this.model.money);break;case".":var n=this.model.money+"";if(0!==this.model.money.indexOf("-")&&0!==this.model.money.indexOf("+")||(n=n.substr(1,n.length)),-1!==n.indexOf("-")&&-1!==n.split("-")[n.split("-").length-1].indexOf("."))return!1;if(-1!==n.indexOf("+")&&-1!==n.split("+")[n.split("+").length-1].indexOf("."))return!1;break}0!=this.model.money?this.model.money+=e.currentTarget.dataset.text+"":this.model.money=e.currentTarget.dataset.text},Calculation:function(t){return-1!==t.indexOf("-")&&0!==t.indexOf("-")?(0,n.accSub)(parseFloat(t.split("-")[0]||0),parseFloat(t.split("-")[1]||0))+"":-1!==t.indexOf("+")?(0,n.accAdd)(parseFloat(t.split("+")[0]||0),parseFloat(t.split("+")[1]||0))+"":0===t.indexOf("-")&&t.split("-")[2]?(0,n.accSub)(parseFloat("-"+t.split("-")[1]||!1),parseFloat(t.split("-")[2]||0))+"":parseFloat(t)+""},CalculationTo:function(t){this.model.money=this.Calculation(this.model.money)},Deltext:function(t){this.model.money.length>1?(this.model.money=this.model.money.substr(0,this.model.money.length-1),"-"!==this.model.money&&"+"!==this.model.money||(this.model.money="0")):this.model.money="0"},Submit:function(e){return console.log("点击了提交按钮",this.model),""===this.model.classId?(t.showToast({title:"请选择分类",duration:2e3,icon:"none"}),!1):this.model.money&&0!=this.model.money?(this.model.AmountOfmoney=parseFloat(this.model.money),void(0,i.bookSave)(this.model,(function(e){console.log(e),!0===e.result?(t.showToast({title:"保存成功",duration:2e3,icon:"none"}),setTimeout((function(){t.redirectTo({url:"/pages/index/index"})}),2e3)):t.showToast({title:e.msg,duration:2e3,icon:"none"})}))):(t.showToast({title:"请输入金额",duration:2e3,icon:"none"}),!1)},getBookClassList:function(){console.log("获取数据");var t=this;(0,s.getBookClassList)({PageSize:1e3,PageIndex:1},(function(e){e.data.forEach((function(e){1===e.billType?t.bookoutclasslist.push(e):t.bookinclasslist.push(e)})),1==t.model.billType?t.bookclasslist=t.bookoutclasslist:t.bookclasslist=t.bookinclasslist}))},changeClass:function(t){this.currentClass=t,this.model.classId=t.id}},created:function(){this.getBookClassList()},computed:{isCalculation:function(){var t=this.model.money+"";return 0!==this.model.money.indexOf("-")&&0!==this.model.money.indexOf("+")||(t=t.substr(1,t.length)),-1!==t.indexOf("-")||-1!==t.indexOf("+")}}};e.default=l}).call(this,o("543d")["default"])},"2bfc":function(t,e,o){},"5dc5":function(t,e,o){"use strict";var n;o.d(e,"b",(function(){return s})),o.d(e,"c",(function(){return i})),o.d(e,"a",(function(){return n}));var s=function(){var t=this,e=t.$createElement;t._self._c},i=[]},b2be:function(t,e,o){"use strict";(function(t){o("885c");n(o("66fd"));var e=n(o("cbbd"));function n(t){return t&&t.__esModule?t:{default:t}}wx.__webpack_require_UNI_MP_PLUGIN__=o,t(e.default)}).call(this,o("543d")["createPage"])},cbbd:function(t,e,o){"use strict";o.r(e);var n=o("5dc5"),s=o("cecf");for(var i in s)"default"!==i&&function(t){o.d(e,t,(function(){return s[t]}))}(i);o("f494");var l,a=o("f0c5"),c=Object(a["a"])(s["default"],n["b"],n["c"],!1,null,"d687dfb6",null,!1,n["a"],l);e["default"]=c.exports},cecf:function(t,e,o){"use strict";o.r(e);var n=o("11eb"),s=o.n(n);for(var i in n)"default"!==i&&function(t){o.d(e,t,(function(){return n[t]}))}(i);e["default"]=s.a},f494:function(t,e,o){"use strict";var n=o("2bfc"),s=o.n(n);s.a}},[["b2be","common/runtime","common/vendor"]]]);