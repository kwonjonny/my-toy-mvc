package my.mvc.service;

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
public class BoardServiceTests {

    @Autowired
    private BoardService boardService;

    // BoardService Create Test
    @Test
    @Commit
    @Transactional
    public void createBoardServiceTest() {
        log.info("======== Start Create Board Service ========");
        BoardCreateDTO boardCreateDTO = BoardCreateDTO.builder()
                .title("권성준JunitServiceTest")
                .writer("권성준JunitServiceTest")
                .content("권성준JunitServiceTest")
                .build();
        int insertCount = boardService.boardCreate(boardCreateDTO);
        Assertions.assertEquals(insertCount , 1);
        log.info("======== End Create Board Service ========");
    }

    // BoardService List Test
    @Test
    @Commit
    @Transactional
    public void listBoardServiceTest() {
        PageRequestDTO pageRequestDTO = PageRequestDTO.builder().build();
        PageResponseDTO<BoardDTO> list = boardService.boardList(pageRequestDTO);
        log.info(list);
    }

    // BoardService Read Test
    @Test
    @Commit
    @Transactional
    public void readBoardServiceTest() {
        log.info("======== Start Read Board Service ========");
        BoardDTO boardDTO = boardService.boardRead(34209258L);
        log.info(boardDTO);
        log.info("======== End Read Board Service ========");
    }

    // BoardService Delete Test
    @Test
    @Commit
    @Transactional
    public void deleteBoardServiceTest() {
        log.info("======== Start Delete Board Service ========");
        boardService.boardDelete(34209258L);
        log.info("======== End Delete Board Service ========");
    }

    // BoardService Update Test
    @Test
    @Commit
    @Transactional
    public void updateBoardServiceTest() {
        log.info("======== Start Update Board Service ========");
        BoardUpdateDTO boardUpdateDTO = BoardUpdateDTO.builder()
                .tno(34209259L)
                .content("권성준JunitServiceUpdateTest")
                .writer("권성준JunitServiceUpdateTest")
                .title("권성준JunitServiceUpdateTest")
                .build();
        boardService.boardUpdate(boardUpdateDTO);
        log.info(boardService.boardRead(34209259L));
        log.info("======== End Update Board Service ========");
    }
}
