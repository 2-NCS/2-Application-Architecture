package com.example.demo.Controller.GlobalException;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.io.FileNotFoundException;

// TODO: 전역 예외 핸들러 3개를 작성하라.
//  필요한 import : org.springframework.ui.Model,
//                 org.springframework.web.bind.annotation.ExceptionHandler, java.io.FileNotFoundException
@ControllerAdvice
public class GlobalExceptionHandler {

    // TODO 1) @ExceptionHandler(FileNotFoundException.class) -> model 에 담고 "global/error1" 반환
    @ExceptionHandler(FileNotFoundException.class)
    public String exceptionHandler_1 (Exception e, Model model) {
        model.addAttribute("e",e);
        return "global/error1";
    }
//    // TODO 2) @ExceptionHandler(ArithmeticException.class)   -> "global/error2" 반환
//    @ExceptionHandler(FileNotFoundException.class)
//    public String exceptionHandler_2 (Exception e, Model model) {
//        model.addAttribute("e",e);
//        return "global/error2";
//    }
//
//    // TODO 3) @ExceptionHandler(Exception.class)             -> "global/error3" 반환
//    @ExceptionHandler(FileNotFoundException.class)
//    public String exceptionHandler_3 (Exception e, Model model) {
//        model.addAttribute("e",e);
//        return "global/error3";
//    }
}
