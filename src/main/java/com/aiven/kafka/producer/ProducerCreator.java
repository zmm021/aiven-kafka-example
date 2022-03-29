package com.aiven.kafka.producer;

import com.aiven.kafka.conf.AivenKafkaConstants;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

public class ProducerCreator {

    /**
     * Create a Kafka Producer with the Parameters from IKafkaConstants.java
     * @return
     */
    public static Producer<String, String> createProducer() {
        Properties props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, AivenKafkaConstants.BOOTSTRAP_SERVERS);
        props.put(ProducerConfig.CLIENT_ID_CONFIG, AivenKafkaConstants.CLIENT_ID);
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        props.put("request.required.acks",1);
        props.put("producer.type", "async");
        props.put("compression.codec", "snappy");
        props.put("batch.num.messages",1000);
        props.put("queue.buffering.max.ms",5000);
        props.put("queue.enqueue.timeout.ms ",-1);
        props.put("message.send.max.retries",3);
        props.put("security.protocol", "SSL");
        props.put("ssl.truststore.location", AivenKafkaConstants.SSL_TRUSTSTORE_LOCATION);
        props.put("ssl.truststore.password", AivenKafkaConstants.SSL_TRUSTSTORE_PASSWORD);
        props.put("ssl.keystore.type", AivenKafkaConstants.SSL_KEYSTORE_TYPE);
        props.put("ssl.keystore.location", AivenKafkaConstants.SSL_KEYSTORE_LOCATION);
        props.put("ssl.keystore.password", AivenKafkaConstants.SSL_KEYSTORE_PASSWORD);
        props.put("ssl.key.password", AivenKafkaConstants.SSL_KEY_PASSWORD);
        return new KafkaProducer<>(props);
    }



}