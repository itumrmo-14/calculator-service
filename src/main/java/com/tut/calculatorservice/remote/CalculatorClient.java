package com.tut.calculatorservice.remote;

import com.tut.calculatorservice.ws.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Component;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import javax.annotation.PostConstruct;

@Component
@Slf4j
public class CalculatorClient {

    @Value("${calculator.service.soap.base.url}")
    private String calculatorServiceBaseUrl;
    @Value("${calculator.service.soap.subtract.callback.url}")
    private String subtractCallBackUrl;
    @Value("${calculator.service.soap.add.callback.url}")
    private String addCallBackUrl;
    @Autowired
    private Jaxb2Marshaller jaxb2Marshaller;
    private WebServiceTemplate webServiceTemplate;
    private ObjectFactory objectFactory;

    @PostConstruct
    public void init(){
        log.info("Setting up initial data");
        objectFactory = new ObjectFactory();
        webServiceTemplate = new WebServiceTemplate(jaxb2Marshaller);
    }

    public int add(int one, int two) {
        Add add = objectFactory.createAdd();
        add.setIntA(one);
        add.setIntB(two);
        log.info("Preparing to perform add");
        AddResponse response = (AddResponse) callClient(calculatorServiceBaseUrl, add, addCallBackUrl
        );
        return response.getAddResult();
    }

    public int subtract(int numberOne, int numberTwo){
        Subtract subtract = objectFactory.createSubtract();
        subtract.setIntA(numberOne);
        subtract.setIntB(numberTwo);
        SubtractResponse subtractResponse = (SubtractResponse) callClient(calculatorServiceBaseUrl,subtract,subtractCallBackUrl);
        return subtractResponse.getSubtractResult();
    }

    private Object callClient(String uri, Object request, String requestCallBackUri){
        return webServiceTemplate.marshalSendAndReceive(uri,request,new SoapActionCallback(requestCallBackUri));
    }
}
