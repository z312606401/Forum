package DAOImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import mapper.PersonMapper;
import model.Board;
import model.Person;
import DAO.PersonDAO;

@Repository
public class PersonDAOImpl implements PersonDAO{

	@Autowired
	private PersonMapper personMapper;

	@Override
	public Person findPersonByAccount(String account) {
		return personMapper.selectByAccount(account);
	}

	@Override
	public Person getPerson(Person person) {
		return personMapper.getPerson(person);
	}

	@Override
	public void save(Person person) {
		personMapper.updateByPrimaryKeySelective(person);
	}

	@Override
	public int insert(Person person) {
		return personMapper.insertSelective(person);
	}

	@Override
	public Person selectById(int id) {
		return personMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<Board> selectBoardByPersonId(int id) {
		return personMapper.selectBoardByPersonId(id);
	}

	@Override
	public List<Person> selectAll() {
		return personMapper.selectAll();
	}

	@Override
	public int deleteByBoardId(int id) {
		return personMapper.deleteByBoardId(id);
	}

	@Override
	public int insertBoardAdministrator(int boardId, int personId) {
		return personMapper.insertBoardAdministrator(boardId, personId);
	}
}
