package com.aiven.kafka.service;


import org.json.JSONArray;

public interface ProducerService {
    boolean produce(JSONArray payloadArray);
    boolean produce(String topic,String message);


}
