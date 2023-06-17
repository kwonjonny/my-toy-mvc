package my.mvc.mappers;

import my.mvc.dto.BoardCreateDTO;
import my.mvc.dto.BoardDTO;
import my.mvc.dto.BoardUpdateDTO;
import my.mvc.dto.PageRequestDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {

    // BoardMapper Create Board
    int boardCreate(BoardCreateDTO boardCreateDTO);


    // BoardMapper List Board
    List<BoardDTO> boardList(PageRequestDTO pageRequestDTO);


    // BoardMapper Read Board
    BoardDTO boardRead(Long tno);


    // BoardMapper Delete Board
    int boardDelete(Long tno);


    // BoardMapper Update Board
    int boardUpdate(BoardUpdateDTO boardUpdateDTO);


    // BoardMapper Total Count
    int total(PageRequestDTO pageRequestDTO);
}
