import Vue from 'vue'
import App from './App.vue'
//导入路由，vuex插件
import router from './router'
import store from './store'
//导入eleui组件
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
//导入播放器组件
import APlayer from '@moefe/vue-aplayer';
Vue.use(APlayer, {
  defaultCover: 'https://github.com/u3u.png',
  productionTip: true,
});


Vue.config.productionTip = false
Vue.use(ElementUI)

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')


