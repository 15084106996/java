<template>
    <div>
        <div class="classHeader">
            <el-input v-model="cidOrTname" placeholder="请输入教师姓名或班级编号" size="small" style="width: 350px"></el-input>
            <el-button @click="initClassInfos" size="small" icon="el-icon-search" type="primary">搜索</el-button>
            <el-button size="small" type="primary" icon="el-icon-plus" @click="showAddDialog">新增班级</el-button>
        </div>
        <div>
            <el-tag style="margin-bottom: 10px">班级信息</el-tag>
            <el-table
                    :data="classInfos"
                    style="width: 100%">
                <el-table-column
                        type="selection"
                        width="55">
                </el-table-column>
                <el-table-column
                        prop="id"
                        label="班级编号">
                </el-table-column>
                <el-table-column
                        label="班级名称">
                    <template slot-scope="scope">
                        <el-tag>{{ scope.row.cname }}</el-tag>
                    </template>
                </el-table-column>
                <el-table-column
                        label="带班教师">
                    <template slot-scope="scope">
                        <el-button type="text">{{ scope.row.teacher.tname }}</el-button>
                    </template>
                </el-table-column>
                <el-table-column
                        prop="openTime"
                        label="开班时间">
                </el-table-column>
                <el-table-column
                        prop="closeTime"
                        label="毕业时间">
                </el-table-column>
                <el-table-column
                        label="班级类型">
                    <template slot-scope="scope">
                        <el-tag type="warning" v-if="scope.row.type == 2">高校</el-tag>
                        <el-tag type="warning" v-else-if="scope.row.type == 1">社招</el-tag>
                        <el-tag type="warning" v-else-if="scope.row.type == 3">其他</el-tag>
                    </template>
                </el-table-column>
                <el-table-column
                        label="管理班级">
                    <template slot-scope="scope">
                        <el-button
                                size="mini"
                                @click="handleManage(scope.row)" type="danger">管理</el-button>
                    </template>
                </el-table-column>
            </el-table>
        </div>
        <!--新增班级-->
        <el-dialog
                title="新增班级"
                :visible.sync="dialogVisible"
                width="40%">
            <div>
                <div>
                    <el-tag>班级名称</el-tag>
                    <el-input style="width: 200px" v-model="addClass.cname" size="small" placeholder="请填写班级名称"></el-input>
                </div>
                <div style="margin: 10px 0;">
                    <el-tag>班级类型</el-tag>
                    <el-select style="width: 100px" size="small" v-model="addClass.type" placeholder="请选择">
                        <el-option
                                v-for="item in options"
                                :key="item.value"
                                :label="item.label"
                                :value="item.value">
                        </el-option>
                    </el-select>
                </div>
                <div>
                    <el-tag>指派教师</el-tag>
                    <el-select v-model="addClass.tid" style="width: 120px" size="small" placeholder="请选择">
                        <el-option
                                v-for="item in teacherInfos"
                                :key="item.id"
                                :label="item.tname"
                                :value="item.id">
                        </el-option>
                    </el-select>
                </div>
            </div>
            <span slot="footer" class="dialog-footer">
                <el-button size="small" @click="dialogVisible = false">取 消</el-button>
                <el-button size="small" type="primary" @click="submitAddClass">确 定</el-button>
            </span>
        </el-dialog>
        <!--    管理班级    -->
        <el-dialog
                title="管理班级"
                :visible.sync="dialogVisible2"
                width="40%">
            <div>
                <div>
                    <el-tag>班级名称</el-tag>
                    <el-input style="width: 200px" v-model="updatedClass.cname" size="small" placeholder="请填写班级名称"></el-input>
                </div>
                <div style="margin: 10px 0;">
                    <el-tag>班级类型</el-tag>
                    <el-select style="width: 100px" size="small" v-model="updatedClass.type" placeholder="请选择">
                        <el-option
                                v-for="item in options"
                                :key="item.value"
                                :label="item.label"
                                :value="item.value">
                        </el-option>
                    </el-select>
                </div>
                <div>
                    <el-tag>当前教师</el-tag>
                    <el-select v-model="updatedClass.teacher.id" style="width: 120px" size="small" placeholder="请选择">
                        <el-option
                                v-for="item in teacherInfos"
                                :key="item.id"
                                :label="item.tname"
                                :value="item.id">
                        </el-option>
                    </el-select>
                </div>
                <div>
                    <el-tag>是否结班</el-tag>
                    <el-switch
                            v-model="updatedClass.yesOrNot"
                            active-text="毕业"
                            inactive-text="未毕业">
                    </el-switch>
                </div>
            </div>
            <span slot="footer" class="dialog-footer">
                <el-button size="small" @click="dialogVisible2 = false">取 消</el-button>
                <el-button size="small" type="primary" @click="submitUpdateClassInfo">确 定</el-button>
            </span>
        </el-dialog>
    </div>
