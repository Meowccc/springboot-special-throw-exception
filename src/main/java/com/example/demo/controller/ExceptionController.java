package com.example.demo.controller;

import com.example.demo.exception.WebErrorEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author meow
 */
@RestController
@RequestMapping
@RequiredArgsConstructor
public class ExceptionController {

    @PostMapping("exception/{seq}")
    public void exception(@PathVariable final int seq) {
        final WebErrorEnum errorEnum = WebErrorEnum.values()[seq];
        throw  errorEnum.exception();
    }

    @PostMapping("exception")
    public void exceptionWithArgs() {
        throw WebErrorEnum.INVALID_ARG.exception("test");
    }
}
