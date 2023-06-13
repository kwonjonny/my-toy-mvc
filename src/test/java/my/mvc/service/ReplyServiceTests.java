package my.mvc.service;

import lombok.extern.log4j.Log4j2;
import my.mvc.domain.PageRequestDTO;
import my.mvc.domain.ReplyDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

// ReplyServiceTest
@Log4j2
@SpringBootTest
public class ReplyServiceTests {

    // ReplyService 의존성 주입
    @Autowired
    private ReplyService replyService;

    // 댓글 Insert Test
    @Test
    @Commit
    @Transactional
    public void testRegister() {
        // GIVEN
        ReplyDTO replyDTO = ReplyDTO.builder()
                .tno(100L)
                .reply("댓글 테스트")
                .replyer("replyer0707")
                .build();

        // WHEN
        log.info(replyService.register(replyDTO));
    }

    // 대댓글 Insert Test
    @Test
    @Commit
    @Transactional
    public void testRegisterChild() {
        // GIVEN
        ReplyDTO replyDTO = ReplyDTO.builder()
                .tno(100L)
                .gno(11L)
                .reply("댓글 테스트")
                .replyer("replyer0707")
                .build();
        // WHEN
        log.info(replyService.register(replyDTO));
    }

    // 댓글 List Test
    @Test
    public void testList() {
        // GIVEN
        log.info(replyService.getList(100L, PageRequestDTO.builder().build()));
    }

}
