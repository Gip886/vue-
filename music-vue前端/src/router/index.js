import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'
import store from '../store/index'



Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/musiclist',
    name: 'MusicList',
    component: () => import('../components/MusicList.vue')
  },
  {
    path: '/result',
    name: 'Result',
    component: () => import('../components/Results.vue')
  },
  {
    path: '/playlists',
    name: 'PlayLists',
    component: () => import('../components/PlayLists.vue')
  },
  {
    path: '/playlist',
    name: 'PlayList',
    component: () => import('../components/PlayList.vue')
  },
  {
    path: '/mysongs',
    name: 'MySongs',
    component: () => import('../components/MySongs.vue')
  },
  {
    path: '/mvs',
    name: 'Mvs',
    component: () => import('../components/Mvs.vue')
  },
  {
    path: '/mymusic',
    name: 'MyMusic',
    component: () => import('../components/myMusic.vue')
  },
]

const router = new VueRouter({
  routes
})

//路由守卫
router.beforeEach(function(to,from,next){
  if(to.path==="/mymusic"){
    if(store.state.isLogin===true){
      next();
    }else{
      alert("请登录")
    }
  }else{
    next();
  }
})

export default router
