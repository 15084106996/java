import Vue from 'vue'
import VueRouter from 'vue-router'

Vue.use(VueRouter)
import Login from "../views/Login";
import Home from "../views/Home";
import {Message} from "element-ui";
import ArticleList from "../components/article/ArticleList";
import ArticlePublish from "../components/article/ArticlePublish";
import CategoryManage from "../components/category/CategoryManage";
import DataStatistics from "../components/data/DataStatistics";
import UserManage from "../components/user/UserManage";
import ArticleDetails from "../components/article/articleItem/ArticleDetails";

const routes = [
    {
        path: '/',
        name: 'Login',
        component: Login,
        hidden: true,
    },
    {
        path: '/Home',
        name: 'Home',
        component: Home,
        hidden: true,
    },
    {
        path: '/Home',
        name: 'Home',
        component: Home,
        meta: {
            child:true,
            title : '文章管理',
            icon : 'fa fa-file-text-o',
            roles : ['ROLE_admin','ROLE_article']
        },
        children :[
            {
                path: '/ArticleList',
                name: 'ArticleList',
                component: ArticleList,
                meta: {
                    title : '文章列表',
                    roles : ['ROLE_admin','ROLE_article']
                }
            },
            {
                path: '/ArticlePublish',
                name: 'ArticlePublish',
                component: ArticlePublish,
                meta: {
                    title : '文章发布',
                    roles : ['ROLE_admin','ROLE_article']
                }
            },
        ]
    },
    {
        path: '/Home',
        name: 'Home',
        component: Home,
        meta: {
            child:false,
        },
        children :[
            {
                path: '/CategoryManage',
                name: 'CategoryManage',
                component: CategoryManage,
                meta: {
                    title : '栏目管理',
                    icon : 'fa fa-bars',
                    roles : ['ROLE_admin','ROLE_category']
                }
            },
            {
                path: '/UserManage',
                name: 'UserManage',
                component: UserManage,
                meta: {
                    title : '用户管理',
                    icon : 'fa fa-user-circle-o',
                    roles : ['ROLE_admin','ROLE_user']
                }
            },
            {
                path: '/DataStatistics',
                name: 'DataStatistics',
                component: DataStatistics,
                meta: {
                    title : '数据统计',
                    icon: 'fa fa-database',
                    roles : ['ROLE_admin','ROLE_user','ROLE_article','ROLE_category']
                }
            },
            {
                path: '/ArticleDetails',
                name: 'ArticleDetails',
                component: ArticleDetails,
                hidden:true,
                meta: {
                    title : '文章详情',
                }
            },
        ]
    },
]

const router = new VueRouter({
    routes
})

// 前置导航首位，监控路由变化
router.beforeEach((to, from, next) => {
    window.document.body.style.background = '#2d3a4b';
    if (to.path == '/') {
        next();
    } else {
        let user = window.sessionStorage.getItem('loginUser');
        if (user == null) {
            Message.warning({message: '用户未登录'});
            next('/');
        } else {
            next();
            window.document.body.style.background = '#fff';
        }
    }
})

export default router
