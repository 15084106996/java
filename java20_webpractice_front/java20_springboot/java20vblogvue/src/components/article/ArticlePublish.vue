<template>
    <div>
        <div class="publishHeader">
            <el-select style="width: 260px" size="mini" v-model="articleInfo.cid" placeholder="请选择">
                <el-option
                        style="display: flex;justify-content: space-between;align-items: center"
                        v-for="item in childCatesOptions"
                        :key="item.id"
                        :label="item.cname"
                        :value="item.id">
                    <span style="float: left">{{ item.cname }}</span>
                    <el-tag size="mini" type="danger" style="font-size: 12px">{{ item.parent.cname }}</el-tag>
                </el-option>
            </el-select>
            <el-input v-model="articleInfo.title" class="titleClass" placeholder="文章标题" size="mini"></el-input>
        </div>
        <div>
            <mavon-editor @change="meChange" style="height: 500px" v-model="articleInfo.mdContent"></mavon-editor>
            <div style="display: flex;justify-content: flex-end;margin-top: 8px">
                <el-button @click="saveArticle(2)">保存草稿</el-button>
                <el-button @click="saveArticle(1)" type="primary">发布文章</el-button>
            </div>
        </div>
    </div>
</template>

<script>
    export default {
        name: "ArticlePublish",
        data() {
            return {
                childCatesOptions: [],// 子栏目信息
                articleInfo :{ // 文章信息
                    id : null,
                    cid : '', // 类别id
                    title: '',// 文章标题
                    mdContent :'',// 文章markdown信息
                    htmlContent: '',// markdown渲染后的html内容
                    status : -1, // 文章状态
                }
            }
        },
        methods: {
            saveArticle(status) { // 点击发布或保存文章
                if (this.articleInfo.cid != '' && this.articleInfo.title != '' && this.articleInfo.mdContent != '') {
                    this.articleInfo.status = status;
                    if (this.articleInfo.id == null) {
                        this.$postRequest('/article/',this.articleInfo).then(resp =>{
                            if (resp) {
                                this.articleInfo.id = resp.obj.id;
                            }
                        })
                    }else{
                        this.$putRequest('/article/',this.articleInfo).then(resp =>{})
                    }
                }
                else{
                    this.$message.warning('文章信息请填写完整');
                }
            },
            meChange(md,html) { // mavonEditor 内容变化 回调
                this.articleInfo.mdContent = md;
                this.articleInfo.htmlContent = html;
            },
            initChildCateInfos() { // 查询所有子栏目
                this.$getRequest('/article/getChildCateInfos').then(resp => {
                    if (resp) {
                        this.childCatesOptions = resp;
                    }
                })
            }
        },
        mounted() {
            if (this.$route.query.id) {
                // 根据id查询文章
                this.$getRequest('/article/getArticleById?id='+this.$route.query.id).then(resp => {
                    if (resp) {
                        Object.assign(this.articleInfo, resp);
                    }
                })
            }
            this.initChildCateInfos();
        }
    }
</script>

<style scoped>
    .publishHeader{
        display: flex;
        margin: 8px 0;
    }
    .titleClass{
        width: 400px;
        margin-left: 10px;
    }
</style>