package org.neuedu.java20vblog.service.category;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.neuedu.java20vblog.mapper.CategoryMapper;
import org.neuedu.java20vblog.model.Category;
import org.neuedu.java20vblog.model.RespBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//import java.util.Date;
import java.util.List;

@Service
@Transactional
public class CategoryService {
    @Autowired
    CategoryMapper categoryMapper;
    public PageInfo getCategoryInfos(String keyWords, int pageNum, int pageSize) {
        // 开启分页
        PageHelper.startPage(pageNum, pageSize);
        List<Category> list = categoryMapper.getCategoryInfos(keyWords);
        PageInfo pageInfo = new PageInfo(list);
        return pageInfo;
    }

    public RespBean addCate(Category category) {
        int num = categoryMapper.checkCateRepeat(category);
        if (num != 0) {
            return RespBean.error(500, "新增栏目名称重复，请重新填写");
        }else{
//            category.setCreateTime(new Date());
            int i = categoryMapper.addCate(category);
            if (i == 0) {
                return RespBean.error(500, "新增栏目失败");
            }else{
                return RespBean.success(200, "新增栏目成功");
            }
        }
    }

    public List<Category> getParentCategory() {
        return categoryMapper.getParentCategory(-1);
    }

    public RespBean delCategoryById(int id) {
        int num = categoryMapper.getCategoryByParentId(id);
        if (num != 0) {
            return RespBean.error(500, "删除栏目失败，栏目下有子选项");
        }else{
            int i = categoryMapper.delCategoryById(id);
            if (i == 0) {
                return RespBean.error(500, "删除栏目失败");
            }else{
                return RespBean.success(200, "删除栏目成功");
            }
        }
    }

    public RespBean updateCategory(Category category) {
        int num = categoryMapper.checkCateRepeat(category);
        if (num != 0) {
            return RespBean.error(500, "更新的栏目名称有重复，请重新填写");
        }else{
            int i = categoryMapper.updateCategory(category);
            if (i == 0) {
                return RespBean.error(500, "更新栏目失败");
            }else{
                return RespBean.success(200, "更新栏目成功");
            }
        }
    }

    public RespBean multiDelCates(int[] ids) {
        for (int id : ids) {
            int num = categoryMapper.getCategoryByParentId(id);
            if (num != 0) {
                return RespBean.error(500, "批量删除失败，删除的栏目中包含子栏目");
            }
        }
        categoryMapper.multiDelCates(ids);
        return RespBean.success(200, "批量删除成功");
    }
}
