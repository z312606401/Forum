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
	
	//跳转到注册页面
	@RequestMapping("person_initAdd.do")
	public ModelAndView initAdd(HttpServletRequest request){
		request.setAttribute("title", "用户注册");
		request.setAttribute("person", new Person());
		return new ModelAndView("person/addPerson");
	}
	
	//注册
	@RequestMapping("person_add.do")
	public ModelAndView add(@ModelAttribute Person person, HttpServletRequest request, HttpServletResponse response){
		request.setAttribute("title", "用户注册");
		person.setIpcreated(request.getRemoteAddr());
		person.setIplastactived(request.getRemoteAddr());
		person.setDatecreated(new Date());
		person.setDatelastactived(new Date());
		person.setDeleted(false);
		if (person.getAccount() == null|| person.getAccount().trim().length() == 0) {
			request.setAttribute("message", "请输入帐号");
			return initAdd(request);
		}
		
		if (person.getPassword() == null|| person.getPassword().trim().length() == 0|| !person.getPassword().equals(request.getParameter("password1"))) {
			request.setAttribute("message", "密码不一致");
			return initAdd(request);
		}
		try {
			personService.insert(person);//保存到数据库，此时没有id
			PersonUtil.setPersonInf(request, response, personService.findPersonByAccount(person.getAccount()));
			request.setAttribute("message", "注册成功");
			return new ModelAndView("person/success");
		} catch (Exception e) {
			request.setAttribute("message", "注册失败，原因：" + e.getMessage());
			return initAdd(request);
		}
	}
	
	//跳转用户登录页面
	@RequestMapping("person_initLogin.do")
	public ModelAndView initLogin(HttpServletRequest request){
		request.setAttribute("person", new Person());
		request.setAttribute("title", "用户登录");
		return new ModelAndView("person/login");
	}
	
	//登录
	@RequestMapping("person_login.do")
	public ModelAndView login(@ModelAttribute Person person,HttpServletRequest request, HttpServletResponse response) throws Exception{
		request.setAttribute("title", "用户登录");
		Person person1=personService.getPerson(person);
		if (person1 == null)
			throw new AccountException("用户名密码错误");
		PersonUtil.setPersonInf(request, response, person1);
		person1.setIplastactived(request.getRemoteAddr());
		person1.setDatelastactived(new Date());
		personService.save(person1);
		request.setAttribute("message", "欢迎回来");
		return new ModelAndView("person/success");
	}
	
	//注销
	@RequestMapping("person_logout.do")
	public ModelAndView logout(HttpServletRequest request){
		request.setAttribute("title", "用户注销");
		request.getSession(true).setAttribute(PersonUtil.PERSON_INFO, null);
		request.setAttribute("person", new Person());
		return new ModelAndView("person/login");
	}
	
	//查看个人信息
	@RequestMapping("person_view.do")
	public ModelAndView view(HttpServletRequest request){
		request.setAttribute("title", "查看用户资料");
		int id=Integer.parseInt(request.getParameter("id"));
		Person person=personService.selectById(id);
		request.setAttribute("person", person);
		List<Board> boardList=personService.selectBoardByPersonId(id);
		request.setAttribute("boardList", boardList);
		return new ModelAndView("person/viewPerson");
	}
}
