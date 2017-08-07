package mapper;

import org.apache.ibatis.annotations.Param;

import model.Board;

public interface BoardMapper {
	
	Board selectBoardById(Integer id);
	
	int updateBoard(@Param("boardId") int boardId, @Param("threadId") int threadId);
    
    int updateReplyCount(Integer id);
    
    /*以上为自己实现的方法，保留了下面可能用到的方法*/

    int deleteByPrimaryKey(Integer id);

    int insert(Board record);

    int insertSelective(Board record);

    Board selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Board record);

    int updateByPrimaryKey(Board record);
}