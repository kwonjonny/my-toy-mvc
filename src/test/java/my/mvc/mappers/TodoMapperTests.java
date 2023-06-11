package my.mvc.mappers;

import lombok.extern.log4j.Log4j2;
import my.mvc.domain.PageRequestDTO;
import my.mvc.domain.TodoDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Log4j2
@SpringBootTest
public class TodoMapperTests {

    @Autowired
    private TodoMapper todoMapper;

    // List Test
    @Test
    @Commit
    @Transactional
    public void testList() {
        PageRequestDTO pageRequestDTO = PageRequestDTO.builder().build();

        List<TodoDTO> list = todoMapper.list(pageRequestDTO);

        list.forEach(todo -> log.info(todo));
    }

    // ListCount test
    @Test
    @Commit
    @Transactional
    public void testListCount() {
        PageRequestDTO pageRequestDTO = PageRequestDTO.builder().build();

        long totalCount = todoMapper.listCount(pageRequestDTO);

        log.info("==========================================");
        log.info("==========================================");
        log.info(totalCount);
        log.info("==========================================");
        log.info("==========================================");
    }

    // Create Test
    @Test
    @Commit
    @Transactional
    public void testInsert() {
        Assertions.assertNotNull(todoMapper, "Todo Mapper");

        TodoDTO todoDTO = TodoDTO.builder()
                .title("테스트 투두")
                .content("Test Content")
                .writer("user Kwon Seong Joon")
                .dueDate("2023-06-05")
                .build();
        int count = todoMapper.insert(todoDTO);

        Assertions.assertEquals(count , 1);

        log.info("==========================================");
        log.info("==========================================");
        log.info(todoDTO.getTno());
        log.info("==========================================");
        log.info("==========================================");
    }

    // Delete Test
    @Test
    @Commit
    @Transactional
    public void testDelete() {
       todoMapper.delete(1);
    }

    // Update Test
    @Test
    @Commit
    @Transactional
    public void testUpdate() {
        Assertions.assertNotNull(todoMapper, "Todo Mapper");

        TodoDTO todoDTO = TodoDTO.builder()
                .tno(3)
                .title("테스트 투두")
                .content("Test Content")
                .writer("user Kwon Seong Joon")
                .dueDate("2023-06-05")
                .build();

        int count = todoMapper.update(todoDTO);

        Assertions.assertEquals(count, 1);

        log.info("==========================================");
        log.info("==========================================");
        log.info(todoDTO.getTno());
        log.info("==========================================");
        log.info("==========================================");
    }


}
