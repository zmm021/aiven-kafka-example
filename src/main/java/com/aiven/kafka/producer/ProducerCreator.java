package com.aiven.kafka.producer;

import com.aiven.kafka.conf.IKafkaConstants;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

public class ProducerCreator {

    public static Producer<String, String> createProducer() {
        Properties props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, IKafkaConstants.BOOTSTRAP_SERVERS);
        props.put(ProducerConfig.CLIENT_ID_CONFIG, IKafkaConstants.CLIENT_ID);
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
        props.put("ssl.truststore.location", IKafkaConstants.SSL_TRUSTSTORE_LOCATION);
        props.put("ssl.truststore.password", IKafkaConstants.SSL_TRUSTSTORE_PASSWORD);
        props.put("ssl.keystore.type", IKafkaConstants.SSL_KEYSTORE_TYPE);
        props.put("ssl.keystore.location", IKafkaConstants.SSL_KEYSTORE_LOCATION);
        props.put("ssl.keystore.password", IKafkaConstants.SSL_KEYSTORE_PASSWORD);
        props.put("ssl.key.password", IKafkaConstants.SSL_KEY_PASSWORD);
        return new KafkaProducer<>(props);
    }



}