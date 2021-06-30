package com.tut.calculatorservice.service;

import com.tut.calculatorservice.model.Response;
import com.tut.calculatorservice.remote.CalculatorClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DefaultCalculatorService implements CalculatorService{

    @Autowired
    private CalculatorClient calculatorClient;

    @Override
    public Response add(int numberOne, int numberTwo) {
        try{
            int result = calculatorClient.add(numberOne, numberTwo);
            return Response.builder().httpStatus(HttpStatus.OK).result(result).message(HttpStatus.OK.getReasonPhrase()).build();
        }catch (Exception e){
            log.info("Failed to perform transaction because [{}]",e.getMessage());
            return Response.builder().result(HttpStatus.INTERNAL_SERVER_ERROR.value()).message(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase()).build();
        }
    }

    @Override
    public Response subtract(int numberOne, int numberTwo) {
        try{
            int result = calculatorClient.subtract(numberOne, numberTwo);
            return Response.builder().httpStatus(HttpStatus.OK).result(result).message(HttpStatus.OK.getReasonPhrase()).build();
        }catch (Exception e){
            log.info("Failed to perform transaction because [{}]",e.getMessage());
            return Response.builder().result(HttpStatus.INTERNAL_SERVER_ERROR.value()).message(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase()).build();
        }
    }
}
