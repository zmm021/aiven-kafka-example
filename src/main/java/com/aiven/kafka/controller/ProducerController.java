package com.aiven.kafka.controller;

import com.aiven.kafka.service.ProducerService;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;


@Controller
@Validated
public class ProducerController {

    @Autowired
    ProducerService producerService;

    @RequestMapping(value = "/avian/kafka/produce/batch", method = RequestMethod.POST)
    public ResponseEntity<?> produceBatch(@RequestBody String payloadArray){
        try {
            JSONArray array = new JSONArray(payloadArray);
            if(producerService.produce(array)){
                return ResponseEntity.ok("succeed");
            }else{
                return ResponseEntity.badRequest().body("Exception: unable to produce data to kafka.");
            }
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.badRequest().body("Exception: "+e.getMessage());
        }
    }




}


