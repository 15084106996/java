<template>
    <div>
        <div>
            <h3>FY20_沈阳_Java20班 考勤记录</h3>
            <h4>考勤历史 ({{allSignInfos.length}}次)</h4>
        </div>
        <div class="signInfo">
            <div class="infos">
                <el-card class="box-card" v-for="(item,index) in allSignInfos" :key="item.id" v-if="index < 4">
                    <div slot="header" class="clearfix">
                        <span>{{item.date}}</span>
                        <el-button @click="showSignInfos(item.userList,item.id)" style="float: right; padding: 3px 0" type="text">点击查看签到信息</el-button>
                    </div>
                    <div class="text item">
                        出勤率 {{(item.userList.length/personsNum*100).toFixed(1)}}%
                    </div>
                </el-card>
                <!-- 分页处理 -->
                <el-pagination
                        background
                        layout="prev, pager, next"
                        :total="1000">
                </el-pagination>
            </div>
            <div class="infos">
                <!--数据-->
                <el-table
                        v-show="showTable"
                        :data="tableData"
                        stripe
                        style="width: 100%">
                    <el-table-column
                            prop="username"
                            label="姓名">
                    </el-table-column>
                    <el-table-column
                            prop="time"
                            label="签到时间">
                    </el-table-column>
                    <el-table-column label="操作">
                        <template slot-scope="scope">
                            <el-button
                                    size="mini"
                                    type="danger"
                                    @click="handleDelete(scope.row)">删除</el-button>
                        </template>
                    </el-table-column>
                </el-table>
                <el-button @click="showTable=false" style="margin:10px 0" v-show="showTable" type="primary" size="small">隐藏</el-button>
            </div>
        </div>
    </div>
</template>

<style scoped>
    .signInfo{
        display: flex;
    }
    .infos{
        width: 48%;
        margin-right: 1vw;
        margin-top: 1vw;
        height: 35vw;
    }
    .text {
        font-size: 14px;
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
        width: 100%;
        margin:0.4vw 0;
    }
</style>

<script>
    module.exports = {
        data() {
            return {
                dateId: -1,
                showTable:false,
                tableData: [],// 展示的打卡信息记录
                personsNum: 14,// 总人数
                allSignInfos :[// 每一天的打卡信息
                    {
                        id: 9001,
                        date:'2021.02.25',
                        userList:[
                            {id:1001,username:'tom',time:'08:22'},
                            {id:1002,username:'lucy',time:'09:02'},
                            {id:1003,username:'bob',time:'07:10'},
                        ]
                    },
                    {
                        id: 9002,
                        date:'2021.02.24',
                        userList:[
                            {id:1001,username:'tom',time:'10:30'},
                            {id:1003,username:'bob',time:'08:19'},
                        ]
                    },
                    {
                        id: 9003,
                        date:'2021.02.23',
                        userList:[
                            {id:1001,username:'tom',time:'10:30'},
                            {id:1003,username:'bob',time:'08:19'},
                            {id:1004,username:'mike',time:'08:45'},
                            {id:1005,username:'smith',time:'07:29'},
                        ]
                    },
                    {
                        id: 9004,
                        date:'2021.02.22',
                        userList:[
                            {id:1001,username:'tom',time:'06:30'},
                            {id:1005,username:'smith',time:'07:00'},
                        ]
                    },
                    {
                        id: 9005,
                        date:'2021.02.21',
                        userList:[
                            {id:1001,username:'tom',time:'08:55'},
                            {id:1002,username:'lucy',time:'09:12'},
                            {id:1003,username:'bob',time:'08:39'},
                            {id:1004,username:'mike',time:'08:25'},
                            {id:1005,username:'smith',time:'07:44'},
                        ]
                    },
                ]
            }
        },
        methods:{
            handleDelete(row) {// 删除记录
                console.log(row);
                console.log(this.dateId);

            },
            showSignInfos(list,id) {// 显示
                // 获取点击的 userList 赋值给 tableData
                this.tableData = list;
                this.showTable = true;
                this.dateId = id;
            }
        }
    }
</script>