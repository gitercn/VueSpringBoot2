import Vue from 'vue'
import './plugins/vuetify'
//Import icons
import 'material-design-icons/iconfont/material-icons.css';
//Import Muse UI
import MuseUI from 'muse-ui';
import 'muse-ui/dist/muse-ui.css';
//Import Mint UI
import Mint from 'mint-ui'
import 'mint-ui/lib/style.css'

//Import EasyUi
import 'vx-easyui/dist/themes/metro/easyui.css';
import 'vx-easyui/dist/themes/icon.css';
import 'vx-easyui/dist/themes/vue.css';
import EasyUI from 'vx-easyui';

//Import MDUI
import 'mdui/dist/css/mdui.css';
import mdui from 'mdui';

import App from './App.vue'
import router from './router'
import store from './store'
import './registerServiceWorker'

//photo-preview插件
import preview from 'vue-photo-preview'
import 'vue-photo-preview/dist/skin.css'

Vue.use(MuseUI);
Vue.use(Mint);
Vue.use(EasyUI);
Vue.use(preview);

// 引用axios，并设置基础URL为后端服务api地址
var axios = require('axios')
// axios.defaults.baseURL = 'https://clouddemo15.au-syd.mybluemix.net/api'
// axios.defaults.baseURL = 'https://clouddemo21.au-syd.cf.appdomain.cloud/api'
axios.defaults.baseURL = 'http://localhost:8090/api'
// 将API方法绑定到全局
Vue.prototype.$axios = axios

Vue.config.productionTip = false



/* eslint-disable no-new */
new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
