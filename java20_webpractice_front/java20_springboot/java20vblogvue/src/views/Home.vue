<template>
    <div>
        <el-container>
            <el-header class="header">
                <h3>V部落博客后台管理平台</h3>
                <el-dropdown @command="dropdownItemHandler">
                    <span class="el-dropdown-link">
                        {{userinfo.nickname}}<i class="el-icon-arrow-down el-icon--right"></i>
                    </span>
                    <el-dropdown-menu slot="dropdown">
                        <el-dropdown-item command="userSettings">用户中心</el-dropdown-item>
                        <el-dropdown-item divided command="logout">注销登录</el-dropdown-item>
                    </el-dropdown-menu>
                </el-dropdown>
            </el-header>
            <el-container>
                <el-aside width="200px">
                    <el-menu router>
                        <el-submenu :key="item.name" :index="item.name" v-for="(item,index) in this.$router.options.routes" v-if="!item.hidden && item.meta.child && rolesCheck(item.meta.roles) == 200">
                            <template slot="title">
                                <i :class="item.meta.icon" style="margin-right: 8px"></i>
                                <span>{{item.meta.title}}</span>
                            </template>
                            <el-menu-item :key="child.name" v-for="(child,i) in item.children" :index="child.path" v-if="rolesCheck(child.meta.roles) == 200">
                                <span slot="title">{{child.meta.title}}</span>
                            </el-menu-item>
                        </el-submenu>
                        <div :key="'index'+item.name" v-for="(item,index) in this.$router.options.routes" v-if="!item.hidden && !item.meta.child">
                            <el-menu-item v-for="(child,i) in item.children" :index="child.path" v-if="!child.hidden && rolesCheck(child.meta.roles) == 200">
                                <i :class="child.meta.icon" style="margin-right: 8px"></i>
                                <span slot="title">{{child.meta.title}}</span>
                            </el-menu-item>
                        </div>
                    </el-menu>
                </el-aside>
                <el-main>
                    <div v-show="this.$route.path == '/Home'" class="welcomeInfo">
                        <h3>欢迎登录 VBlog!</h3>
                    </div>
                    <el-breadcrumb style="margin-bottom: 10px;" v-show="this.$route.path != '/Home'" separator-class="el-icon-arrow-right">
                        <el-breadcrumb-item :to="{ path: '/Home' }">首页</el-breadcrumb-item>
                        <el-breadcrumb-item>{{this.$route.meta.title}}</el-breadcrumb-item>
                    </el-breadcrumb>
                    <router-view/>
                </el-main>
            </el-container>
        </el-container>
    </div>
</template>

<script>
    export default {
        name: "Home",
        data() {
            return {
                userinfo: JSON.parse(window.sessionStorage.getItem('loginUser')) //登录者信息
            }
        },
        methods : {
            rolesCheck(needRoles) { // 校验角色
                let authorities = this.userinfo.authorities;// 获取用户的角色
                let code = 500;
                authorities.forEach((item,i) => {
                    if (needRoles.indexOf(item.authority) != -1) {
                        code = 200;
                    }
                })
                return code;
            },
            dropdownItemHandler(command) { // 下拉选项的回调函数
                if (command == 'logout') {
                    this.$confirm('此操作将注销登录, 是否继续?', '退出', {
                        confirmButtonText: '确定',
                        cancelButtonText: '取消',
                        type: 'warning'
                    }).then(() => {
                        // 发送注销请求
                        this.$getRequest('/logout').then(resp => {
                            window.sessionStorage.removeItem('loginUser');
                            this.$router.replace('/');
                        });
                    }).catch(() => {
                        this.$message({
                            type: 'info',
                            message: '已取消操作'
                        });
                    });
                }
            }
        }
    }
</script>

<style scoped>
    .header {
        display: flex;
        justify-content: space-between;
        align-items: center;
        background: #409EFF;
        color: #fff;
    }

    .el-dropdown-link {
        cursor: pointer;
        color: #fff;
    }

    .el-icon-arrow-down {
        font-size: 12px;
    }
    .welcomeInfo{
        color: #409EFF;
    }
    .welcomeInfo h3{
        text-align: center;
    }
</style>