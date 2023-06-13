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

// CRUD 를 확인하기 위한 Test class
@Log4j2
@SpringBootTest
public class TodoMapperTests {

    // TodoMapper Crud 확인을 위한 interface 의존성 주입
    @Autowired
    private TodoMapper todoMapper;

    // List Test
    @Test
    @Commit
    @Transactional
    public void testList() {
        // GIVEN
        PageRequestDTO pageRequestDTO = PageRequestDTO.builder().build();

        // WHEN
        List<TodoDTO> list = todoMapper.list(pageRequestDTO);

        // THEN
        list.forEach(todo -> log.info(todo));
    }

    // ListCount test
    @Test
    @Commit
    @Transactional
    public void testListCount() {
        // GIVEN
        PageRequestDTO pageRequestDTO = PageRequestDTO.builder().build();

        // WHEN
        long totalCount = todoMapper.listCount(pageRequestDTO);

        // THEN
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

        // GIVEN
        TodoDTO todoDTO = TodoDTO.builder()
                .title("테스트 투두")
                .content("Test Content")
                .writer("user Kwon Seong Joon")
                .dueDate("2023-06-05")
                .build();
        // WHEN
        int count = todoMapper.insert(todoDTO);

        // THEN
        Assertions.assertEquals(count , 1);
        log.info("==========================================");
        log.info("==========================================");
        log.info(todoDTO.getTno());
        log.info("==========================================");
        log.info("==========================================");
    }

    // read Test
    @Test
    @Commit
    @Transactional
    public void testRead() {

        // WHEN
        TodoDTO todo = todoMapper.read(11231L);

        // THEN
        log.info("==========================================");
        log.info("==========================================");
        todo.getTno();
        todo.getTitle();
        todo.getContent();
        todo.getWriter();
        todo.getDueDate();
        log.info("==========================================");
        log.info("==========================================");
    }


    // Delete Test
    @Test
    @Commit
    @Transactional
    public void testDelete() {
        // THEN
        todoMapper.delete(1);
    }
}
