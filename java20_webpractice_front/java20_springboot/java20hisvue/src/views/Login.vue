<template>
    <div class="loginPage">
        <h3>His系统登录</h3>
        <el-form :rules="rules" :model="loginData" ref="loginForm">
            <el-form-item prop="username">
                <el-input @keydown.native.enter="submitLogin" size="small" v-model="loginData.username"></el-input>
            </el-form-item>
            <el-form-item prop="password">
                <el-input @keydown.native.enter="submitLogin" type="password" size="small" v-model="loginData.password"></el-input>
            </el-form-item>
            <el-form-item>
                <el-checkbox v-model="rememberMe">记住密码</el-checkbox>
            </el-form-item>
            <el-button class="btn" size="small" type="primary" @click="submitLogin">登录</el-button>
        </el-form>
    </div>
</template>

<script>
    export default {
        name: "Login",
        data() {
            return {
                rememberMe : true,
                loginData: { // 表单数据对象
                    username : 'root',
                    password : 'root',
                },
                rules : { // 表单验证规则
                    username : [
                        {required: true, message: '请输入用户名称', trigger: 'blur'}
                    ],
                    password :[
                        {required: true, message: '请输入用户密码', trigger: 'blur'}
                    ],
                }
            }
        },
        methods : {
            submitLogin() { // 提交登录
                this.$refs['loginForm'].validate((valid) => {
                    if (valid) {
                        this.$postRequest('/doLogin',this.loginData).then(resp =>{
                            if (resp) {
                                window.sessionStorage.setItem('loginUser', JSON.stringify(resp.data));
                                this.$router.replace('/Home');
                            }
                        })
                    } else {
                        this.$message.warning('请正确填写用户信息');
                        return false;
                    }
                });
            }
        }
    }
</script>

<style scoped>
    .loginPage{
        width: 30vw;
        margin: 13vw auto;
    }
    .loginPage h3{
        text-align: center;
        color: #fff;
    }
    .loginPage .btn{
        width: 100%;
    }
</style>