package DAOImpl;

import java.util.Date;
import java.util.List;

import mapper.ThreadMapper;
import model.Thread;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import DAO.ThreadDAO;

@Repository
public class ThreadDAOImpl implements ThreadDAO{

	@Autowired
	private ThreadMapper threadMapper;

	@Override
	public int getCountByBoardId(int id) {
		return threadMapper.getCountByBoardId(id);
	}

	@Override
	public List<Thread> list(int id, RowBounds rowbounds) {
		return threadMapper.list(id, rowbounds);
	}

	@Override
	public Thread selectThreadContent(int id) {
		return threadMapper.selectThreadContent(id);
	}

	@Override
	public int save(Thread thread) {
		return threadMapper.insertSelective(thread);
	}

	@Override
	public int updateHit(int id) {
		return threadMapper.updateHit(id);
	}

	@Override
	public int selectCurrentThread(String title) {
		return threadMapper.selectCurrentThread(title);
	}

	@Override
	public Thread selectThreadById(int id) {
		return threadMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateThread(int id, int replyId, Date date) {
		return threadMapper.updateThread(id, replyId,date);
	}
	
}
