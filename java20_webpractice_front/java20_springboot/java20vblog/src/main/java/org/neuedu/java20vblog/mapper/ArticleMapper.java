package org.neuedu.java20vblog.mapper;

import org.apache.ibatis.annotations.Param;
import org.neuedu.java20vblog.model.Article;
import org.neuedu.java20vblog.model.Category;

import java.util.List;

public interface ArticleMapper {
    List<Category> getChildCateInfos();

    int publishArticle(Article article);

    int modifyArticle(Article article);

    List<Article> getArticleInfos(@Param("keyWords") String keyWords,@Param("status") int status,@Param("uid") Long uid);

    Article getArticleById(int id);

    Article getArticleDetailsById(int id);

    int updateViewsByArticleId(int id);
}
