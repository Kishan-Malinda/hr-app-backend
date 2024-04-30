package org.hrapp.hr_app_backend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class RosourceNotFoundException extends RuntimeException{
    public RosourceNotFoundException(String message){
        super(message);
    }
}
