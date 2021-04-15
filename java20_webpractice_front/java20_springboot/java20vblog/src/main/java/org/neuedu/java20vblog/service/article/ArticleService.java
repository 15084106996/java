package org.neuedu.java20vblog.service.article;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.neuedu.java20vblog.mapper.ArticleMapper;
import org.neuedu.java20vblog.model.Article;
import org.neuedu.java20vblog.model.Category;
import org.neuedu.java20vblog.model.RespBean;
import org.neuedu.java20vblog.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class ArticleService {
    @Autowired
    ArticleMapper articleMapper;
    public List<Category> getChildCateInfos() {
        return articleMapper.getChildCateInfos();
    }

    public RespBean publishArticle(Article article) {
        // 获取登录者信息
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        article.setUid(user.getId());
        int i = articleMapper.publishArticle(article);
        if (i == 0) {
            return RespBean.error(500, "发布文章失败");
        }else{
            return RespBean.success(200, "发布文章成功",article);
        }
    }

    public RespBean modifyArticle(Article article) {
        article.setUpdateTime(new Date());
        int i = articleMapper.modifyArticle(article);
        if (i == 0) {
            return RespBean.error(500, "修改文章失败");
        }else{
            return RespBean.success(200, "修改文章成功");
        }
    }

    public PageInfo getArticleInfos(String keyWords, int pageNum, int pageSize, int status) {
        PageHelper.startPage(pageNum, pageSize);
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<Article> articleList = articleMapper.getArticleInfos(keyWords, status,user.getId());
        PageInfo pageInfo = new PageInfo(articleList);
        return pageInfo;
    }

    public Article getArticleById(int id) {
        return articleMapper.getArticleById(id);
    }

    public Article getArticleDetailsById(int id) {
        Article details = articleMapper.getArticleDetailsById(id);
        if (details != null) {
            articleMapper.updateViewsByArticleId(id);
        }
        return details;
    }
}
