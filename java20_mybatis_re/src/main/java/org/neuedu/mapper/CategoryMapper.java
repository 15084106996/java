package org.neuedu.mapper;

import org.apache.ibatis.annotations.Param;
import org.neuedu.model.Category;

import java.util.List;

public interface CategoryMapper {
    // 新增
    int addCategory(Category category);

    // 删除
    int multiDelCategory(@Param("ids") int[] ids);

    // 修改
    int updateCategory(Category category);

    // 模糊查询
    List<Category> getCategories(String cname);

    // 查询所有类别信息(动态SQL)
    List<Category> getAllCategories(Long parentId);

    // 查询所有类别子类别
    List<Category> getAllCategories2();

    // 查询所有类别
    List<Category> getAllCategories3();

    // 查询子类别
    List<Category> getChild(Long parentId);
}
