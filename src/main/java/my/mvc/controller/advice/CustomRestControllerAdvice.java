package my.mvc.controller.advice;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@Log4j2
@RestControllerAdvice
public class CustomRestControllerAdvice {

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public void mistype(MethodArgumentTypeMismatchException ex) {
        
    }

}
