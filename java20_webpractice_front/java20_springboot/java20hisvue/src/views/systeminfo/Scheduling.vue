<template>
    <div>
        <div class="header">
            <span>开始时间：</span>
            <el-date-picker
                    value-format="yyyy-MM-dd"
                    style="width: 140px;margin-right: 8px;"
                    size="mini"
                    v-model="alreaySche.startDate"
                    type="date"
                    placeholder="选择日期">
            </el-date-picker>
            <span>结束时间：</span>
            <el-date-picker
                    value-format="yyyy-MM-dd"
                    style="width: 140px;margin-right: 8px;"
                    size="mini"
                    v-model="alreaySche.endingDate"
                    type="date"
                    placeholder="选择日期">
            </el-date-picker>
            <el-button size="mini" type="primary" @click="searchSche">查询医生排班</el-button>
            <el-button size="mini" type="primary" @click="showRuleDialog">新增排班规则</el-button>
            <el-button size="mini" type="primary">查询排班规则（生成排班计划）</el-button>
        </div>
        <div>
            <el-table
                    :data="scheData">
                <el-table-column
                        type="selection"
                        width="55">
                </el-table-column>
                <el-table-column
                        prop="scheddate"
                        label="日期"
                        width="120">
                </el-table-column>
                <el-table-column
                        prop="dept.deptname"
                        label="科室"
                        width="120">
                </el-table-column>
                <el-table-column
                        prop="user.realname"
                        label="医生"
                        width="120">
                </el-table-column>
                <el-table-column
                        prop="noon"
                        label="午别"
                        width="120">
                </el-table-column>
                <el-table-column
                        prop="user.level.registname"
                        label="挂号级别"
                        width="120">
                </el-table-column>
                <el-table-column
                        prop="user.level.registquota"
                        label="挂号限额"
                        width="120">
                </el-table-column>
            </el-table>
        </div>
        <el-pagination
                @current-change="currentChange1"
                :current-page="pageNum1"
                :page-size="pageSize1"
                background
                layout="prev, pager, next"
                :total="total1">
        </el-pagination>
        <!--新增排班规则dialog-->
        <el-dialog
                center
                title="新增排班规则"
                :visible.sync="dialogVisible1"
                width="95%">
            <div>
                <div style="text-align: center">
                    <span>科室选择 ： </span>
                    <el-select class="selWidth" size="mini" v-model="value" placeholder="请选择">
                        <el-option
                                v-for="item in options"
                                :key="item.value"
                                :label="item.label"
                                :value="item.value">
                        </el-option>
                    </el-select>
                    <span>挂号级别 ： </span>
                    <el-select class="selWidth" size="mini" v-model="value" placeholder="请选择">
                        <el-option
                                v-for="item in options"
                                :key="item.value"
                                :label="item.label"
                                :value="item.value">
                        </el-option>
                    </el-select>
                    <el-button size="mini" type="primary">查询</el-button>
                    <el-button size="mini" type="primary">清空</el-button>
                </div>
                <!-- 规则数据 -->
                <div style="margin: 8px 0;">
                    <el-table
                            border
                            :data="tableData"
                            style="width: 100%">
                        <el-table-column
                                type="selection"
                                width="55">
                        </el-table-column>
                        <el-table-column
                                label="医生姓名">
                        </el-table-column>
                        <el-table-column
                                label="周一上午">
                        </el-table-column>
                        <el-table-column
                                label="周一下午">
                        </el-table-column>
                        <el-table-column
                                label="周二上午">
                        </el-table-column>
                        <el-table-column
                                label="周二下午">
                        </el-table-column>
                        <el-table-column
                                label="周三上午">
                        </el-table-column>
                        <el-table-column
                                label="周三下午">
                        </el-table-column>
                        <el-table-column
                                label="周四上午">
                        </el-table-column>
                        <el-table-column
                                label="周四下午">
                        </el-table-column>
                        <el-table-column
                                label="周五上午">
                        </el-table-column>
                        <el-table-column
                                label="周五下午">
                        </el-table-column>
                        <el-table-column
                                label="周六上午">
                        </el-table-column>
                        <el-table-column
                                label="周六下午">
                        </el-table-column>
                        <el-table-column
                                label="周日上午">
                        </el-table-column>
                        <el-table-column
                                label="周日下午">
                        </el-table-column>
                    </el-table>
                </div>
                <div style="text-align: center">
                    <span>规则名称 ： </span>
                    <el-input placeholder="规则名称" class="selWidth" size="mini"></el-input>
                    <span style="color: red"> * </span>
                </div>
            </div>
            <span slot="footer">
                <el-button @click="dialogVisible1 = false" size="mini" type="warning">取 消</el-button>
                <el-button type="primary" size="mini">保存</el-button>
            </span>
        </el-dialog>
    </div>
</template>

<script>
    export default {
        name: "Scheduling",
        data() {
            return {
                dialogVisible1: false,
                total1 : 0,
                pageSize1:8,
                pageNum1:1,
                scheData : [],// 排班信息
                alreaySche : { // 排班管理 开始时间和结束时间
                    startDate : '',
                    endingDate : '',
                }
            };
        },
        methods :{
            showRuleDialog() { // 显示规则对话框
                this.dialogVisible1 = true;
                // 发送 请求 要 科室 和 挂号级别 数据
            },
            searchSche() {
                this.pageNum1 = 1;
                this.initScheData();
            },
            currentChange1(pageNum) { // 翻页
                this.pageNum1 = pageNum;
                this.initScheData();
            },
            initScheData() { // 初始化排班信息列表
                this.$getRequest('/sche/?pageNum='+this.pageNum1+'&pageSize='+this.pageSize1+'&startDate='+this.alreaySche.startDate+'&endingDate='+this.alreaySche.endingDate).then(resp => {
                    if (resp) {
                        this.scheData = resp.list;
                        this.total1 = resp.total;
                    }
                })
            }
        },
        mounted() {
            this.initScheData();
        }
    }
</script>

<style scoped>
    .header{
        font-size: 14px;
    }
    .header span{
        margin-right: 8px;
    }
    .selWidth{
        width: 120px;
        margin-right: 8px;
    }
</style>