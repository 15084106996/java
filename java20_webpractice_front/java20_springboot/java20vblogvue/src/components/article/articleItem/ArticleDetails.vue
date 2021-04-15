<template>
    <div>
        <h3 style="text-align: center;color: #409EFF">{{articleDetails.title}}</h3>
        <div class="headerInfo" style="font-size: 14px;color: #409EFF;text-align: center">
            <span>从属类别：{{articleDetails.category.cname}}</span>
            <span>作者：{{articleDetails.user.nickname}}</span>
            <span>创建时间：{{articleDetails.publishTime}}</span>
            <span>更新时间：{{articleDetails.updateTime}}</span>
            <span>浏览量：{{articleDetails.views+1}}</span>
            <span v-if="articleDetails.status == 1">文章状态：<el-tag size="mini">已发布</el-tag></span>
            <span v-if="articleDetails.status == 2">文章状态：<el-tag size="mini" type="success">草稿箱</el-tag></span>
            <span v-if="articleDetails.status == 3">文章状态：<el-tag size="mini" type="danger">回收站</el-tag></span>
        </div>
        <div v-html="articleDetails.htmlContent">

        </div>
    </div>
</template>

<script>
    export default {
        name: "ArticleDetails",
        data() {
            return {
                articleDetails :{}
            }
        },
        methods: {
            initDetailsById(id) {
                this.$getRequest('/article/getArticleDetailsById?id='+id).then(resp => {
                    if (resp) {
                        this.articleDetails = resp;
                    }
                })
            }
        },
        mounted() {
            if (this.$route.query.id) {
                // 查询文章信息
                this.initDetailsById(this.$route.query.id);
            }
        }
    }
</script>

<style scoped>
    .headerInfo *{
        margin-right: 8px;
    }
</style>