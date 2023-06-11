package my.mvc.service;

import my.mvc.domain.PageRequestDTO;
import my.mvc.domain.PageResponseDTO;
import my.mvc.domain.TodoDTO;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface TodoService {

    PageResponseDTO<TodoDTO> getList(PageRequestDTO pageRequestDTO);
}
