package mapper;

import java.util.List;

import model.Category;

public interface CategoryMapper {

	List<Category> getList();

	Category selectByName(String name);

	List<Category> getAll();

	/*以上为自己实现的方法，保留了下面可能用到的方法*/

	int deleteByPrimaryKey(Integer id);

	int insert(Category record);

	int insertSelective(Category record);

	Category selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(Category record);

	int updateByPrimaryKey(Category record);
}