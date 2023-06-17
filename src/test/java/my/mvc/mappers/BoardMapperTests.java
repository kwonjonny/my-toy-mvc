package my.mvc.mappers;

import lombok.extern.log4j.Log4j2;
import my.mvc.dto.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

@Log4j2
@SpringBootTest
public class BoardMapperTests {

    // 의존성 주입
    @Autowired
    private BoardMapper boardMapper;

    // BoardMapper Create Test
    @Test
    @Commit
    @Transactional
    public void createBoardTest() {
        log.info("======== Start Create Board ========");
        BoardCreateDTO boardCreateDTO = BoardCreateDTO.builder()
                .title("권성준JunitMapperTest")
                .writer("권성준JunitMapperTest")
                .content("권성준JunitMapperTest")
                .build();
        int insertCount = boardMapper.boardCreate(boardCreateDTO);
        Assertions.assertEquals(insertCount, 1);
        log.info("======== End Create Board ========");
    }

    // BoardMapper List Test
    @Test
    @Commit
    @Transactional
    public void ListBoardTest() {
        log.info("======== Start List Board ========");
        PageRequestDTO pageRequestDTO = PageRequestDTO.builder().build();
        log.info(boardMapper.boardList(pageRequestDTO));
        log.info("======== End List Board ========");
    }

    // BoardMapper Read Test
    @Test
    @Commit
    @Transactional
    public void readBoardTest() {
        log.info("======== Start Read Board ========");
        BoardDTO boardDTO = boardMapper.boardRead(34209256L);
        log.info(boardDTO);
        log.info("======== End Read Board ========");
    }

    // BoardMapper Delete Test
    @Test
    @Commit
    @Transactional
    public void deleteBoardTest() {
        log.info("======== Start Delete Board ========");
        boardMapper.boardDelete(34209256L);
        log.info("======== End Delete Board ========");
    }

    // BoardMapper Update Test
    @Test
    @Commit
    @Transactional
    public void updateBoardTest() {
        log.info("======== Start Update Board ========");
        BoardUpdateDTO boardUpdateDTO = BoardUpdateDTO.builder()
                .tno(34209257L)
                .title("권성준JunitMapperUpdateTest")
                .writer("권성준JunitMapperUpdateTest")
                .content("권성준JunitMapperUpdateTest")
                .build();
        boardMapper.boardUpdate(boardUpdateDTO);
        log.info(boardMapper.boardRead(34209257L));
        log.info("======== End Update Board ========");
    }

    // BoardMapper Total Test
    @Test
    @Commit
    @Transactional
    public void totalBoardTest() {
        log.info("======== Start total Board ========");
        PageRequestDTO pageRequestDTO = PageRequestDTO.builder().build();
        int totalCount = boardMapper.total(pageRequestDTO);

        log.info(totalCount);
        log.info("======== End total Board ========");
    }
}
