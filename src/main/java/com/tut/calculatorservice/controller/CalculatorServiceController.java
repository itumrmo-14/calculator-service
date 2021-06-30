package com.tut.calculatorservice.controller;

import com.tut.calculatorservice.model.Request;
import com.tut.calculatorservice.remote.CalculatorClient;
import com.tut.calculatorservice.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("calculator")
public class CalculatorServiceController {

    @Autowired
    private CalculatorService calculatorService;

    @PostMapping(value = "add")
    public ResponseEntity add(@RequestBody @Valid Request request) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(calculatorService.add(request.getNumberOne(),request.getNumberTwo()));
    }

    @PostMapping(value = "subtract")
    public ResponseEntity subtract(@RequestBody @Valid Request request){
        return ResponseEntity.status(HttpStatus.OK).body(calculatorService.subtract(request.getNumberOne(),request.getNumberTwo()));
    }
}
