package Controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Reply;
import model.Thread;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import util.PersonInfo;
import util.PersonUtil;
import Service.BoardService;
import Service.ReplyService;
import Service.ThreadService;

@Controller
public class ReplyController {

	@Autowired
	private ReplyService replyService;
	@Autowired
	private ThreadService threadService;
	@Autowired
	private BoardService boardService;
	
	@RequestMapping("reply_initAdd.do")
	public ModelAndView initAdd(HttpServletRequest request){
		Thread thread = threadService.selectThreadContent(Integer.parseInt(request.getParameter("id")));
		Reply reply=new Reply();
		reply.setTitle("Re:"+thread.getTitle());
		reply.setThreadId(thread.getId());
		request.setAttribute("title", "回复帖子 - 标题：" + thread.getTitle());
		request.setAttribute("thread", thread);
		request.setAttribute("reply", reply);
		return new ModelAndView("reply/addReply");
	}
	
	@RequestMapping("reply_add.do")
	public ModelAndView add(@ModelAttribute Reply reply, HttpServletRequest request, HttpServletResponse response){
		Thread thread=threadService.selectThreadById(reply.getThreadId());
		PersonInfo personInfo = PersonUtil.getPersonInfo(request, response);
		reply.setAuthorId(personInfo.getId());
		reply.setDatecreated(new Date());
		reply.setDeleted(false);
		reply.setFloor(replyService.selectReplyCount(thread.getId())+1);
		replyService.create(reply);
		threadService.updateThread(thread.getId(),personInfo.getId(),new Date());//更新帖子最后回复时间、回复人、回复数
		boardService.updateReplyCount(thread.getBoardId());//更新版面回复数
		request.setAttribute("thread", thread);
		request.setAttribute("title", "回复帖子 - 标题：" + thread.getTitle());
		return new ModelAndView("reply/success");
	}
}
