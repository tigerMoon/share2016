package me.yangbajing.share2016.web.config;

import me.yangbajing.share2016.common.exception.SBaseException;
import me.yangbajing.share2016.data.domain.ErrResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Yang Jing (yangbajing@gmail.com) on 2016-05-06.
 */
@ControllerAdvice(basePackages = "me.yangbajing.web.controller")
public class ExceptionControllerAdvice extends ResponseEntityExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(ExceptionControllerAdvice.class);

    @ExceptionHandler(SBaseException.class)
    @ResponseBody
    ResponseEntity<?> handlerControllerException(HttpServletRequest request, Throwable ex) {
        if (ex instanceof SBaseException) {
            logger.warn(ex.getMessage());
            SBaseException err = (SBaseException) ex;
            return new ResponseEntity<>(new ErrResponse(err.getErrcode(), err.getErrmsg()), HttpStatus.OK);
        } else {
            logger.error(ex.getMessage(), ex);
            return new ResponseEntity<>(new ErrResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage()),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
