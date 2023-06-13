package my.mvc.controller;

import lombok.extern.log4j.Log4j2;
import my.mvc.domain.PageRequestDTO;
import my.mvc.domain.PageResponseDTO;
import my.mvc.domain.ReplyDTO;
import my.mvc.service.ReplyService;
import org.springframework.web.bind.annotation.*;

@Log4j2
@RestController
@RequestMapping("/replies/")
public class ReplyController {

    // ReplyService interface 인스턴스 변수 정의
    private final ReplyService replyService;

    // ReplyService interface 의존성 주입
    public ReplyController(ReplyService replyService) {
        this.replyService = replyService;
    }

    @GetMapping(value = "{tno}/list")
    public PageResponseDTO<ReplyDTO> getReplyList(@PathVariable("tno") Long tno, PageRequestDTO pageRequestDTO) {
        return replyService.getList(tno, pageRequestDTO);
    }
}
