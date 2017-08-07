package ServiceImpl;

import java.util.List;

import model.Category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DAO.CategoryDAO;
import Service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	private CategoryDAO categoryDAO;

	@Override
	public List<Category> getList() {
		return categoryDAO.getList();
	}

	@Override
	public int create(Category category) {
		if(categoryDAO.selectByName(category.getName())!=null)
			throw new RuntimeException("类别 " + category.getName() + " 已经存在。");
		return categoryDAO.create(category);
	}

	@Override
	public List<Category> getAll() {
		return categoryDAO.getAll();
	}
}
