package com.freak.project.controller;

import com.freak.project.exception.StationNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionHandleController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionHandleController.class);

    @ExceptionHandler(StationNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "this station do not exist")
    public String stationNotFoundException() {
        LOGGER.error("this station do not exist");
        return "this station do not exist";
    }
}
