package my.mvc.service;

import my.mvc.domain.PageRequestDTO;
import my.mvc.domain.PageResponseDTO;
import my.mvc.domain.ReplyDTO;
import org.springframework.transaction.annotation.Transactional;

// ReplyService
@Transactional
public interface ReplyService {

    // Register Service
    // return type 이 Long 인 이유는 몇번 댓글인지 확인하기 위해
    Long register(ReplyDTO replyDTO);

    // getList Service
    // 특정한 tno 의 댓글이 몇갠지 세는 로직 필요
    PageResponseDTO<ReplyDTO> getList(Long tno, PageRequestDTO pageRequestDTO);

}
