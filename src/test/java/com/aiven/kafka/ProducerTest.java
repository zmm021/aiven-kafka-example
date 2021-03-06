package com.aiven.kafka;

import com.aiven.kafka.producer.AivenKafkaRecord;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.json.JSONObject;

import java.util.Properties;

public class ProducerTest {
    public static void main(String[] args){
        testKFKRecord();
    }

    /**
     * Test converting the kafka record from String or JSONObject
     */
    public static void testKFKRecord(){
        String value = "{\"lat\":1234,\"log\":5678,\"timestamp\":\"2021-01-01 10:10:10\"}";
        String topicName = "gps_topic";
        JSONObject valueObj = new JSONObject(value);
        JSONObject payload = new JSONObject();
        payload.put("topic",topicName);
        payload.put("payload",valueObj.toString());
        AivenKafkaRecord record = AivenKafkaRecord.fromJSON(payload.toString());
        System.out.println(record.getTopic()+"   " +record.getPayload());
    }

    /**
     * Test creating a producer and produce a message to Kafka
     */
    public static void testNaiveProduce(){
        String value = "{\"lat\":1234,\"log\":5678,\"timestamp\":\"2021-01-01 10:10:10\"}";
        String sasl_username = "avnadmin";
        String sasl_password = "YtTyyqXW5YbrVY8c";


        AivenKafkaRecord aivenKafkaRecord = new AivenKafkaRecord("gps_topic",value);
        Properties props = new Properties();
        props.put("bootstrap.servers", "kafka-mingming-test-thinkresearch-e997.aivencloud.com:23824");
        props.put("security.protocol", "SSL");
        props.put("ssl.truststore.location", "/Users/mingmingzhang/Documents/temp/client.truststore.jks");
        props.put("ssl.truststore.password", "abc123");
        props.put("ssl.keystore.type", "PKCS12");
        props.put("ssl.keystore.location", "/Users/mingmingzhang/Documents/temp/client.keystore.p12");
        props.put("ssl.keystore.password", "abc123");
        props.put("ssl.key.password", "abc123");
        props.put("key.serializer",
                "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer",
                "org.apache.kafka.common.serialization.StringSerializer");

        KafkaProducer<String, String> producer = new KafkaProducer<>(props);
        producer.send(new ProducerRecord<String, String>("gps_topic", Integer.toString(1), value));
        producer.close();
    }
}
