import Vue from 'vue'
import App from './App.vue'
import router from './router'

import 'font-awesome/css/font-awesome.min.css'

Vue.config.productionTip = false
// 引入 elementui
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
Vue.use(ElementUI);

import {getRequest} from "./utils/api";
import {postKeyValueRequest} from "./utils/api";
import {postRequest} from "./utils/api";
import {putRequest} from "./utils/api";
import {delRequest} from "./utils/api";
// 注册api插件
Vue.prototype.$getRequest=getRequest;
Vue.prototype.$postKeyValueRequest=postKeyValueRequest;
Vue.prototype.$postRequest=postRequest;
Vue.prototype.$putRequest=putRequest;
Vue.prototype.$delRequest=delRequest;
// 引入mavon-editor
import mavonEditor from 'mavon-editor'
import 'mavon-editor/dist/css/index.css'
Vue.use(mavonEditor)

import * as echarts from 'echarts';
Vue.prototype.$echarts=echarts


new Vue({
  router,
  render: h => h(App)
}).$mount('#app')
