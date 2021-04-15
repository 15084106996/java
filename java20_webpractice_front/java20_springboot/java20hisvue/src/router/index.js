import Vue from 'vue'
import VueRouter from 'vue-router'
import {Message} from "element-ui";
import Login from "../views/Login";
import Home from "../views/Home";
import DocHome from "../views/doctor/DocHome";
import Regist from "../views/regist/Regist";
import RegistOut from "../views/regist/RegistOut";
import Constant from "../views/systeminfo/Constant";
import Dept from "../views/systeminfo/Dept";
import Scheduling from "../views/systeminfo/Scheduling";
import User from "../views/systeminfo/User";

Vue.use(VueRouter)

const routes = [
  {
    path:'/',
    name : 'Login',
    component : Login,
    hidden:true
  },
  {
    path:'/Home',
    name : 'Home',
    component : Home,
    hidden:true
  },
  {
    path:'/Home',
    name : 'Home',
    component : Home,
    meta: {
      title : '挂号收费'
    },
    children : [
      {
        path:'/Regist',
        name : 'Regist',
        component : Regist,
        meta:{
          title : '现场挂号'
        }
      },
      {
        path:'/RegistOut',
        name : 'RegistOut',
        component : RegistOut,
        meta:{
          title : '退号'
        }
      }
    ]
  },
  {
    path:'/Home',
    name : 'Home',
    component : Home,
    meta: {
      title : '门诊医生'
    },
    children : [
      {
        path:'/DocHome',
        name : 'DocHome',
        component : DocHome,
        meta:{
          title : '门诊病历'
        }
      }
    ]
  },
  {
    path:'/Home',
    name : 'Home',
    component : Home,
    meta: {
      title : '系统信息'
    },
    children : [
      {
        path:'/Constant',
        name : 'Constant',
        component : Constant,
        meta:{
          title : '常熟类别管理'
        }
      },
      {
        path:'/Dept',
        name : 'Dept',
        component : Dept,
        meta:{
          title : '科室管理'
        }
      },
      {
        path:'/User',
        name : 'User',
        component : User,
        meta:{
          title : '用户管理'
        }
      },
      {
        path:'/Scheduling',
        name : 'Scheduling',
        component : Scheduling,
        meta:{
          title : '医生排班管理'
        }
      },
    ]
  },
]

const router = new VueRouter({
  routes
})

router.beforeEach((to,from,next) => {
  window.document.body.style.background = '#2d3a4b';
  if (to.path == '/') {
    next();
  }else{
    let user = window.sessionStorage.getItem('loginUser');
    if (user == null) {
      Message.warning({message: '请先登录'})
      next('/');
    }else{
      window.document.body.style.background = '#fff';
      next();
    }
  }
})

const originalPush = VueRouter.prototype.push
VueRouter.prototype.push = function push(location) {
  return originalPush.call(this, location).catch(err => err)
}

export default router
