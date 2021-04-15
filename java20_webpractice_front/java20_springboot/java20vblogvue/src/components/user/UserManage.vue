<template>
    <div>
        <div>
            <el-input placeholder="请填写用户名或昵称" style="width: 300px;margin-right: 8px;" size="mini" v-model="keyWords"></el-input>
            <el-button size="mini" type="primary" icon="fa fa-search" @click="initUserInfos">搜索用户</el-button>
        </div>
        <div style="display: flex;flex-wrap: wrap">
            <el-card class="box-card" v-for="(item,index) in userInfos">
                <div slot="header" class="clearfix">
                    <span style="color: #409EFF">用户昵称：{{item.nickname}}</span>
                    <el-button style="float: right; padding: 3px 0" type="text"><i style="color: red" class="el-icon-delete"></i></el-button>
                </div>
                <div class="text item">
                    <p class="text"><el-tag class="tagmargin" size="small" type="success">登录用户名</el-tag>{{item.username}}</p>
                    <p class="text"><el-tag class="tagmargin" size="small" type="success">用户邮箱</el-tag>{{item.email}}</p>
                    <p class="text">
                        <el-tag class="tagmargin" size="small" type="success">用户性别</el-tag>
                        <span v-if="item.gender">女</span>
                        <span v-else>男</span>
                    </p>
                    <p class="text">
                        <el-tag class="tagmargin" size="small" type="success">可用状态</el-tag>
                        <el-switch
                                size="mini"
                                @change="handleEnabled(item.id,item.enabled)"
                                v-model="item.enabled"
                                active-color="#13ce66"
                                inactive-color="#ff4949"
                                active-text="可用"
                                inactive-text="禁用">
                        </el-switch>
                    </p>
                    <p class="text">
                        <el-tag class="tagmargin" size="small" type="success">锁定状态</el-tag>
                        <el-switch
                                @change="handleLocked(item.id,item.nonLocked)"
                                size="mini"
                                v-model="item.nonLocked"
                                active-color="#13ce66"
                                inactive-color="#ff4949"
                                active-text="未锁定"
                                inactive-text="锁定">
                        </el-switch>
                    </p>
                    <p class="text">
                        <el-tag class="tagmargin" size="small" type="success">用户角色</el-tag>
                        <el-select
                                @remove-tag="removeTag(item.id)"
                                @change="roleChange"
                                @visible-change="removeTag(item.id)"
                                size="mini"
                                style="width: 75%"
                                v-model="item.roles"
                                multiple
                                filterable
                                allow-create
                                default-first-option
                                placeholder="请选择角色">
                            <el-option
                                    v-for="item in rolesInfos"
                                    :key="item.id"
                                    :label="item.rnameZh"
                                    :value="item.id">
                            </el-option>
                        </el-select>
                    </p>
                </div>
            </el-card>
        </div>
    </div>
</template>

<script>
    export default {
        name: "UserManage",
        data() {
            return {
                userinfo : {// 更改的对象
                    id : 0,
                    enabled : true,
                    nonLocked : true,
                    roleIds : []
                },
                userInfos: [],// 所有的用户信息
                rolesInfos: [],// 所有的角色信息
                keyWords : ''// 搜索关键字
            };
        },
        methods: {
            removeTag(id) { // 多选模式下移除tag时回调
                this.userinfo.id = id;
            },
            roleChange(active) { // 添加或删除角色回调
                this.$confirm('此操作将永久改变用户角色, 是否继续?', '提示', {
                    confirmButtonText: '确定',
                    cancelButtonText: '取消',
                    type: 'warning'
                }).then(() => {
                    this.userinfo.roleIds = active;
                    // 发送 更新 角色请求
                    this.$putRequest('/user/updateUserRoles',this.userinfo).then(resp => {
                        this.initUserInfos();
                    })
                }).catch(() => {
                    this.$message({
                        type: 'info',
                        message: '已取消删除'
                    });
                    this.initUserInfos();
                });
            },
            handleLocked(id,nonLocked) { // 锁定的switch
                this.userinfo.id = id;
                this.userinfo.nonLocked = nonLocked;
                this.$putRequest('/user/updateLocked',this.userinfo).then(resp => {
                    this.initUserInfos();
                })
            },
            handleEnabled(id,enabled) { // 启用禁用的switch
                this.userinfo.id = id;
                this.userinfo.enabled = enabled;
                this.$putRequest('/user/updateEnabled',this.userinfo).then(resp => {
                    this.initUserInfos();
                })
            },
            initUserInfos() { // 查询所有用户
                this.$getRequest('/user/?keyWords='+this.keyWords).then(resp => {
                    if (resp) {
                        this.userInfos = resp;
                        this.userInfos.forEach((item,index) =>{
                            let temp = item.roles;// 临时保存用户的角色
                            item.roles = [];
                            for (let i in temp) {
                                item.roles.push(temp[i].id);
                            }
                        })
                    }
                })
            },
            initRolesInfos() { // 查询所有角色
                this.$getRequest('/role/').then(resp => {
                    if (resp) {
                        this.rolesInfos = resp;
                    }
                })
            }
        },
        mounted() {
            this.initRolesInfos();
            this.initUserInfos();
        }
    }
</script>

<style scoped>
    .tagmargin{
        margin-right: 8px;
    }
    .text {
        font-size: 14px;
        color: #409EFF;
    }

    .item {
        margin-bottom: 18px;
    }

    .clearfix:before,
    .clearfix:after {
        display: table;
        content: "";
    }
    .clearfix:after {
        clear: both
    }

    .box-card {
        width: 380px;
        margin-right: 10px;
        margin-top: 10px;
    }
</style>