package DAO;

import java.util.List;

import model.Category;

public interface CategoryDAO {

	public List<Category> getList();
	
	public int create(Category category);
	
	public Category selectByName(String name);
	
	public List<Category> getAll();
}
