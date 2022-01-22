package kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.util.Collections;
import java.util.Properties;

public class TestCousmer {

    public static void main(String[] args) {
        Properties properties = new Properties();
        properties.setProperty("bootstrap.servers","127.0.0.1:9092");
        properties.setProperty("key.deserializer", StringDeserializer.class.getName());
        properties.setProperty("value.deserializer",StringDeserializer.class.getName());
        properties.setProperty("group.id","11161");
        KafkaConsumer<String,String> consumer = new KafkaConsumer<String, String>(properties);
        consumer.subscribe(Collections.singletonList("test-topic"));

        while (true){
            ConsumerRecords<String, String> poll = consumer.poll(1000);
            for (ConsumerRecord<String, String> stringStringConsumerRecord : poll) {
                System.out.println(stringStringConsumerRecord);
            }
        }
    }
}

