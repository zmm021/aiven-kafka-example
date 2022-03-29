package com.aiven.kafka.producer;


import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;


public class ProducerExecutor {
    private Producer<String, String> producer;//the producer client used for sending data

    public ProducerExecutor() {
        producer = ProducerCreator.createProducer();
    }

    /**
     * produce a record to Aiven Kafka
     *
     * @param payload
     * @return
     */
    public boolean produce(AivenKafkaRecord payload) {
        try {
            producer.send(new ProducerRecord<>(payload.getTopic(), payload.getPayload()));
            return true;
        } catch (Exception e) {
            return false;
        }
    }


}
