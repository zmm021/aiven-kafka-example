package com.aiven.kafka.producer;

import com.google.gson.Gson;
import org.json.JSONObject;

public class AivenKafkaRecord {
    private String payload;
    private String topic;


    private static String _payload="payload";
    private static String _topic="topic";

    /**
     * Convert a record object from a String
     * @param object
     * @return
     */
    public static AivenKafkaRecord fromJSON(String object){
        Gson gson = new Gson();
        AivenKafkaRecord record = gson.fromJson(object, AivenKafkaRecord.class);
        return record;
    }

    /**
     * Convert a record from JSONObject
     * @param object
     * @return
     */
    public static AivenKafkaRecord fromJSON(JSONObject object){
        AivenKafkaRecord record = new AivenKafkaRecord();
        record.payload = object.getJSONObject(_payload).toString();
        record.topic = object.getString(_topic);
        return record;
    }

    public AivenKafkaRecord(){}

    public AivenKafkaRecord(String topic, String value){
        this.topic = topic;
        this.payload = value;
    }

    public String getPayload() {
        return payload;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }
}


