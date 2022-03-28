package com.aiven.kafka.service;

import com.aiven.kafka.producer.KFKRecord;
import com.aiven.kafka.producer.ProducerExecutor;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;



@Service("ProducerService")
public class ProducerServiceImpl implements ProducerService {

    @Override
    public boolean produce(String topic, String message){
        ProducerExecutor producerExecutor = new ProducerExecutor();
        return producerExecutor.produce(new KFKRecord(topic,message));
    }

    @Override
    public boolean produce(JSONArray payloadArray){
        ProducerExecutor producerExecutor = new ProducerExecutor();
        for(Object obj: payloadArray){
            if(!producerExecutor.produce(KFKRecord.fromJSON((JSONObject)obj))){
                return false;
            }
        }
        return true;
    }
}
