package my.mvc.service;

import lombok.extern.log4j.Log4j2;
import my.mvc.domain.PageRequestDTO;
import my.mvc.domain.PageResponseDTO;
import my.mvc.domain.TodoDTO;
import my.mvc.mappers.TodoMapper;
import org.springframework.stereotype.Service;

import java.util.List;

// TodoServiceImpl
@Log4j2
@Service
public class TodoServiceImpl implements TodoService{

    // TodoMapper 인스턴스 변수 정의
    private final TodoMapper todoMapper;

    // TodoMapper 의존성 주입
    public TodoServiceImpl(TodoMapper todoMapper) {
        this.todoMapper = todoMapper;
    }

    // List ServiceImpl


    @Override
    public PageResponseDTO<TodoDTO> getList(PageRequestDTO pageRequestDTO) {
        List<TodoDTO> list = todoMapper.list(pageRequestDTO);
        long total = todoMapper.listCount(pageRequestDTO);

        return PageResponseDTO.<TodoDTO>withAll()
                .list(list)
                .total(total)
                .build();
    }

    // read ServiceImpl
    @Override
    public TodoDTO read(long tno) {
        return todoMapper.read(tno);
    }
}
