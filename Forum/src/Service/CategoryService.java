package Service;

import java.util.List;

import model.Category;

public interface CategoryService {

	public List<Category> getList();
	
	public int create(Category category);
	
	public List<Category> getAll();
}
