package my.mvc.mappers;

import my.mvc.domain.PageRequestDTO;
import my.mvc.domain.ReplyDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ReplyMapper {

    // 댓글 Insert
    int insert(ReplyDTO replyDTO);

    // 대댓글 Insert
    int insertChild(ReplyDTO replyDTO);

    // SELECT LAST_INSERT_ID() 값을 얻고 gno 에 update => 대댓글
    int updateGno(Long rno);

    // 댓글 페이징
    // MyBatis Parameter 를 여러개 받을때 @Param
    List<ReplyDTO> selectList(@Param("tno") Long tno, @Param("pr") PageRequestDTO pageRequestDTO);
}
