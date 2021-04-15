<template>
    <div>
        <el-container>
            <el-header class="header">
                <h3>东软云医院HIS系统</h3>
                <el-dropdown @command="handleDropdownItem">
                  <span class="el-dropdown-link">
                    {{loginUser.realname}}<i class="el-icon-arrow-down el-icon--right"></i>
                  </span>
                    <el-dropdown-menu slot="dropdown">
                        <el-dropdown-item command="userSettings">用户中心</el-dropdown-item>
                        <el-dropdown-item command="logout" divided>用户注销</el-dropdown-item>
                    </el-dropdown-menu>
                </el-dropdown>
            </el-header>
            <el-container>
                <el-aside width="200px">
                    <el-menu router unique-opened>
                        <el-submenu :index="'index'+index" v-for="(item,index) in this.$router.options.routes" v-if="!item.hidden">
                            <template slot="title">
                                <span>{{item.meta.title}}</span>
                            </template>
                            <el-menu-item @click="updateTabs(child)" :index="child.path" v-for="(child,i) in item.children">
                                <span slot="title">{{child.meta.title}}</span>
                            </el-menu-item>
                        </el-submenu>
                    </el-menu>
                </el-aside>
                <el-main>
                    <!--tabs-->
                    <el-tabs v-model="editableTabsValue" type="card" editable @tab-click="tabClick" @edit="handleTabsEdit">
                        <el-tab-pane
                                :key="item.name"
                                v-for="(item, index) in editableTabs"
                                :label="item.title"
                                :name="item.name"
                        >
                        </el-tab-pane>
                    </el-tabs>
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
                editableTabs: [],
                editableTabsValue: '',
                loginUser : JSON.parse(window.sessionStorage.getItem('loginUser'))
            }
        },
        watch: { // 侦听器
            editableTabs(newValue) { // 选项卡完全删除以后跳转Home
                if (newValue.length == 0) {
                    this.$router.replace('/Home')
                }
            }
        },
        mounted() {
            if (this.editableTabs.length == 0) { // 刷新页面时跳转Home
                this.$router.replace('/Home')
            }
        },
        methods: {
            handleTabsEdit(targetName, action) { // 选项卡改变
                if (action === 'remove') {
                    let tabs = this.editableTabs; // 获取所有tab数据
                    let activeName = this.editableTabsValue; // 获取当前激活的tab
                    if (activeName === targetName) { // 如果删除的是当前激活的tab
                        tabs.forEach((tab, index) => {
                            if (tab.name === targetName) {
                                let nextTab = tabs[index + 1] || tabs[index - 1];
                                if (nextTab) {
                                    activeName = nextTab.name;
                                    this.$router.push(nextTab.path);
                                }
                            }
                        });
                    }
                    this.editableTabsValue = activeName;
                    this.editableTabs = tabs.filter(tab => tab.name !== targetName);
                }
            },
            tabClick(tab) { // 点击tabs切换路由
                this.editableTabs.forEach((item,index) => {
                    if (item.title == tab.name) {
                        this.$router.push(item.path);
                    }
                })
            },
            updateTabs(child) { // 点击菜单添加选项卡
                let bool = true;
                this.editableTabs.forEach((item,index) => {
                    if (child.meta.title == item.title) {
                        bool = false;
                    }
                })
                if (bool) {
                    let obj = {
                        title: child.meta.title,
                        name: child.meta.title,
                        path: child.path
                    };
                    this.editableTabs.push(obj);
                }
                this.editableTabsValue = child.meta.title;
            },
            handleDropdownItem(command) { // 点击下拉菜单选项
                if (command == 'logout') {
                    window.sessionStorage.removeItem('loginUser');
                    this.$message.info('用户注销');
                    this.$router.replace('/');
                }
            }
        }
    }
</script>

<style scoped>
    .header{
        background: #409eff;
        display: flex;
        justify-content: space-between;
        align-items: center;
        color: #fff;
    }
    .el-dropdown-link {
        cursor: pointer;
        color: #fff;
    }
    .el-icon-arrow-down {
        font-size: 12px;
    }
</style>