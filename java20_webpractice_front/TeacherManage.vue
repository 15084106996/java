<template>
    <div>
        <div class="teacherHeader">
            <el-input v-model="paramsObj.idOrName" placeholder="请输入教师编号或姓名..." size="small" style="width: 350px"></el-input>
            <el-button @click="serchByIdOrName" size="small" icon="el-icon-search" type="primary">搜索</el-button>
        </div>
        <div>
            <el-tag style="margin-bottom: 10px">教师信息</el-tag>
            <!--讲师信息表格-->
            <el-table
                    @selection-change="selectionChange"
                    border
                    :data="teacherInfos"
                    style="width: 100%">
                <el-table-column
                        type="selection"
                        width="55">
                </el-table-column>
                <el-table-column
                        fixed
                        prop="id"
                        width="120"
                        label="编号">
                </el-table-column>
                <el-table-column
                        width="180"
                        prop="tname"
                        label="姓名">
                </el-table-column>
                <el-table-column
                        width="180"
                        prop="nation"
                        label="民族">
                </el-table-column>
                <el-table-column
                        width="60"
                        label="性别">
                    <template slot-scope="scope">
                        <el-tag type="success" v-if="scope.row.gender">女</el-tag>
                        <el-tag type="success" v-else>男</el-tag>
                    </template>
                </el-table-column>
                <el-table-column
                        width="180"
                        prop="birthday"
                        label="出生日期">
                </el-table-column>
                <el-table-column
                        width="200"
                        prop="mobile"
                        label="联系电话">
                </el-table-column>
                <el-table-column
                        width="180"
                        prop="educate"
                        label="学历">
                </el-table-column>
                <el-table-column
                        width="180"
                        prop="school"
                        label="毕业院校">
                </el-table-column>
                <el-table-column
                        width="180"
                        prop="joinTime"
                        label="入职时间">
                </el-table-column>
                <el-table-column
                        width="180"
                        prop="leaveTime"
                        label="离职时间">
                </el-table-column>
                <el-table-column
                        width="100"
                        label="状态">
                    <template slot-scope="scope">
                        <el-tag type="success" v-if="scope.row.status">在职</el-tag>
                        <el-tag type="danger" v-else>离职</el-tag>
                    </template>
                </el-table-column>
                <el-table-column v-if="flag == 200" label="操作" width="180" fixed="right">
                    <template slot-scope="scope">
                        <el-button
                                size="mini"
                                @click="handleEdit(scope.row)">编辑</el-button>
                        <el-button
                                size="mini"
                                type="danger"
                                @click="handleDelete(scope.row)">删除</el-button>
                    </template>
                </el-table-column>
            </el-table>
            <el-button :disabled="selections.length == 0" size="small" type="danger" @click="multiDeleteTeacher">批量删除</el-button>
            <el-pagination
                    background
                    @current-change="currentChange"
                    :current-page="paramsObj.pageNum"
                    :page-size="paramsObj.pageSize"
                    layout="prev, pager, next"
                    :total="total">
            </el-pagination>
        </div>
        <!-- 编辑框 -->
        <el-dialog
                title="用户信息"
                :visible.sync="dialogVisible"
                width="60%">
            <div class="editDialog">
                <div>
                    <el-tag>用户编号</el-tag> <el-input readonly v-model="editedTeacher.id" size="small" style="width: 150px;" placeholder="用户编号"></el-input>
                    <el-tag>用户姓名</el-tag> <el-input v-model="editedTeacher.tname" size="small" style="width: 150px;" placeholder="用户姓名"></el-input>
                    <el-tag>民族</el-tag> <el-input v-model="editedTeacher.nation" size="small" style="width: 150px;" placeholder="民族"></el-input>
                </div>
                <div>
                    <el-tag>性别</el-tag>
                    <el-switch
                            style="display: inline"
                            v-model="editedTeacher.gender"
                            active-color="#13ce66"
                            inactive-color="#409eff"
                            active-text="女"
                            inactive-text="男">
                    </el-switch>
                    <el-tag>出生日期</el-tag>
                    <el-date-picker
                            value-format="yyyy-MM-dd"
                            size="small"
                            v-model="editedTeacher.birthday"
                            type="date"
                            placeholder="选择日期">
                    </el-date-picker>
                    <el-tag>联系电话</el-tag>
                    <el-input v-model="editedTeacher.mobile" size="small" style="width: 150px;" placeholder="联系电话"></el-input>
                </div>
                <div>
                    <el-tag>学历</el-tag>
                    <el-select size="small" v-model="editedTeacher.educate" placeholder="请选择">
                        <el-option
                                v-for="item in options"
                                :key="item.value"
                                :label="item.educate"
                                :value="item.value">
                        </el-option>
                    </el-select>
                    <el-tag>毕业院校</el-tag>
                    <el-input v-model="editedTeacher.school" size="small" style="width: 150px;" placeholder="毕业院校"></el-input>
                </div>
                <div>
                    <el-tag>入职时间</el-tag>
                    <el-date-picker
                            readonly
                            size="small"
                            v-model="editedTeacher.joinTime"
                            type="datetime"
                            placeholder="选择日期时间">
                    </el-date-picker>
                    <el-tag>在职状态</el-tag>
                    <el-switch
                            style="display: inline"
                            v-model="editedTeacher.status"
                            active-color="#13ce66"
                            inactive-color="#ff4949"
                            active-text="在职"
                            inactive-text="离职">
                    </el-switch>
                </div>
            </div>
            <span slot="footer" class="dialog-footer">
                <el-button size="mini" @click="dialogVisible = false">取 消</el-button>
                <el-button size="mini" type="primary" @click="updateTeacherInfos">确 定</el-button>
            </span>
        </el-dialog>
    </div>
