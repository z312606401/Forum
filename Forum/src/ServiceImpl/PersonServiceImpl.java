package ServiceImpl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import util.MD5Util;
import model.Board;
import model.Person;
import DAO.PersonDAO;
import Service.PersonService;

@Service
public class PersonServiceImpl implements PersonService{

	@Autowired
	private PersonDAO personDAO;

	@Override
	public Person findPersonByAccount(String account) {
		return personDAO.findPersonByAccount(account);
	}

	@Override
	public Person getPerson(Person person) {
		Person newper=new Person();
		newper.setAccount(person.getAccount());
		newper.setPassword(MD5Util.calc(person.getPassword()));
		return personDAO.getPerson(newper);
	}

	@Override
	public void save(Person person) {
		personDAO.save(person);
	}

	@Override
	public int insert(Person person) {
		if(findPersonByAccount(person.getAccount())!=null)
			throw new RuntimeException("’ ∫≈ " + person.getAccount() + " “—æ≠¥Ê‘⁄°£");
		person.setPassword(MD5Util.calc(person.getPassword()));
		return personDAO.insert(person);
	}

	@Override
	public Person selectById(int id) {
		return personDAO.selectById(id);
	}

	@Override
	public List<Board> selectBoardByPersonId(int id) {
		return personDAO.selectBoardByPersonId(id);
	}

	@Override
	public List<Person> selectAll() {
		return personDAO.selectAll();
	}

	@Override
	public int deleteByBoardId(int id) {
		return personDAO.deleteByBoardId(id);
	}

	@Override
	public int insertBoardAdministrator(int boardId, int personId) {
		return personDAO.insertBoardAdministrator(boardId, personId);
	} 

}
