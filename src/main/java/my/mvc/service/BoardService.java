package my.mvc.service;

import my.mvc.dto.*;

import java.util.List;

public interface BoardService {

    // BoardService Create Board
    int boardCreate(BoardCreateDTO boardCreateDTO);


    // BoardService List Board
    PageResponseDTO<BoardDTO> boardList(PageRequestDTO pageRequestDTO);


    // BoardService Read Board
    BoardDTO boardRead(Long tno);


    // BoardService Delete Board
    int boardDelete(Long tno);


    // BoardService Update Board
    int boardUpdate(BoardUpdateDTO boardUpdateDTO);
}
