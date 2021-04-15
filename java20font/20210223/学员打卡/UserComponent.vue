<template>
    <div>
        <div class="signArea">
            <el-button :disabled="signCheck" @click="signByUser" size="small" type="primary">打卡签到</el-button>
            <h3>考勤信息</h3>
            <span class="times">{{times}}</span>
        </div>
        <div class="signInfo">
            <div class="infos">
                <el-card class="box-card" v-for="(item,index) in signInfos" v-if="index >= (curPage-1)*5 && index <= curPage*5-1" :key="item.id">
                    <div slot="header" class="clearfix">
                        <span>{{item.date}}</span>
                    </div>
                    <div class="text item">
                        {{item.date}} {{item.time}} 二维码签到
                    </div>
                </el-card>
                <el-pagination
                        @current-change="pageChange"
                        :current-page="curPage"
                        :page-size="pageSize"
                        background
                        layout="prev, pager, next"
                        :total="signInfos.length">
                </el-pagination>
            </div>
            <div ref="main" class="infos">

            </div>
        </div>
    </div>
</template>

<style scoped>
    .signArea{
        display: flex;
        align-items: center;
    }
    .signArea h3{
        margin: 0 15px;
    }
    .signArea .times{
        color: #409EFF;
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
    .signInfo{
        display: flex;
    }
    .infos{
        width: 48%;
        margin-right: 1vw;
        margin-top: 1vw;
        height: 40vw;
    }
    .el-pager .active{
        background: orange !important;
    }
</style>

<script>
    module.exports =  {
        data() {
            return {
                signCheck : false,// 按钮禁用标识
                pageSize: 5,// 页面记录数量
                curPage : 1,// 当前页码
                signInfos : [// 个人签到信息
                    {id:1,date: '2021.02.01', time: '08:11'},
                    {id:2,date: '2021.01.31', time: '09:27'},
                    {id:3,date: '2021.01.30', time: '10:27'},
                    {id:4,date: '2021.01.29', time: '06:30'},
                    {id:5,date: '2021.01.28', time: '07:11'},
                    {id:6,date: '2021.01.27', time: '07:58'},
                    {id:7,date: '2021.01.26', time: '07:52'},
                    {id:8,date: '2021.01.25', time: '08:22'},
                    {id:9,date: '2021.01.24', time: '08:32'},
                    {id:10,date: '2021.01.23', time: '09:05'},
                    {id:11,date: '2021.01.22', time: '11:36'},
                    {id:12,date: '2021.01.21', time: '09:00'},
                    {id:13,date: '2021.01.20', time: '08:29'},
                    {id:14,date: '2021.01.19', time: '07:59'},
                ],
                times: '',// 时间
            };
        },
        methods:{
            initEcharts() {// 初始化echarts
                let normal = 0;
                let late = 0;
                this.signInfos.forEach((item,index) => {
                    if (parseInt(item.time.substr(0, 2)) >= 9) {
                        late++;
                    }else{
                        normal++;
                    }
                })
                let myChart = echarts.init(this.$refs['main']);
                // 指定图表的配置项和数据
                let option = {
                    tooltip: {
                        trigger: 'item'
                    },
                    legend: {
                        top: '5%',
                        left: 'center'
                    },
                    series: [
                        {
                            name: '打卡具体信息',
                            type: 'pie',
                            radius: ['40%', '70%'],
                            avoidLabelOverlap: false,
                            label: {
                                show: false,
                                position: 'center'
                            },
                            emphasis: {
                                label: {
                                    show: true,
                                    fontSize: '40',
                                    fontWeight: 'bold'
                                }
                            },
                            labelLine: {
                                show: false
                            },
                            data: [
                                {value: normal, name: '正常打卡'},
                                {value: late, name: '迟到'}
                            ]
                        }
                    ]
                };
                // 使用刚指定的配置项和数据显示图表。
                myChart.setOption(option);
            },
            signBtnCheck() {// 检查按钮是否该禁用
                let time = new Date();
                let year = time.getFullYear();
                let month = (time.getMonth()+1+'').padStart(2,"0");
                let date = (time.getDate()+'').padStart(2,"0");
                let times1 = `${year}.${month}.${date}`;
                this.signInfos.forEach((item,index) => {
                    if (times1 == item.date) {
                        this.signCheck = true;
                    }
                })
            },
            signByUser() {// 用户打卡
                let time = new Date();
                let year = time.getFullYear();
                let month = (time.getMonth()+1+'').padStart(2,"0");
                let date = (time.getDate()+'').padStart(2,"0");
                let hours = (time.getHours()+'').padStart(2,"0");
                let min = (time.getMinutes()+'').padStart(2,"0");
                let times1 = `${year}.${month}.${date}`;
                let times2 = `${hours}:${min}`;
                let timeObj = {
                    id : 15,
                    date : times1,
                    time: times2
                }
                this.signInfos.unshift(timeObj);
                this.signCheck = true;
                this.$message.success('您已经签到成功，请不要重复签到');
                this.curPage = 1;
                this.initEcharts();
            },
            pageChange(num) {// 分页回调函数
                this.curPage = num;
            },
            getTimes() {// 定时器切换时间
                setInterval(() => {
                    this.initTimes();
                },1000)
            },
            initTimes() {// 初始化时间
                let time = new Date();
                let year = time.getFullYear();
                let month = (time.getMonth()+1+'').padStart(2,"0");
                let date = (time.getDate()+'').padStart(2,"0");
                let hours = (time.getHours()+'').padStart(2,"0");
                let min = (time.getMinutes()+'').padStart(2,"0");
                let sec = (time.getSeconds()+'').padStart(2,"0");
                this.times = `${year}-${month}-${date} ${hours}:${min}:${sec}`;
            }
        },
        mounted() {
            this.initTimes();
            this.getTimes();
            this.signBtnCheck();
            this.initEcharts();
        }
    }
</script>