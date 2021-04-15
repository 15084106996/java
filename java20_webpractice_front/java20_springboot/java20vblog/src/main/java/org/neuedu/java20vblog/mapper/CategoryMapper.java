package org.neuedu.java20vblog.mapper;

import org.apache.ibatis.annotations.Param;
import org.neuedu.java20vblog.model.Category;

import java.util.List;

public interface CategoryMapper {
    List<Category> getCategoryInfos(String keyWords);

    int checkCateRepeat(Category category);

    int addCate(Category category);

    List<Category> getParentCategory(int i);

    int getCategoryByParentId(int id);

    int delCategoryById(int id);

    int updateCategory(Category category);

    int multiDelCates(@Param("ids") int[] ids);
}
