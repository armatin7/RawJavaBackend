package com.armatin.exceeption;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;
@Data
public class ApiException {
    private final String message;
//    private final Throwable throwable; //later extend it
    private final HttpStatus status;
    private final ZonedDateTime time;
}
