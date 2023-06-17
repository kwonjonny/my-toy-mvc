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

    private static final String TEST_TITLE = "TestTitle";
    private static final String TEST_WRITER = "TestWriter";
    private static final String TEST_CONTENT = "TestContent";
    private static final Long TEST_TNO = 34209267L;

    // 의존성 주입
    @Autowired
    private BoardMapper boardMapper;

    // Test for creating a board
    @Test
    @Transactional
    public void shouldCreateBoardMapper() {
        log.info("======== Start Create Board ========");
        BoardCreateDTO boardCreateDTO = BoardCreateDTO.builder()
                .title(TEST_TITLE)
                .writer(TEST_WRITER)
                .content(TEST_CONTENT)
                .build();
        int insertCount = boardMapper.boardCreate(boardCreateDTO);
        Assertions.assertEquals(1, insertCount, "Board should be created successfully");
        log.info("======== End Create Board ========");
    }

    // Test for listing boards
    @Test
    @Transactional
    public void shouldListBoardMapper() {
        log.info("======== Start List Board ========");
        PageRequestDTO pageRequestDTO = PageRequestDTO.builder().build();
        log.info(boardMapper.boardList(pageRequestDTO));
        log.info("======== End List Board ========");
    }

    // Test for reading a board
    @Test
    @Transactional
    public void shouldReadBoardMapper() {
        log.info("======== Start Read Board ========");
        BoardDTO boardDTO = boardMapper.boardRead(TEST_TNO);
        Assertions.assertNotNull(boardDTO, "Board should not be null");
        log.info(boardDTO);
        log.info("======== End Read Board ========");
    }

    // Test for deleting a board
    @Test
    @Transactional
    public void shouldDeleteBoardMapper() {
        log.info("======== Start Delete Board ========");
        boardMapper.boardDelete(TEST_TNO);
        log.info("======== End Delete Board ========");
    }

    // Test for updating a board
    @Test
    @Transactional
    public void shouldUpdateBoardMapper() {
        log.info("======== Start Update Board ========");
        BoardUpdateDTO boardUpdateDTO = BoardUpdateDTO.builder()
                .tno(TEST_TNO)
                .title(TEST_TITLE)
                .writer(TEST_WRITER)
                .content(TEST_CONTENT)
                .build();
        boardMapper.boardUpdate(boardUpdateDTO);
        BoardDTO updatedBoard = boardMapper.boardRead(TEST_TNO);
        Assertions.assertNotNull(updatedBoard, "Updated Board should not be null");
        log.info(updatedBoard);
        log.info("======== End Update Board ========");
    }
    
    // Test for total count 
    @Transactional
    public void shouldGetTotalCountOfBoardMapper() {
        log.info("======== Start Total Count of Boards ========");
        PageRequestDTO pageRequestDTO = PageRequestDTO.builder().build();
        int totalCount = boardMapper.total(pageRequestDTO);
        Assertions.assertTrue(totalCount >= 0, "Total count should be non-negative");
        log.info(totalCount);
        log.info("======== End Total Count of Boards ========");
    }
}