</template>

<script>
    module.exports = {
        data(){
            return {
                selections: [],
                options: [
                    {
                        value : '大专',
                        educate : '大专'
                    },
                    {
                        value : '本科',
                        educate : '本科'
                    },
                    {
                        value : '硕士',
                        educate : '硕士'
                    },
                    {
                        value : '博士',
                        educate : '博士'
                    },
                ],
                editedTeacher : {
                    id : 0,
                    tname : '',
                    nation: '',
                    gender : null,
                    birthday: '',
                    mobile : '',
                    educate : '',
                    school: '',
                    joinTime: '',
                    leaveTime : '',
                    status : null
                },
                dialogVisible: false,
                total : 0,
                paramsObj: {
                    pageNum : 1,
                    pageSize: 5,
                    idOrName : ''
                },
                teacherInfos : [],// 教师信息,
            }
        },
        props: ['flag'],
        methods: {
            multiDeleteTeacher() {// 批量删除
                this.$confirm('此操作将删除【'+this.selections.length+'】条记录, 是否继续?', '提示', {
                    confirmButtonText: '确定',
                    cancelButtonText: '取消',
                    type: 'warning'
                }).then(() => {
                    let str = '?';
                    this.selections.forEach((item,index) => {
                        str += 'id='+item.id+'&';
                    })
                    getRequest('http://localhost:8081/multiDeleteTeacher'+str).then(resp => {
                        if (resp.status == 200) {
                            if (resp.data.code == 200) {
                                this.$message.success(resp.data.msg);
                            }else{
                                this.$message.error(resp.data.msg);
                            }
                            this.initTeacherInfos();
                        }
                    })
                }).catch(() => {
                    this.$message({
                        type: 'info',
                        message: '已取消操作'
                    });
                });
            },
            selectionChange(selection) { // 复选框回调
                this.selections = selection;
            },
            handleDelete(row) { // 删除
                this.$confirm('此操作将删除该记录, 是否继续?', '提示', {
                    confirmButtonText: '确定',
                    cancelButtonText: '取消',
                    type: 'warning'
                }).then(() => {
                    getRequest('http://localhost:8081/delTeacher?id='+row.id).then(resp => {
                        if (resp.status == 200) {
                            if (resp.data.code == 200) {
                                this.$message.success(resp.data.msg);
                            }else{
                                this.$message.error(resp.data.msg);
                            }
                            this.initTeacherInfos();
                        }
                    })
                }).catch(() => {
                    this.$message({
                        type: 'info',
                        message: '已取消操作'
                    });
                });
            },
            updateTeacherInfos() { // 修改教师信息
                postRequest('http://localhost:8081/updateTeacherInfo',this.editedTeacher).then(resp => {
                    if (resp.status == 200) {
                        if (resp.data.code == 200) {
                            this.$message.success(resp.data.msg);
                            this.initTeacherInfos();
                        }else{
                            this.$message.error(resp.data.msg)
                        }
                    }
                })
                this.dialogVisible = false;
            },
            handleEdit(row) { // 显示编辑框
                Object.assign(this.editedTeacher,row); // 对象数据拷贝
                this.dialogVisible = true;
            },
            serchByIdOrName() { // 点击搜索
                this.paramsObj.pageNum = 1;
                this.initTeacherInfos();
            },
            currentChange(count) { // 分页回调
                this.paramsObj.pageNum = count;
                this.initTeacherInfos();
            },
            initTeacherInfos() { // 查询教师记录
                getRequest('http://localhost:8081/searchTeachers',this.paramsObj).then(resp => {
                    if (resp.status == 200) {
                        this.teacherInfos = resp.data.data;
                        this.total = resp.data.total;
                    }
                })
            }
        },
        mounted() {
            this.initTeacherInfos();
        }
    }
</script>

<style scoped>
    .teacherHeader{
        margin: 10px 0;
    }
    .editDialog div{
        margin:10px 0;
    }
</style>