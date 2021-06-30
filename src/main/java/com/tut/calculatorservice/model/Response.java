package com.tut.calculatorservice.model;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Data
@Builder
@Getter
@Setter
public class Response {
    private int result;
    private HttpStatus httpStatus;
    private String message;
}
