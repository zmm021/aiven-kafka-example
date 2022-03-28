package com.aiven.kafka.controller;

import com.aiven.kafka.conf.CommonConf;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.http.ResponseEntity;



@Controller
@Validated
public class GenericController {

    @GetMapping("/aiven/kafka/test")
    public ResponseEntity<?> connectTest( ) {
        return ResponseEntity.ok("This service is alive..");
    }
    
    @GetMapping("/aiven/kafka/api/v1/version")
    public ResponseEntity<?> apiVersionCheck() {
        return ResponseEntity.ok(CommonConf.apiVersion);
    }







}


