package com.example.demo.controller.advice;

import com.example.demo.exception.WebError;
import com.example.demo.exception.WebException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Locale;

/**
 * @author meow
 */
@Slf4j
@RestControllerAdvice
@RequiredArgsConstructor
public class ExceptionControllerAdvice {

    private final MessageSource messageSource;

    @ExceptionHandler(WebException.class)
    public ResponseEntity<Object> handleWebException(final WebException e) {
        final WebError webError = e.getWebError();
        log.error("[WebException]: {} ", webError.getErrorLog());
        final String resMessage = messageSource.getMessage(webError.getErrorCode(), e.getArgs(), LocaleContextHolder.getLocale());
        return ResponseEntity.status(webError.getStatusCode()).body(resMessage);
    }
}
