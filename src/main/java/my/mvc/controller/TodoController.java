package my.mvc.controller;

import lombok.extern.log4j.Log4j2;

import my.mvc.domain.PageRequestDTO;
import my.mvc.domain.PageResponseDTO;
import my.mvc.domain.TodoDTO;
import my.mvc.service.TodoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

// Todo Controller
@Log4j2
@Controller
@RequestMapping("/todo/")
public class TodoController {

    // TodoService interface 인스턴스 변수 정의
    private final TodoService todoService;

    // TodoService 의존성 주입
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    // get : List
    @GetMapping("list")
    public void list(PageRequestDTO pageRequestDTO, Model model) {
        PageResponseDTO<TodoDTO>pageResponseDTO = todoService.getList(pageRequestDTO);
        model.addAttribute("pageResponseDTO", pageResponseDTO);
    }

}
