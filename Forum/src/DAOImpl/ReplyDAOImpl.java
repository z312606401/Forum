package DAOImpl;

import java.util.List;

import mapper.ReplyMapper;
import model.Reply;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import DAO.ReplyDAO;

@Repository
public class ReplyDAOImpl implements ReplyDAO{

	@Autowired
	private ReplyMapper replyMapper;
	
	@Override
	public List<Reply> list(int id, RowBounds rowbounds) {
		return replyMapper.list(id, rowbounds);
	}

	@Override
	public int create(Reply reply) {
		return replyMapper.insertSelective(reply);
	}

	@Override
	public int selectReplyCount(int id) {
		return replyMapper.selectReplyCount(id);
	}

}
