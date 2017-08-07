package mapper;

import org.apache.ibatis.annotations.Param;

import model.Board;

public interface BoardMapper {
	
	Board selectBoardById(Integer id);
	
	int updateBoard(@Param("boardId") int boardId, @Param("threadId") int threadId);
    
    int updateReplyCount(Integer id);
    
    /*����Ϊ�Լ�ʵ�ֵķ�������������������õ��ķ���*/

    int deleteByPrimaryKey(Integer id);

    int insert(Board record);

    int insertSelective(Board record);

    Board selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Board record);

    int updateByPrimaryKey(Board record);
}