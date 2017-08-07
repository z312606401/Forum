package Service;

import java.util.Date;
import java.util.List;

import model.Thread;

import org.apache.ibatis.session.RowBounds;


public interface ThreadService {

	public int getCountByBoardId(int id);
	
	public List<Thread> list(int id,RowBounds rowbounds);
	
	public Thread selectThreadContent(int id);
	
	public int save(Thread thread);
	
	public int updateHit(int id);
	
	public int selectCurrentThread(String title);
	
	public Thread selectThreadById(int id);
	
	public int updateThread(int id,int replyId,Date date);
}
