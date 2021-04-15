<template>
    <div style="display: flex;">
        <div style="width: 50%">
            <div ref="main" style="width: 100%;height:400px;"></div>
        </div>
        <div style="width: 50%">
            <el-card class="box-card">
                <div slot="header" class="clearfix">
                    <span>月榜</span>
                </div>
                <div v-for="(item,index) in topTen" :key="item.id" class="text">
                    <el-button type="text" @click="searchArticle(item.id)">{{item.title}}</el-button>
                    <span style="font-size: 14px !important;">{{item.views}}</span>
                </div>
            </el-card>
        </div>
    </div>
</template>

<script>
    export default {
        name: "DataStatistics",
        data() {
            return {
                topTen:[]
            }
        },
        methods : {
            searchArticle(id) { //点击文章题目
                this.$router.push({
                    path:'/ArticleDetails',
                    query :{
                        id : id
                    }
                })
            },
            initMonthTopTen() { // 月榜top10
                this.$getRequest('/data/topTen').then(resp => {
                    if (resp) {
                        this.topTen = resp;
                    }
                })
            },
            initEcharts() { // 初始化图表
                this.$getRequest('/data/articleCounts').then(resp => {
                    if (resp) {
                        let arrTitle = [];
                        let arrCounts = [];
                        resp.forEach((item,index) => {
                            arrTitle.push(item.cname);
                            arrCounts.push(item.counts);
                        })
                        // 基于准备好的dom，初始化echarts实例
                        let myChart = this.$echarts.init(this.$refs['main']);
                        // 指定图表的配置项和数据
                        let option = {
                            title: {
                                text: '各栏目下文章数量'
                            },
                            tooltip: {},
                            legend: {
                                data:['数量']
                            },
                            xAxis: {
                                data: arrTitle
                            },
                            yAxis: {},
                            series: [{
                                name: '数量',
                                type: 'bar',
                                data: arrCounts
                            }]
                        };

                        // 使用刚指定的配置项和数据显示图表。
                        myChart.setOption(option);
                    }
                })

            }
        },
        mounted() {
            this.initEcharts();
            this.initMonthTopTen();
        }
    }
</script>

<style scoped>
    .text {
        font-size: 14px;
        display: flex;
        justify-content: space-between;
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
    }
</style>