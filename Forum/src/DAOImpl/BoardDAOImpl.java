package DAOImpl;

import mapper.BoardMapper;
import model.Board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import DAO.BoardDAO;

@Repository
public class BoardDAOImpl implements BoardDAO{

	@Autowired
	private BoardMapper boardMapper;

	@Override
	public Board selectBoardById(int id) {
		return boardMapper.selectBoardById(id);
	}

	@Override
	public int creat(Board board) {
		return boardMapper.insertSelective(board);
	}

	@Override
	public int updateBoard(int boardId, int threadId) {
		return boardMapper.updateBoard(boardId, threadId);
	}

	@Override
	public int updateReplyCount(int id) {
		return boardMapper.updateReplyCount(id);
	}
}
