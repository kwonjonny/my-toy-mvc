package my.mvc.controller.advice;

import lombok.extern.log4j.Log4j2;
import my.mvc.controller.ReplyController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import java.util.Map;

@Log4j2
@RestControllerAdvice
public class CustomRestControllerAdvice {


    // TypeMissMatch
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)    // Exception 종류 등록
    @ResponseStatus(HttpStatus.BAD_REQUEST)                         // 상태 코드 지정
    public Map<String, String> mistype(MethodArgumentTypeMismatchException ex) {
        log.info("MethodArgumentTypeMismatchException");
        return Map.of("error", "전달하는 데이터 타입이 안맞습니다");
    }

    // DataNotFound
    @ExceptionHandler(ReplyController.DataNotFoundException.class)  // Exception 종류 등록
    @ResponseStatus(HttpStatus.NOT_FOUND)           // 상태 코드 지정
    public Map<String, String> dataNotFound(ReplyController.DataNotFoundException ex) {
        log.info("DataNotFoundException");
        return Map.of("error", ex.getMessage());
    }
}
