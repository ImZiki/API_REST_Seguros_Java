package com.es.segurosinseguros.exception;


import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.sql.SQLException;

@ControllerAdvice
public class APIExceptionHandler {

    @ExceptionHandler({BadRequestException.class, IllegalArgumentException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorMessageForClient BadRequestHandler(HttpServletRequest request, Exception e){
        return new ErrorMessageForClient(e.getMessage(), request.getRequestURI());
    }
    @ExceptionHandler({NumberFormatException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorMessageForClient NumberFormatHandler(HttpServletRequest request, Exception e){
        return new ErrorMessageForClient(e.getMessage(), request.getRequestURI());
    }

    @ExceptionHandler({NotFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ErrorMessageForClient NotFoundHandler(HttpServletRequest request, Exception e){
        return new ErrorMessageForClient(e.getMessage(), request.getRequestURI());
    }

    @ExceptionHandler({Exception.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ErrorMessageForClient SQLExceptionHandler(HttpServletRequest request, Exception e){
        return new ErrorMessageForClient(e.getMessage(), request.getRequestURI());
    }
}
