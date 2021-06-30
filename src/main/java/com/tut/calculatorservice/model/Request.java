package com.tut.calculatorservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Request {
    @NotNull(message = "Number one must not be empty")
    private int numberOne;
    @NotNull(message = "Number two must not be empty")
    private int numberTwo;
}
