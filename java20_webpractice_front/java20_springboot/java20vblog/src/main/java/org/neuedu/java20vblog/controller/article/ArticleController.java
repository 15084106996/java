package org.neuedu.java20vblog.controller.article;

import com.github.pagehelper.PageInfo;
import org.neuedu.java20vblog.model.Article;
import org.neuedu.java20vblog.model.Category;
import org.neuedu.java20vblog.model.RespBean;
import org.neuedu.java20vblog.service.article.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    ArticleService articleService;
    @GetMapping("/getChildCateInfos")
    public List<Category> getChildCateInfos() {
        return articleService.getChildCateInfos();
    }

    @PostMapping("/")
    public RespBean publishArticle(@RequestBody Article article) {
        return articleService.publishArticle(article);
    }

    @PutMapping("/")
    public RespBean modifyArticle(@RequestBody Article article) {
        return articleService.modifyArticle(article);
    }

    @GetMapping("/")
    public PageInfo getArticleInfos(String keyWords, @RequestParam(value = "pageNum", defaultValue = "1") int pageNum, @RequestParam(value = "pageSize", defaultValue = "10") int pageSize, int status) {
        return articleService.getArticleInfos(keyWords,pageNum,pageSize,status);
    }

    @GetMapping("/getArticleById")
    public Article getArticleById(int id) {
        return articleService.getArticleById(id);
    }

    @GetMapping("/getArticleDetailsById")
    public Article getArticleDetailsById(int id) {
        return articleService.getArticleDetailsById(id);
    }

}
