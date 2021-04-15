<template>
    <div>
        <div style="margin-bottom:8px;">
            <el-input style="width: 300px;margin-right: 8px" v-model="keyWords" size="mini" placeholder="根据文章标题搜索"></el-input>
            <el-button size="mini" type="primary" icon="fa fa-search" @click="submitSearchArticle">搜索文章</el-button>
        </div>
        <div>
            <el-tabs v-model="activeName" type="card">
                <el-tab-pane label="全部文章" name="all">
                    <ArticleInfos ref="all" :status="0" :deleteFlag="true" :edit="false" :recover="false"></ArticleInfos>
                </el-tab-pane>
                <el-tab-pane label="已发布" name="published">
                    <ArticleInfos ref="published" :status="1" :deleteFlag="true" :edit="true" :recover="false"></ArticleInfos>
                </el-tab-pane>
                <el-tab-pane label="草稿箱" name="draft">
                    <ArticleInfos ref="draft" :status="2" :deleteFlag="true" :edit="true" :recover="false"></ArticleInfos>
                </el-tab-pane>
                <el-tab-pane label="回收站" name="recycle">
                    <ArticleInfos ref="recycle" :status="3" :deleteFlag="true" :edit="false" :recover="true"></ArticleInfos>
                </el-tab-pane>
            </el-tabs>
        </div>
    </div>
</template>

<script>
    import ArticleInfos from './articleItem/ArticleInfos.vue'
    export default {
        name: "ArticleList",
        data() {
            return {
                status : 0,
                activeName : 'all', // 选项卡激活的选项
                keyWords :'', // 文章搜索的款尖子
            };
        },
        methods: {
            submitSearchArticle() { // 点击搜索按钮
                if (this.activeName == 'published') {
                    this.$refs['published'].initArticleInfos(this.keyWords);
                }else if (this.activeName == 'draft') {
                    this.$refs['draft'].initArticleInfos(this.keyWords);
                }else if (this.activeName == 'recycle') {
                    this.$refs['recycle'].initArticleInfos(this.keyWords);
                }else if (this.activeName == 'all') {
                    this.$refs['all'].initArticleInfos(this.keyWords);
                }
            }
        },
        components:{
            ArticleInfos
        }
    }
</script>

<style scoped>

</style>