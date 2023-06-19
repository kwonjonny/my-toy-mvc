package my.mvc.service;

import my.mvc.dto.*;
import my.mvc.mappers.BoardMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardServiceImpl implements BoardService {

    // 의존성 주입
    private final BoardMapper boardMapper;

    @Autowired
    public BoardServiceImpl(BoardMapper boardMapper) {
        this.boardMapper = boardMapper;
    }

    
    // BoardServiceImpl Create Board
    @Override
    public int boardCreate(BoardCreateDTO boardCreateDTO) {
        return boardMapper.boardCreate(boardCreateDTO);
    }


    // BoardServiceImpl List Board
    @Override
    public PageResponseDTO<BoardDTO> boardList(PageRequestDTO pageRequestDTO) {
        List<BoardDTO> list = boardMapper.boardList(pageRequestDTO);
        int total = boardMapper.total(pageRequestDTO);
        return PageResponseDTO.<BoardDTO>withAll()
                .list(list)
                .total(total)
                .build();
    }


    // BoardServiceImpl Read Board
    @Override
    public BoardDTO boardRead(Long tno) {
        return boardMapper.boardRead(tno);
    }


    // BoardServiceImpl Delete Board
    @Override
    public int boardDelete(Long tno) {
        return boardMapper.boardDelete(tno);
    }


    // BoardServiceImpl Update Board
    @Override
    public int boardUpdate(BoardUpdateDTO boardUpdateDTO) {
        return boardMapper.boardUpdate(boardUpdateDTO);
    }
}
