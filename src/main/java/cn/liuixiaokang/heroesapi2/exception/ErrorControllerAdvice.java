package cn.liuixiaokang.heroesapi2.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice(basePackages = {"cn.liuixiaokang.heroesapi2.controller"})
@Slf4j
public class ErrorControllerAdvice {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorMessage> handlerException(Exception e) {

        log.error(e.getMessage(), e);

        if (e instanceof DuplicateKeyException) {
            return handleMessage("40001", e.getMessage());
        }

        if (e instanceof DataIntegrityViolationException) {
            return handleMessage("40002", e.getMessage());
        }

        if (e instanceof DataAccessException) {
            return handleMessage("40003", e.getMessage());
        }

        return handleMessage("40000", e.getMessage());

    }

    private ResponseEntity<ErrorMessage> handleMessage(String code, String message) {
        return ResponseEntity.badRequest().body(new ErrorMessage(code, message));
    }


}
