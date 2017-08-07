package Service;

import java.util.List;

import model.Board;
import model.Person;

public interface PersonService {
	
	public void save(Person person);
	
	public int insert(Person person);
	
	public Person selectById(int id);
	
	public List<Person> selectAll();
	
	public List<Board> selectBoardByPersonId(int id);

	public Person findPersonByAccount(String account);

	public Person getPerson(Person person);
	
	public int deleteByBoardId(int id);
	
	public int insertBoardAdministrator(int boardId, int personId);
}
