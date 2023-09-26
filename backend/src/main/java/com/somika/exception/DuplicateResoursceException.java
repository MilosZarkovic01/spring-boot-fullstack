package com.somika.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT)
public class DuplicateResoursceException extends RuntimeException{

    public DuplicateResoursceException(String message) {
        super(message);
    }
}
