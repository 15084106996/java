package org.neuedu.java20vblog.mapper;

import org.neuedu.java20vblog.model.Article;
import org.neuedu.java20vblog.model.Category;

import java.util.List;

public interface ArticleDataMapper {
    List<Category> articleCounts();

    List<Article> topTen();
}
