package com.aiven.kafka.conf;



public interface IKafkaConstants {
    String BOOTSTRAP_SERVERS = "kafka-mingming-test-thinkresearch-e997.aivencloud.com:23824";
    String SSL_TRUSTSTORE_LOCATION="/Users/mingmingzhang/Documents/temp/client.truststore.jks";
    String SSL_TRUSTSTORE_PASSWORD="abc123";
    String SSL_KEYSTORE_TYPE= "PKCS12";
    String SSL_KEYSTORE_LOCATION="/Users/mingmingzhang/Documents/temp/client.keystore.p12";
    String SSL_KEYSTORE_PASSWORD="abc123";
    String SSL_KEY_PASSWORD="abc123";

    String CLIENT_ID="aiven-client-test1";
}

