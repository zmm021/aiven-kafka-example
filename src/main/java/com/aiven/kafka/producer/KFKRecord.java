package com.aiven.kafka.producer;

import com.google.gson.Gson;
import org.json.JSONObject;

public class KFKRecord{
    private String payload;
    private String topic;


    private static String _payload="payload";
    private static String _topic="topic";

    public static KFKRecord fromJSON(String object){
        Gson gson = new Gson();
        KFKRecord record = gson.fromJson(object,KFKRecord.class);
        return record;
    }
    public static KFKRecord fromJSON(JSONObject object){
        KFKRecord record = new KFKRecord();
        record.payload = object.getJSONObject(_payload).toString();
        record.topic = object.getString(_topic);
        return record;
    }

    public KFKRecord(){}

    public KFKRecord(String topic,String value){
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


