package com.aiven.kafka.service;

import com.aiven.kafka.producer.AivenKafkaRecord;
import com.aiven.kafka.producer.ProducerExecutor;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;



@Service("ProducerService")
public class ProducerServiceImpl implements ProducerService {
    /**
     * Produce one record
     * @param topic
     * @param message
     * @return
     */

    @Override
    public boolean produce(String topic, String message){
        ProducerExecutor producerExecutor = new ProducerExecutor();
        return producerExecutor.produce(new AivenKafkaRecord(topic,message));
    }

    /**
     * Produce a batch records
     * @param payloadArray JSONArray with JSONObjects as elements, each object contains "topic" and "payload" items
     * @return
     */
    @Override
    public boolean produce(JSONArray payloadArray){
        ProducerExecutor producerExecutor = new ProducerExecutor();
        for(Object obj: payloadArray){
            if(!producerExecutor.produce(AivenKafkaRecord.fromJSON((JSONObject)obj))){
                return false;
            }
        }
        return true;
    }
}
