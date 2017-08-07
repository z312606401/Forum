package mapper;

import java.util.List;

import model.Board;
import model.Person;

import org.apache.ibatis.annotations.Param;

public interface PersonMapper {

	Person getPerson(Person person);

	Person selectByAccount(String account);

	List<Board> selectBoardByPersonId(int id);

	List<Person> selectAll();

	int deleteByBoardId(Integer id);

	int insertBoardAdministrator(@Param("boardId") int boardId, @Param("personId") int personId);

	/*����Ϊ�Լ�ʵ�ֵķ�������������������õ��ķ���*/

	int deleteByPrimaryKey(Integer id);

	int insert(Person record);
	
	int insertSelective(Person record);

	Person selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(Person record);

	int updateByPrimaryKey(Person record);
}