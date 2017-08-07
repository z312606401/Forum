package Controller;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Board;
import model.Category;
import model.Person;
import model.Thread;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import util.Pagination;
import Service.BoardService;
import Service.CategoryService;
import Service.PersonService;
import Service.ThreadService;

@Controller
public class BoardController {

	@Autowired
	private BoardService boardService;
	@Autowired
	private ThreadService threadService;
	@Autowired
	private PersonService personService;
	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping("board_list.do")
	public ModelAndView list(HttpServletRequest request, HttpServletResponse response){
		Board board =boardService.selectBoardById(Integer.parseInt(request.getParameter("id")));
		request.setAttribute("title", "帖子列表 - 版面：" + board.getName());
		int totalCount=threadService.getCountByBoardId(board.getId());
		Pagination pagination = new Pagination(request, response);
		pagination.setRecordCount(totalCount);
		List<Thread> threadList = threadService.list(board.getId(),
				new RowBounds(pagination.getFirstResult(), pagination.getPageSize()));
		request.setAttribute("board", board);
		request.setAttribute("pagination", pagination);
		request.setAttribute("threadList", threadList);
		return new ModelAndView("thread/listThread");
	}
	
	@RequestMapping("board_initSetAdmin.do")
	public ModelAndView initSetAdmin(HttpServletRequest request){
		Board board =boardService.selectBoardById(Integer.parseInt(request.getParameter("id")));
		request.setAttribute("title", "设置管理员 - 版面：" + board.getName());
		List<Person> personList = personService.selectAll();
		int[] adminId = new int[board.getAdministrators().size()];
		int i = 0;
		for (Iterator<Person> it = board.getAdministrators().iterator(); it.hasNext(); i++) {
			Person p = it.next();
			adminId[i] = p.getId();
		}
		board.setAdminId(adminId);
		request.setAttribute("board", board);
		request.setAttribute("personList", personList);
		return new ModelAndView("board/setAdmin");
	}
	
	@RequestMapping("board_setAdmin.do")
	public ModelAndView setAdmin(@ModelAttribute Board board, HttpServletRequest request){
		int boardId=Integer.parseInt(request.getParameter("id"));
		Board board1 =boardService.selectBoardById(boardId);
		personService.deleteByBoardId(board1.getId());
		request.setAttribute("title", "设置管理员 - 版面：" + board1.getName());
		int[] adminId =board.getAdminId();
		for (int i = 0; adminId != null && i < adminId.length; i++)
			personService.insertBoardAdministrator(board1.getId(), adminId[i]);
		return new ModelAndView("board/success");
	}
	
	@RequestMapping("board_initAdd.do")
	public ModelAndView initAdd(HttpServletRequest request){
		request.setAttribute("title", "添加版面");
		List<Category> categoryList =categoryService.getAll();
		request.setAttribute("categoryList", categoryList);
		request.setAttribute("board", new Board());
		return new ModelAndView("board/addBoard");
	}
	
	@RequestMapping("board_add.do")
	public ModelAndView add(@ModelAttribute Board board, HttpServletRequest request){
		request.setAttribute("title", "添加版面");
		board.setDatecreated(new Date());
		board.setDeleted(false);
		board.setReplycount(0);
		board.setThreadcount(0);
		boardService.creat(board);
		return new ModelAndView("board/success");
	}
}
