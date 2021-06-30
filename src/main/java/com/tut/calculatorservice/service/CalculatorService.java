package com.tut.calculatorservice.service;

import com.tut.calculatorservice.model.Response;

public interface CalculatorService {
    Response add(int numberOne, int numberTwo);
    Response subtract(int numberOne, int numberTwo);
}
