<template>
    <div>
        <div>
            <el-input v-model="keyWords" class="inputWidth" size="mini" placeholder="根据栏目名称搜索"></el-input>
            <el-button size="mini" type="primary" icon="fa fa-search" @click="clickSearch"> 搜索</el-button>
            <el-button size="mini" type="primary" icon="fa fa-plus-circle" @click="showAddDialog"> 新增栏目</el-button>
        </div>
        <div>
            <el-table
                    @selection-change="selectionChange"
                    v-loading="loading"
                    :data="cateInfos">
                <el-table-column
                        type="selection"
                        width="55">
                </el-table-column>
                <el-table-column
                        prop="id"
                        label="编号"
                        width="100">
                </el-table-column>
                <el-table-column
                        prop="createTime"
                        label="创建时间"
                        width="200">
                </el-table-column>
                <el-table-column
                        label="从属类别"
                        width="150">
                    <template slot-scope="scope">
                        <el-tag type="danger" v-if="scope.row.parent">{{scope.row.parent.cname}}</el-tag>
                    </template>
                </el-table-column>
                <el-table-column
                        prop="cname"
                        label="类别名称"
                        width="180">
                </el-table-column>
                <el-table-column
                        label="操作"
                        width="180">
                    <template slot-scope="scope">
                        <el-button
                                size="mini"
                                @click="showEditDialog(scope.row)">编辑</el-button>
                        <el-button
                                size="mini"
                                type="danger"
                                @click="handleDelete(scope.row)">删除</el-button>
                    </template>
                </el-table-column>
            </el-table>
        </div>
        <!--批量删除栏目按钮-->
        <el-button @click="submitMultiDelCate" :disabled="multiDelItem.length == 0" type="danger" size="mini" style="margin: 8px 0;">批量删除</el-button>
        <el-pagination
                @current-change="currentChange"
                style="margin: 10px 0;"
                :page-size="pageSize"
                :current-page="pageNum"
                background
                layout="prev, pager, next"
                :total="total">
        </el-pagination>
        <!--新增栏目对话框-->
        <el-dialog
                title="新增栏目"
                :visible.sync="addDialogVisible"
                width="30%">
            <div>
                <div>
                    <el-tag style="margin-right: 8px">从属类别</el-tag>
                    <el-select size="mini" v-model="addCateItem.parentId" placeholder="请选择" style="width: 75%">
                        <el-option
                                v-for="item in cateOptions"
                                :key="item.id"
                                :label="item.cname"
                                :value="item.id">
                        </el-option>
                    </el-select>
                </div>
                <div style="margin: 10px 0">
                    <el-tag style="margin-right: 8px">栏目名称</el-tag>
                    <el-input v-model="addCateItem.cname" style="width: 75%" size="mini" placeholder="栏目名称"></el-input>
                </div>
            </div>
            <span slot="footer" class="dialog-footer">
                <el-button size="mini" @click="addDialogVisible = false">取 消</el-button>
                <el-button size="mini" type="primary" @click="submitAddCate">确 定</el-button>
            </span>
        </el-dialog>
        <!--编辑栏目对话框-->
        <el-dialog
                title="编辑栏目"
                :visible.sync="editDialogVisible"
                width="30%">
            <div>
                <div>
                    <el-tag style="margin-right: 8px">从属类别</el-tag>
                    <el-select size="mini" :disabled="editCateItem.parentId==-1" v-model="editCateItem.parentId == -1?'':editCateItem.parentId" placeholder="请选择" style="width: 75%">
                        <el-option
                                v-for="item in cateOptions"
                                :key="item.id"
                                :label="item.cname"
                                :value="item.id">
                        </el-option>
                    </el-select>
                </div>
                <div style="margin: 10px 0">
                    <el-tag style="margin-right: 8px">栏目名称</el-tag>
                    <el-input v-model="editCateItem.cname" style="width: 75%" size="mini" placeholder="栏目名称"></el-input>
                </div>
            </div>
            <span slot="footer" class="dialog-footer">
                <el-button size="mini" @click="editDialogVisible = false">取 消</el-button>
                <el-button size="mini" type="primary" @click="submitUpdateCate">确 定</el-button>
            </span>
        </el-dialog>
    </div>
</template>

