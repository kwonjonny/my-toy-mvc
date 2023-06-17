package my.mvc.controller;

import lombok.extern.log4j.Log4j2;
import my.mvc.dto.*;
import my.mvc.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Log4j2
@Controller
@RequestMapping("/board/")
public class BoardController {

    // 의존성 주입
    private final BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    // GET : list
    @GetMapping("list")
    public String getBoardList(PageRequestDTO pageRequestDTO, Model model) {
        log.info("GET : BoardList");
        PageResponseDTO<BoardDTO> pageResponseDTO = boardService.boardList(pageRequestDTO);
        model.addAttribute("pageResponseDTO", pageResponseDTO);
        return "board/list";
    }

    // GET : create
    @GetMapping("create")
    public String getBoardCreate() {
        log.info("GET : BoardCreate");
        return  "board/create";
    }

    // GET : read
    @GetMapping("read/{tno}")
    public String getBoardRead(@PathVariable("tno") long tno, Model model) {
        log.info("GET : BoardRead");
        BoardDTO boardDTO = boardService.boardRead(tno);
        model.addAttribute("boardDTO", boardDTO);
        return "board/read";
    }

    // GET : update
    @GetMapping("update/{tno}")
    public String getBoardUpdate(@PathVariable("tno") long tno , Model model) {
        log.info("GET : BoardUpdate");
        BoardDTO boardDTO = boardService.boardRead(tno);
        model.addAttribute("boardDTO", boardDTO);
        return "board/update";
    }

    // Post : create
    @PostMapping("create")
    public String postBoardCreate(BoardCreateDTO boardCreateDTO) {
        log.info("POST : BoardCreate");
        boardService.boardCreate(boardCreateDTO);
        return "redirect:/board/list";
    }

    // Post : delete
    @PostMapping("delete/{tno}")
    public String postBoardDelete(@PathVariable("tno") long tno) {
        log.info("POST : BoardDelete");
        boardService.boardDelete(tno);
        return "redirect:/board/list";
    }

    // Post : update
    @PostMapping("update")
    public String postBoardUpdate(BoardUpdateDTO boardUpdateDTO) {
        log.info("POST : BoardUpdate");
        boardService.boardUpdate(boardUpdateDTO);
        return "redirect:/board/read";
    }
}
