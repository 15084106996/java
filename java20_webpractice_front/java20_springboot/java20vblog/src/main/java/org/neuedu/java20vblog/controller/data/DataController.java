package org.neuedu.java20vblog.controller.data;

import org.neuedu.java20vblog.model.Article;
import org.neuedu.java20vblog.model.Category;
import org.neuedu.java20vblog.service.data.ArticleDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/data")
public class DataController {
    @Autowired
    ArticleDataService articleDataService;
    @GetMapping("/articleCounts")
    public List<Category> articleCounts() {
        return articleDataService.articleCounts();
    }

    @GetMapping("/topTen")
    public List<Article> topTen() {
        return articleDataService.topTen();
    }
}
