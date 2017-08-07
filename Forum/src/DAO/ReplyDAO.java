package DAO;

import java.util.List;

import model.Reply;

import org.apache.ibatis.session.RowBounds;

public interface ReplyDAO {
	
	public List<Reply> list(int id,RowBounds rowbounds);
	
	public int create(Reply reply);
	
	public int selectReplyCount(int id);

}
