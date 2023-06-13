package my.mvc.mappers;

import lombok.extern.log4j.Log4j2;
import my.mvc.domain.PageRequestDTO;
import my.mvc.domain.ReplyDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

// 댓글과 대댓글
// CRUD 를 확인하기 위한 Test class
@Log4j2
@SpringBootTest
public class ReplyMapperTests {

    // ReplyMapper 댓글 interface 의존성 주입
    @Autowired(required = false)
    private ReplyMapper replyMapper;

    // 댓글 Insert Test
    @Test
    @Commit
    @Transactional
    public void testInsert() {
        // GIVEN
        ReplyDTO replyDTO = ReplyDTO.builder()
                .tno(100L)
                .reply("댓글 테스트")
                .replyer("replyer00")
                .build();

        // WHEN
        int insertCount = replyMapper.insert(replyDTO);

        // THEN
        Assertions.assertEquals(insertCount, 1);
        // 예외 처리
        if(insertCount != 1) {
            throw new RuntimeException("Error Run Time Insert");
        }
        // LAST_INSERT_ID() 의
        // updateGno 업데이트를 위한 로직
        Long rno = replyDTO.getRno();
        log.info("RNO : " + rno);
        replyMapper.updateGno(rno);
    }

    // 대댓글 Insert Test
    @Test
    @Commit
    @Transactional
    public void testInsertChild() {
        // GIVEN
        ReplyDTO replyDTO = ReplyDTO.builder()
                .tno(100L)
                .reply("대댓글 테스트입니다")
                .replyer("user0101")
                .gno(9L)
                .build();
        // WHEN
        replyMapper.insertChild(replyDTO);
    }

    // SelectList 댓글 페이징 & List Test
    @Test
    @Commit
    @Transactional
    public void testSelectList() {
        // GIVEN
        PageRequestDTO pageRequestDTO = PageRequestDTO.builder().build(); // 1 과 10 을 가지고 있다
        // 테스트를 위한 게시물의 번호를 임시 지정
        Long tno = 100L;

        // WHEN
        replyMapper.selectList(tno , pageRequestDTO)
        // THEN
                .forEach(dto -> log.info(dto));
    }
}
