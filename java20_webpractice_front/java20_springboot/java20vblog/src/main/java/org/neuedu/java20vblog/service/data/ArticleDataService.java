package org.neuedu.java20vblog.service.data;

import org.neuedu.java20vblog.mapper.ArticleDataMapper;
import org.neuedu.java20vblog.model.Article;
import org.neuedu.java20vblog.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ArticleDataService {
    @Autowired
    ArticleDataMapper articleDataMapper;
    public List<Category> articleCounts() {
        return articleDataMapper.articleCounts();
    }

    public List<Article> topTen() {
        return articleDataMapper.topTen();
    }
}
