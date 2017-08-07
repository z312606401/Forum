package mapper;

import java.util.List;

import model.Category;

public interface CategoryMapper {

	List<Category> getList();

	Category selectByName(String name);

	List<Category> getAll();

	/*����Ϊ�Լ�ʵ�ֵķ�������������������õ��ķ���*/

	int deleteByPrimaryKey(Integer id);

	int insert(Category record);

	int insertSelective(Category record);

	Category selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(Category record);

	int updateByPrimaryKey(Category record);
}