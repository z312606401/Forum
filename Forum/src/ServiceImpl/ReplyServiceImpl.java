package ServiceImpl;

import java.util.List;

import model.Reply;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DAO.ReplyDAO;
import Service.ReplyService;

@Service
public class ReplyServiceImpl implements ReplyService{

	@Autowired
	private ReplyDAO replyDAO;
	
	@Override
	public List<Reply> list(int id, RowBounds rowbounds) {
		return replyDAO.list(id, rowbounds);
	}

	@Override
	public int create(Reply reply) {
		return replyDAO.create(reply);
	}

	@Override
	public int selectReplyCount(int id) {
		return replyDAO.selectReplyCount(id);
	}

}
