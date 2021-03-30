package org.neuedu.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.neuedu.mapper.CategoryMapper;
import org.neuedu.model.Category;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        CategoryMapper mapper = sqlSession.getMapper(CategoryMapper.class);

        List<Category> categories3 = mapper.getAllCategories3();
        System.out.println(new ObjectMapper().writeValueAsString(categories3));

//        List<Category> categories2 = mapper.getAllCategories2();
//        System.out.println(new ObjectMapper().writeValueAsString(categories2));
        // 新增
//        Category category = new Category();
//        category.setParentId(1L);
//        category.setCname("冰箱");
//        mapper.addCategory(category);
//        sqlSession.commit();
        // 删除
//        int[] ids = {10, 12};
//        mapper.multiDelCategory(ids);
//        sqlSession.commit();
//        // 修改
//        Category category1 = new Category();
//        category1.setCname("随机化学品");
//        category1.setId(14L);
//        mapper.updateCategory(category1);
//        sqlSession.commit();

//        // 查询
//        List<Category> categories = mapper.getCategories("品");
//        System.out.println(categories);

//        List<Category> allCategories = mapper.getAllCategories(1L);
//        System.out.println(allCategories);
    }
}
