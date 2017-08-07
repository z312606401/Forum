package Controller;

import java.util.Date;
import java.util.List;

import javax.security.auth.login.AccountException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Board;
import model.Person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import util.PersonUtil;
import Service.PersonService;

@Controller
public class PersonController {

	@Autowired
	private PersonService personService;
	
	//��ת��ע��ҳ��
	@RequestMapping("person_initAdd.do")
	public ModelAndView initAdd(HttpServletRequest request){
		request.setAttribute("title", "�û�ע��");
		request.setAttribute("person", new Person());
		return new ModelAndView("person/addPerson");
	}
	
	//ע��
	@RequestMapping("person_add.do")
	public ModelAndView add(@ModelAttribute Person person, HttpServletRequest request, HttpServletResponse response){
		request.setAttribute("title", "�û�ע��");
		person.setIpcreated(request.getRemoteAddr());
		person.setIplastactived(request.getRemoteAddr());
		person.setDatecreated(new Date());
		person.setDatelastactived(new Date());
		person.setDeleted(false);
		if (person.getAccount() == null|| person.getAccount().trim().length() == 0) {
			request.setAttribute("message", "�������ʺ�");
			return initAdd(request);
		}
		
		if (person.getPassword() == null|| person.getPassword().trim().length() == 0|| !person.getPassword().equals(request.getParameter("password1"))) {
			request.setAttribute("message", "���벻һ��");
			return initAdd(request);
		}
		try {
			personService.insert(person);//���浽���ݿ⣬��ʱû��id
			PersonUtil.setPersonInf(request, response, personService.findPersonByAccount(person.getAccount()));
			request.setAttribute("message", "ע��ɹ�");
			return new ModelAndView("person/success");
		} catch (Exception e) {
			request.setAttribute("message", "ע��ʧ�ܣ�ԭ��" + e.getMessage());
			return initAdd(request);
		}
	}
	
	//��ת�û���¼ҳ��
	@RequestMapping("person_initLogin.do")
	public ModelAndView initLogin(HttpServletRequest request){
		request.setAttribute("person", new Person());
		request.setAttribute("title", "�û���¼");
		return new ModelAndView("person/login");
	}
	
	//��¼
	@RequestMapping("person_login.do")
	public ModelAndView login(@ModelAttribute Person person,HttpServletRequest request, HttpServletResponse response) throws Exception{
		request.setAttribute("title", "�û���¼");
		Person person1=personService.getPerson(person);
		if (person1 == null)
			throw new AccountException("�û����������");
		PersonUtil.setPersonInf(request, response, person1);
		person1.setIplastactived(request.getRemoteAddr());
		person1.setDatelastactived(new Date());
		personService.save(person1);
		request.setAttribute("message", "��ӭ����");
		return new ModelAndView("person/success");
	}
	
	//ע��
	@RequestMapping("person_logout.do")
	public ModelAndView logout(HttpServletRequest request){
		request.setAttribute("title", "�û�ע��");
		request.getSession(true).setAttribute(PersonUtil.PERSON_INFO, null);
		request.setAttribute("person", new Person());
		return new ModelAndView("person/login");
	}
	
	//�鿴������Ϣ
	@RequestMapping("person_view.do")
	public ModelAndView view(HttpServletRequest request){
		request.setAttribute("title", "�鿴�û�����");
		int id=Integer.parseInt(request.getParameter("id"));
		Person person=personService.selectById(id);
		request.setAttribute("person", person);
		List<Board> boardList=personService.selectBoardByPersonId(id);
		request.setAttribute("boardList", boardList);
		return new ModelAndView("person/viewPerson");
	}
}
