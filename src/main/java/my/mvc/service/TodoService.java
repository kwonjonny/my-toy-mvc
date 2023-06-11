package my.mvc.service;

import my.mvc.domain.PageRequestDTO;
import my.mvc.domain.PageResponseDTO;
import my.mvc.domain.TodoDTO;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface TodoService {

    // List Service
    PageResponseDTO<TodoDTO> getList(PageRequestDTO pageRequestDTO);

    // read Service
    TodoDTO read(long tno);


}