<script>
    export default {
        name: "CategoryManage",
        data() {
            return {
                multiDelItem: [],// 批量删除的选项
                editCateItem: { // 编辑栏目对象
                    parentId: '', // 从属类别id
                    cname: '', // 编辑栏目名称
                    id : '' // 编辑栏目的id
                },
                editDialogVisible: false,//编辑栏目对话框是否显示
                addCateItem: { // 新增栏目对象
                    parentId: '', // 从属类别id
                    cname: '' // 新增栏目名称
                },
                cateOptions: [],// 类别选项
                addDialogVisible: false,//新增栏目对话框是否显示
                loading: true,// 加载
                total: 0, // 数据总数
                keyWords: '',// 搜索关键字
                pageNum: 1, // 当前页
                pageSize: 8, // 每页记录个数
                cateInfos: [],// 类别信息
            };
        },
        methods:{
            submitMultiDelCate() { // 点击批量删除按钮
                this.$confirm('此操作将永久删除【'+this.multiDelItem.length+'】项栏目, 是否继续?', '提示', {
                    confirmButtonText: '确定',
                    cancelButtonText: '取消',
                    type: 'warning'
                }).then(() => {
                    // 发送 批量删除 请求
                    let str = '?';
                    this.multiDelItem.forEach((item,index) => {
                        str += 'ids='+item.id+'&'
                    })
                    this.$delRequest('/category/multiDelCates'+str).then(resp => {
                        this.pageNum = 1;
                        this.initCategoryInfos();
                    })
                }).catch(() => {
                    this.$message({
                        type: 'info',
                        message: '已取消删除'
                    });
                });
            },
            selectionChange(selection) {// 复选框回调
                this.multiDelItem = selection;
            },
            submitUpdateCate() { // 点击编辑栏目确定按钮
                this.$putRequest('/category/',this.editCateItem).then(resp=>{
                    this.pageNum = 1;
                    this.editDialogVisible = false;
                    this.initCategoryInfos();
                })
            },
            showEditDialog(row) { // 显示编辑对话框
                this.editDialogVisible = true;
                this.initParentCategory();
                // 属性拷贝
                Object.assign(this.editCateItem,row);
            },
            handleDelete(row) { // 点击删除栏目按钮
                this.$confirm('此操作将永久删除【'+row.cname+'】栏目, 是否继续?', '提示', {
                    confirmButtonText: '确定',
                    cancelButtonText: '取消',
                    type: 'warning'
                }).then(() => {
                    // 发送删除栏目请求
                    this.$delRequest('/category/'+row.id).then(resp=>{
                        this.pageNum = 1;
                        this.initCategoryInfos();
                    })
                }).catch(() => {
                    this.$message({
                        type: 'info',
                        message: '已取消删除'
                    });
                });
            },
            submitAddCate() { // 点击新增栏目确定按钮
                if (this.addCateItem.cname != '') {
                    this.$postRequest('/category/',this.addCateItem).then(resp =>{
                        this.pageNum = 1;
                        this.addDialogVisible = false;
                        this.initCategoryInfos();
                    })
                }else{
                    this.$message.warning('栏目名称不能为空');
                }
            },
            showAddDialog() { // 点击新增栏目按钮
                this.addDialogVisible = true;
                // 发送 查询 类别
                this.initParentCategory();
                this.addCateItem.parentId = '';
                this.addCateItem.cname = '';
            },
            initParentCategory() { // 查询顶级类别
                this.$getRequest("/category/getParentCategory").then(resp =>{
                    if (resp) {
                        this.cateOptions = resp;
                    }
                })
            },
            clickSearch() { // 点击搜索按钮
                this.pageNum = 1;
                this.initCategoryInfos();
            },
            currentChange(pageNum) { // 切换页码
                this.pageNum = pageNum;
                this.initCategoryInfos();
            },
            initCategoryInfos() {// 查询类别信息
                this.$getRequest('/category/?keyWords='+this.keyWords+'&pageNum='+this.pageNum+'&pageSize='+this.pageSize).then(resp => {
                    if (resp) {
                        this.cateInfos = resp.list;
                        this.total = resp.total;
                        this.loading = false;
                    }
                })
            }
        },
        mounted() {
            this.initCategoryInfos();
        }
    }
</script>

<style scoped>
    .inputWidth{
        width: 300px;
        margin-right: 10px;
    }
</style>