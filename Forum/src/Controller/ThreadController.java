package Controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Board;
import model.Reply;
import model.Thread;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import util.Pagination;
import util.PersonInfo;
import util.PersonUtil;
import Service.BoardService;
import Service.ReplyService;
import Service.ThreadService;

@Controller
public class ThreadController {

	@Autowired
	private ThreadService threadService;
	
	@Autowired
	private ReplyService replyService;
	
	@Autowired
	private BoardService boardService;
	
	@RequestMapping("thread_list.do")
	public ModelAndView list( HttpServletRequest request, HttpServletResponse response){
		return view(request,response);
	}
	
	@RequestMapping("thread_view.do")
	public ModelAndView view(HttpServletRequest request, HttpServletResponse response){
		Thread thread =threadService.selectThreadContent(Integer.parseInt(request.getParameter("id")));
		Pagination pagination = new Pagination(request, response);
		pagination.setRecordCount(thread.getReplycount());
		List<Reply> replyList = replyService.list(thread.getId(), new RowBounds(pagination.getFirstResult(), pagination.getPageSize()));
		threadService.updateHit(thread.getId());
		request.setAttribute("thread", thread);
		request.setAttribute("pagination", pagination);
		request.setAttribute("replyList", replyList);
		request.setAttribute("title", "浏览帖子 - 标题：" + thread.getTitle());
		return new ModelAndView("thread/viewThread");
	}
	
	@RequestMapping("thread_initAdd.do")
	public ModelAndView initAdd(HttpServletRequest request){
		Board board =boardService.selectBoardById(Integer.parseInt(request.getParameter("id")));
		Thread thread=new Thread();
		thread.setBoardId(board.getId());
		request.setAttribute("board", board);
		request.setAttribute("title", "发表帖子 - 版面：" + board.getName());
		request.setAttribute("thread", thread);
		return new ModelAndView("thread/addThread");
	}
	
	@RequestMapping("thread_add.do")
	public String add(@ModelAttribute Thread thread, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		PersonInfo personInfo = PersonUtil.getPersonInfo(request, response);
		thread.setAuthorId(personInfo.getId());
		thread.setAuthorLastReplied(null);
		thread.setDatecreated(new Date());
		thread.setDatelastreplied(new Date());
		thread.setDeleted(false);
		thread.setIpcreated(request.getRemoteAddr());
		thread.setReadonly(false);
		thread.setReplycount(0);
		thread.setTopped(false);
		thread.setHit(0);
		threadService.save(thread);
		boardService.updateBoard(thread.getBoardId(), threadService.selectCurrentThread(thread.getTitle()));
		return "forward:board_list.do?id="+thread.getBoardId();
	}
}