</template>

<script>
    module.exports = {
        data() {
            return {
                updatedClass: { // 修改的班级
                    id : 0,
                    cname: '',
                    type : 1,
                    teacher : {
                        id : 1
                    },
                    tid : -1,
                    closeTime : null,
                    yesOrNot: null,
                },
                teacherInfos: [],// 教师信息下拉框数据
                addClass: { //
                    cname: '',// 新增班级名称
                    type: 1,// 班级类型
                    tid : '' // 教师编号
                },
                options: [// 班级类型下拉选项
                    {
                        value: 1,
                        label:'社招'
                    },
                    {
                        value: 2,
                        label:'高校'
                    },
                    {
                        value: 3,
                        label:'其他'
                    },
                ],
                dialogVisible : false,// 是否显示对话框的标记
                dialogVisible2 : false,// 是否显示对话框的标记
                cidOrTname : '',// 班级编号或教师姓名
                classInfos :[],// 班级信息列表
            }
        },
        methods:{
            submitUpdateClassInfo() {// 修改班级信息
                // 发送 修改 请求
                this.updatedClass.tid = this.updatedClass.teacher.id;
                postRequest('http://localhost:8081/updateClassInfo',this.updatedClass).then(resp => {
                    if (resp.status == 200) {
                        if (resp.data.code == 200) {
                            this.$message.success(resp.data.msg);
                        }else{
                            this.$message.error(resp.data.msg);
                        }
                        this.dialogVisible2 = false;
                        this.initClassInfos();
                    }
                })
            },
            handleManage(row) { // 显示管理对话框
                Object.assign(this.updatedClass,row);
                if (this.updatedClass.closeTime == null) {
                    this.updatedClass.yesOrNot = false;
                }else{
                    this.updatedClass.yesOrNot = true;
                }
                this.initTeacherInfos();
                this.dialogVisible2 = true;
            },
            submitAddClass() {// 新增班级
                if (this.addClass.tid == '' || this.addClass.cname == '') {
                    this.$message.warning('请填写完整数据')
                }else{
                    // 发送新增请求
                    postRequest('http://localhost:8081/addClass',this.addClass).then(resp => {
                        if (resp.status == 200) {
                            if (resp.data && resp.data.code == 200) {
                                this.$message.success(resp.data.msg);
                                this.dialogVisible = false;
                                this.initClassInfos();
                            }else{
                                this.$message.error(resp.data.msg);
                            }
                        }
                    })
                }
            },
            showAddDialog() { // 显示新增班级对话框
                this.dialogVisible = true;
                this.addClass.tid = ''; // 清空数据
                this.addClass.cname = ''; // 清空数据
                this.addClass.type = 1; // 清空数据
                this.initTeacherInfos();
            },
            initTeacherInfos() {// 查询在职教师
                getRequest('http://localhost:8081/serchIdelTeacher').then(resp => {
                    if (resp.status == 200) {
                        if (resp.data) {
                            this.teacherInfos = resp.data;
                        }
                    }
                })
            },
            initClassInfos() { // 查询班级
                getRequest('http://localhost:8081/findClassInfos?cidOrTname='+this.cidOrTname).then(resp => {
                    if (resp.status == 200) {
                        if (resp.data) {
                            this.classInfos = resp.data;
                        }
                    }
                })
            }
        },
        mounted() {
            this.initClassInfos();
        }
    }
</script>

<style scoped>
    .classHeader{
        margin: 10px 0;
    }
</style>