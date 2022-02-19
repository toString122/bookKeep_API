
var isReady=false;var onReadyCallbacks=[];
var isServiceReady=false;var onServiceReadyCallbacks=[];
var __uniConfig = {"pages":["pages/index/index","pages/mbook/mbook","pages/extend/index","pages/my/index","pages/addmbook/addmbook","pages/login/login","pages/about/about","pages/help/help","pages/help/help_detail","pages/help/help_edit","pages/help/help_list","pages/bind/bind"],"window":{"navigationBarTextStyle":"black","navigationBarTitleText":"小笔记账","navigationBarBackgroundColor":"#F8F8F8","navigationStyle":"custom","backgroundColor":"#F8F8F8"},"nvueCompiler":"uni-app","nvueStyleCompiler":"weex","renderer":"auto","splashscreen":{"alwaysShowBeforeRender":true,"autoclose":false},"appname":"Uniapp-KeepAccounts","compilerVersion":"3.2.16","entryPagePath":"pages/index/index","networkTimeout":{"request":60000,"connectSocket":60000,"uploadFile":60000,"downloadFile":60000}};
var __uniRoutes = [{"path":"/pages/index/index","meta":{"isQuit":true},"window":{"navigationBarTitleText":"主页","enablePullDownRefresh":true,"backgroundTextStyle":"light","background":"#f0f0f0"}},{"path":"/pages/mbook/mbook","meta":{},"window":{"navigationBarTitleText":"账本","navigationStyle":"custom","enablePullDownRefresh":false}},{"path":"/pages/extend/index","meta":{},"window":{}},{"path":"/pages/my/index","meta":{},"window":{"navigationBarTitleText":"我的","navigationStyle":"custom","enablePullDownRefresh":true,"background":"#f0f0f0","statusbar":{"background":"#f0f0f0"}}},{"path":"/pages/addmbook/addmbook","meta":{},"window":{"navigationBarTitleText":"记账","enablePullDownRefresh":false}},{"path":"/pages/login/login","meta":{},"window":{"navigationBarTitleText":"","enablePullDownRefresh":false}},{"path":"/pages/about/about","meta":{},"window":{"navigationBarTitleText":"","enablePullDownRefresh":false}},{"path":"/pages/help/help","meta":{},"window":{"navigationBarTitleText":"帮助","enablePullDownRefresh":false}},{"path":"/pages/help/help_detail","meta":{},"window":{"navigationBarTitleText":"帮助详情","enablePullDownRefresh":false}},{"path":"/pages/help/help_edit","meta":{},"window":{"navigationBarTitleText":"帮助编辑","enablePullDownRefresh":false}},{"path":"/pages/help/help_list","meta":{},"window":{"navigationBarTitleText":"帮助管理","enablePullDownRefresh":false}},{"path":"/pages/bind/bind","meta":{},"window":{"navigationBarTitleText":"绑定手机号","enablePullDownRefresh":false}}];
__uniConfig.onReady=function(callback){if(__uniConfig.ready){callback()}else{onReadyCallbacks.push(callback)}};Object.defineProperty(__uniConfig,"ready",{get:function(){return isReady},set:function(val){isReady=val;if(!isReady){return}const callbacks=onReadyCallbacks.slice(0);onReadyCallbacks.length=0;callbacks.forEach(function(callback){callback()})}});
__uniConfig.onServiceReady=function(callback){if(__uniConfig.serviceReady){callback()}else{onServiceReadyCallbacks.push(callback)}};Object.defineProperty(__uniConfig,"serviceReady",{get:function(){return isServiceReady},set:function(val){isServiceReady=val;if(!isServiceReady){return}const callbacks=onServiceReadyCallbacks.slice(0);onServiceReadyCallbacks.length=0;callbacks.forEach(function(callback){callback()})}});
service.register("uni-app-config",{create(a,b,c){if(!__uniConfig.viewport){var d=b.weex.config.env.scale,e=b.weex.config.env.deviceWidth,f=Math.ceil(e/d);Object.assign(__uniConfig,{viewport:f,defaultFontSize:Math.round(f/20)})}return{instance:{__uniConfig:__uniConfig,__uniRoutes:__uniRoutes,global:void 0,window:void 0,document:void 0,frames:void 0,self:void 0,location:void 0,navigator:void 0,localStorage:void 0,history:void 0,Caches:void 0,screen:void 0,alert:void 0,confirm:void 0,prompt:void 0,fetch:void 0,XMLHttpRequest:void 0,WebSocket:void 0,webkit:void 0,print:void 0}}}});
