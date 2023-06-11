package my.mvc.mappers;

import my.mvc.domain.PageRequestDTO;
import my.mvc.domain.TodoDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TodoMapper {
    List<TodoDTO> list(PageRequestDTO pageRequestDTO);

    long listCount(PageRequestDTO pageRequestDTO);

    int insert(TodoDTO todoDTO);

    int delete(long tno);

    TodoDTO read(long tno);

}
