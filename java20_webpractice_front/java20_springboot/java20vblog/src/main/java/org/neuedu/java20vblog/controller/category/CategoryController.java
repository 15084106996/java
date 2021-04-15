package org.neuedu.java20vblog.controller.category;

import com.github.pagehelper.PageInfo;
import org.neuedu.java20vblog.model.Category;
import org.neuedu.java20vblog.model.RespBean;
import org.neuedu.java20vblog.service.category.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    CategoryService categoryService;
    @GetMapping("/")
    public PageInfo getCategoryInfos(String keyWords, @RequestParam(value = "pageNum", defaultValue = "1") int pageNum, @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
        return categoryService.getCategoryInfos(keyWords,pageNum,pageSize);
    }

    @PostMapping("/")
    public RespBean addCate(@RequestBody Category category) {
        return categoryService.addCate(category);
    }

    @GetMapping("/getParentCategory")
    public List<Category> getParentCategory() {
        return categoryService.getParentCategory();
    }

    @DeleteMapping("/{id}")
    public RespBean delCategoryById(@PathVariable int id) {
        return categoryService.delCategoryById(id);
    }

    @PutMapping("/")
    public RespBean updateCategory(@RequestBody Category category) {
        return categoryService.updateCategory(category);
    }

    @DeleteMapping("/multiDelCates")
    public RespBean multiDelCates(int[] ids) {
        return categoryService.multiDelCates(ids);
    }
}