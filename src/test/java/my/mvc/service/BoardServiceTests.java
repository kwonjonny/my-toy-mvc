package my.mvc.service;

import lombok.extern.log4j.Log4j2;
import my.mvc.dto.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@Log4j2
@SpringBootTest
public class BoardServiceTests {

    @Autowired
    private BoardService boardService;

    private static final String TEST_TITLE = "JunitServiceTest";
    private static final String TEST_WRITER = "JunitServiceTest";
    private static final String TEST_CONTENT = "JunitServiceTest";
    private static final long TEST_TNO = 34209259L;

    private BoardCreateDTO boardCreateDTO;

    @BeforeEach
    public void setup() {
        boardCreateDTO = BoardCreateDTO.builder()
            .title(TEST_TITLE)
            .writer(TEST_WRITER)
            .content(TEST_CONTENT)
            .build();
    }

    // BoardService Create Test
    @Test
    @Transactional
    public void createBoardServiceTest() {
        log.info("======== Start Create Board Service ========");
        int insertCount = boardService.boardCreate(boardCreateDTO);
        assertEquals(1, insertCount, "Insert should be successful");
        log.info("======== End Create Board Service ========");
    }

    // BoardService List Test
    @Test
    public void listBoardServiceTest() {
        PageRequestDTO pageRequestDTO = PageRequestDTO.builder().build();
        PageResponseDTO<BoardDTO> list = boardService.boardList(pageRequestDTO);
        assertNotNull(list, "List should not be null");
        log.info(list);
    }

    // BoardService Read Test
    @Test
    @Transactional
    public void readBoardServiceTest() {
        log.info("======== Start Read Board Service ========");
        BoardDTO boardDTO = boardService.boardRead(TEST_TNO);
        assertNotNull(boardDTO, "BoardDTO should not be null");
        log.info(boardDTO);
        log.info("======== End Read Board Service ========");
    }

    // BoardService Delete Test
    @Test
    @Transactional
    public void deleteBoardServiceTest() {
        log.info("======== Start Delete Board Service ========");
        boardService.boardDelete(TEST_TNO);
        BoardDTO deletedBoard = boardService.boardRead(TEST_TNO);
        assertNull(deletedBoard, "Deleted Board should be null");
        log.info("======== End Delete Board Service ========");
    }

    // BoardService Update Test
    @Test
    @Transactional
    public void updateBoardServiceTest() {
        log.info("======== Start Update Board Service ========");
        BoardUpdateDTO boardUpdateDTO = BoardUpdateDTO.builder()
                .tno(TEST_TNO)
                .content(TEST_CONTENT)
                .writer(TEST_WRITER)
                .title(TEST_TITLE)
                .build();
        boardService.boardUpdate(boardUpdateDTO);
        BoardDTO updatedBoard = boardService.boardRead(TEST_TNO);
        assertNotNull(updatedBoard, "Updated Board should not be null");
        assertEquals(TEST_TITLE, updatedBoard.getTitle(), "Title should be updated");
        log.info("======== End Update Board Service ========");
    }
}
