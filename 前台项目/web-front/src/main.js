import 'babel-polyfill'
import 'classlist-polyfill'
import Vue from 'vue'
import axios from './router/axios'
import VueAxios from 'vue-axios'
import VueLazyload from 'vue-lazyload'
import uploader from 'vue-simple-uploader'
import App from './App'
import './permission' // 权限
import './error' // 日志
import router from './router/router'
import store from './store'
import { loadStyle } from './util/util'
import * as urls from '@/config/env'
import { iconfontUrl, iconfontVersion } from '@/config/env'
import * as filters from './filters' // 全局filter

import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'

import './styles/common.scss'

import basicContainer from './components/basic-container/main'
// 插件 json 展示
import vueJsonTreeView from 'vue-json-tree-view'
//富文本框
import AvueEditor from './components/AvueEditor'
//用户抽屉选择
import AvueUserSelect from './components/UserSelect'


Vue.use(router)

Vue.use(vueJsonTreeView)

Vue.use(VueAxios, axios)

Vue.use(ElementUI,{
  size: 'medium',
  menuType: 'text'
})

Vue.use(window.AVUE, {
  size: 'medium',
  menuType: 'text'
})


Vue.use(VueLazyload)

Vue.use(uploader)


// 注册富文本框容器
Vue.use(AvueEditor)
//会员选择
Vue.use(AvueUserSelect)

// 注册全局容器
Vue.component('basicContainer', basicContainer)

// 加载相关url地址
Object.keys(urls).forEach(key => {
  Vue.prototype[key] = urls[key]
})

//加载过滤器
Object.keys(filters).forEach(key => {
  Vue.filter(key, filters[key])
})


// 动态加载阿里云字体库
iconfontVersion.forEach(ele => {
  loadStyle(iconfontUrl.replace('$key', ele))
})


Vue.config.productionTip = false
new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
