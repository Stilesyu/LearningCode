package kafka;

import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;
import java.util.concurrent.Future;

public class Producer {

    public static void main(String[] args) throws  Exception{
        Properties properties = new Properties();
        //指定kafka服务器地址 如果是集群可以指定多个  但是就算只指定一个他也会去集群环境下寻找其他的节点地 址
        //key序列化器
        properties.setProperty("key.serializer", StringSerializer.class.getName());
        //value序列化器
        properties.setProperty("value.serializer",StringSerializer.class.getName());
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        properties.put(ProducerConfig.CLIENT_ID_CONFIG, "producer");
        KafkaProducer<String,String> kafkaProducer = new KafkaProducer<>(properties);
        ProducerRecord<String, String> stringStringProducerRecord = new ProducerRecord<String, String>("test-topic",0,"testKey","helloff");
        Future<RecordMetadata> send = kafkaProducer.send(stringStringProducerRecord);
        RecordMetadata recordMetadata = send.get();
        System.out.println(recordMetadata);
    }


}