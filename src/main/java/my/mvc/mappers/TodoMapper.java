package my.mvc.mappers;

import my.mvc.domain.PageRequestDTO;
import my.mvc.domain.TodoDTO;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface TodoMapper {

    // TodoMapper List
    List<TodoDTO> list(PageRequestDTO pageRequestDTO);

    // TodoMapper ListCount
    long listCount(PageRequestDTO pageRequestDTO);

    // TodoMapper Insert
    int insert(TodoDTO todoDTO);

    // TodoMapper Delete
    int delete(long tno);

    // TodoMapper read
    TodoDTO read(long tno);

}
