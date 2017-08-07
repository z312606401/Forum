package mapper;

import java.util.List;
import org.apache.ibatis.session.RowBounds;
import model.Reply;

public interface ReplyMapper {
	
	List<Reply> list(Integer id, RowBounds rowbounds);
	
	int selectReplyCount(Integer id);
	
	/*以上为自己实现的方法，保留了下面可能用到的方法*/

    int insert(Reply record);

    int insertSelective(Reply record);

    Reply selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Reply record);

    int updateByPrimaryKey(Reply record);
}