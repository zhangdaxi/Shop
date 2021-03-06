package cn.edu.zucc.shop.category.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cn.edu.zucc.shop.category.dao.CategoryDao;
import cn.edu.zucc.shop.category.vo.Category;

/*
 * 一级分类业务层的对象
 */
@Transactional
public class CategoryService {

	// 注入dao
	private CategoryDao categoryDao;

	public void setCategoryDao(CategoryDao categoryDao) {
		this.categoryDao = categoryDao;
	}

	//业务层查询所有一级分类的方法的实现
	public List<Category> findAll() {
		return categoryDao.findAll();
	}

	public void save(Category category) {
		// TODO Auto-generated method stub
		categoryDao.save(category);
	}

	public Category findByCid(Integer cid) {
		// TODO Auto-generated method stub
		return categoryDao.findByCid(cid);
	}

	//删除一级分类
	public void delete(Category category) {
		// TODO Auto-generated method stub
		categoryDao.delete(category);
	}
	
	//修改一级分类
	public void update(Category category) {
		// TODO Auto-generated method stub
		categoryDao.update(category);
	}

}
