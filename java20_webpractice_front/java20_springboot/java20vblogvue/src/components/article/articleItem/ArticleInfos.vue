<template>
    <div>
        <el-table
                v-loading="articleLoading"
                ref="multipleTable"
                :data="articleInfos"
                tooltip-effect="dark"
                style="width: 100%">
            <el-table-column
                    type="selection"
                    width="55">
            </el-table-column>
            <el-table-column
                    label="文章标题"
                    width="180">
                <template slot-scope="scope">
                    <el-button type="text" @click="searchArticleDetails(scope.row.id)">{{ scope.row.title }}</el-button>
                </template>
            </el-table-column>
            <el-table-column
                    prop="category.cname"
                    label="从属类别"
                    width="120">
            </el-table-column>
            <el-table-column
                    prop="user.nickname"
                    label="作者姓名"
                    width="120">
            </el-table-column>
            <el-table-column
                    prop="publishTime"
                    label="创建时间"
                    width="200">
            </el-table-column>
            <el-table-column label="操作">
                <template slot-scope="scope">
                    <el-button
                            v-if="edit"
                            size="mini"
                            @click="handleArticleEdit(scope.row)">编辑</el-button>
                    <el-button
                            v-if="recover"
                            size="mini"
                            @click="handleEdit(scope.$index, scope.row)">恢复成草稿</el-button>
                    <el-button
                            v-if="deleteFlag"
                            size="mini"
                            type="danger"
                            @click="handleDelete(scope.$index, scope.row)">删除</el-button>
                </template>
            </el-table-column>
        </el-table>
        <el-pagination
                @current-change="currentChange"
                style="margin: 10px 0;"
                :page-size="pageSize"
                :current-page="pageNum"
                background
                layout="prev, pager, next"
                :total="total">
        </el-pagination>
    </div>
</template>

<script>
    export default {
        name: "ArticleInfos",
        data() {
            return {
                newkeyWords : '',// 保存关键字
                total : 0,
                pageNum : 1,// 页码
                pageSize :5,// 每页记录数
                articleLoading :  true,// 加载文章loading
                articleInfos: [],// 文章信息列表
            }
        },
        props : ['deleteFlag','edit','recover','status'],
        methods: {
            searchArticleDetails(id) { // 点击文章标题查看文章
                this.$router.push({
                    path : '/ArticleDetails',
                    query : {
                        id : id
                    }
                })
            },
            handleArticleEdit(row) { // 点击文章编辑按钮
                this.$router.push({
                    path: '/ArticlePublish',
                    query : {
                        id : row.id
                    }
                })
            },
            currentChange(pageNum) { // 点击换页
                this.pageNum = pageNum;
                this.initArticleInfos(this.newkeyWords);
            },
            initArticleInfos(keyWords) {// 查询文章信息
                if (keyWords) {
                    this.newkeyWords = keyWords;
                    // 发送 查询 文章 请求
                    this.$getRequest('/article/?keyWords='+this.newkeyWords+'&pageNum='+this.pageNum+'&pageSize='+this.pageSize+'&status='+this.status).then(resp => {
                        if (resp) {
                            this.articleInfos = resp.list;
                            this.total = resp.total;
                            this.articleLoading = false;
                        }
                    });
                }else{
                    this.newkeyWords = '';
                    this.$getRequest('/article/?pageNum='+this.pageNum+'&pageSize='+this.pageSize+'&status='+this.status).then(resp => {
                        if (resp) {
                            this.articleInfos = resp.list;
                            this.total = resp.total;
                            this.articleLoading = false;
                        }
                    });
                }
            }
        },
        mounted() {
            this.initArticleInfos();
        }
    }
</script>

<style scoped>

</style>