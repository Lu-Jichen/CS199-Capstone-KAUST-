import Vue from 'vue'
import Router from 'vue-router'
// import HelloWorld from '@/components/HelloWorld'
import Login from '@/view/loginNew'
import UserIndex from '@/view/UserIndex'
import UserDetail from '@/view/UserDetail'
import Main from '@/view/Main'
import ErrandList from '@/view/ErrandList'
import MyErrand from '@/view/MyErrand'
import MyWork from '@/view/MyWork'
import Pet from '@/view/Pet'
import Delivery from '@/view/Delivery'
Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'Login',
      component: Login
    },
    {
      path: '/login',
      name: 'Login',
      component: Login
    },
    {
      path: '/user',
      name: 'UserIndex',
      component: UserIndex
    },
    {
      path: '/userDetail',
      name: 'UserDetail',
      component: UserDetail
    },
    {
      path: '/main',
      name: 'Main',
      component: Main
    },
    {
      path: '/errandList',
      name: 'ErrandList',
      component: ErrandList
    },
    {
      path: '/myErrand',
      name: 'MyErrand',
      component: MyErrand
    },
    {
      path: '/myWork',
      name: 'MyWork',
      component: MyWork
    },
    {
      path: '/pet',
      name: 'Pet',
      component: Pet
    },
    {
      path: '/delivery',
      name: 'Delivery',
      component: Delivery
    }
  ],
  proxyTable: {
    '/api': {
      target: 'http://localhost:8088',
      changeOrigin: true,
      pathRewrite: {
        '^/api': ''
      }
    }
  }
})
