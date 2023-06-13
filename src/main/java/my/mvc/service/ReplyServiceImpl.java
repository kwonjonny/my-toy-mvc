package my.mvc.service;

import my.mvc.domain.PageRequestDTO;
import my.mvc.domain.PageResponseDTO;
import my.mvc.domain.ReplyDTO;
import my.mvc.mappers.ReplyMapper;
import my.mvc.mappers.TodoMapper;
import org.springframework.stereotype.Service;

import java.util.List;

// ReplyServiceImpl
@Service
public class ReplyServiceImpl implements ReplyService {

    // ReplyMapper, TodoMapper 인스턴스 변수 정의
    private final ReplyMapper replyMapper;
    private final TodoMapper todoMapper;

    // ReplyMapper, TodoMapper 의존성 주입
    public ReplyServiceImpl(ReplyMapper replyMapper, TodoMapper todoMapper) {
        this.replyMapper = replyMapper;
        this.todoMapper = todoMapper;
    }

    // Register ServiceImpl
    @Override
    public Long register(ReplyDTO replyDTO) {
        Long result = null;
        Long gno = replyDTO.getGno();   // 0 일시 댓글 1 일시 대댓글
        // if로 비교해주어야한다
        if(gno == 0L) {
            int count = replyMapper.insert(replyDTO);
            if(count != 1) {
                throw new RuntimeException("Reply Insert Exception");
            }
            Long rno = replyDTO.getRno();
            replyMapper.updateGno(rno);
            result = rno;
        } else {
            int count = replyMapper.insertChild(replyDTO);
            if(count != 1) {
                throw new RuntimeException("Reply InsertChild Exception");
            }
        }
        return replyDTO.getRno();
    }

    // getList ServiceImpl
    // 특정한 tno 의 댓글이 몇갠지 세는 로직 필요
    @Override
    public PageResponseDTO<ReplyDTO> getList(Long tno, PageRequestDTO pageRequestDTO) {

        List<ReplyDTO> list = replyMapper.selectList(tno, pageRequestDTO);
        int total = replyMapper.getTnoCount(tno);

        return PageResponseDTO.<ReplyDTO>withAll()
                .list(list)
                .total(total)
                .build();
    }
}
