package mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import model.Thread;

public interface ThreadMapper {
	
	int getCountByBoardId(Integer id);
	
	List<Thread> list(int id, RowBounds rowbounds);
	
	Thread selectThreadContent(Integer id);
	
    int updateHit(int id);
    
    int selectCurrentThread(String title);
    
    int updateThread(@Param("id") int id, @Param("replyId") int replyId, @Param("date") Date date);
    
    /*����Ϊ�Լ�ʵ�ֵķ�������������������õ��ķ���*/

    int insert(Thread record);

    int insertSelective(Thread record);

    Thread selectByPrimaryKey(Integer id);

}