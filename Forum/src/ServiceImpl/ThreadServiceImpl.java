package ServiceImpl;

import java.util.Date;
import java.util.List;

import model.Thread;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DAO.BoardDAO;
import DAO.ThreadDAO;
import Service.ThreadService;

@Service
public class ThreadServiceImpl implements ThreadService{

	@Autowired
	private ThreadDAO threadDAO;

	@Override
	public int getCountByBoardId(int id) {
		return threadDAO.getCountByBoardId(id);
	}


	@Override
	public List<Thread> list(int id, RowBounds rowbounds) {
		return threadDAO.list(id, rowbounds);
	}


	@Override
	public Thread selectThreadContent(int id) {
		return threadDAO.selectThreadContent(id);
	}


	@Override
	public int save(Thread thread) {
		return threadDAO.save(thread);
	}


	@Override
	public int updateHit(int id) {
		return threadDAO.updateHit(id);
	}


	@Override
	public int selectCurrentThread(String title) {
		return threadDAO.selectCurrentThread(title);
	}


	@Override
	public Thread selectThreadById(int id) {
		return threadDAO.selectThreadById(id);
	}


	@Override
	public int updateThread(int id, int replyId, Date date) {
		return threadDAO.updateThread(id, replyId,date);
	}
}
