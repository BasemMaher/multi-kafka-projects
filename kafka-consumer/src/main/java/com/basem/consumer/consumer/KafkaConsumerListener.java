package com.basem.consumer.consumer;

import com.basem.consumer.consumer.dto.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerListener {

    Logger log= LoggerFactory.getLogger(KafkaConsumerListener.class);

    @KafkaListener(topics = "topic8", groupId = "jt-group5", containerFactory = "kafkaListenerContainerFactory")
    public void consumeEvents(Customer customer) {
        log.info("Consumer consumed the message: {}", customer.toString());
    }
//
//    @KafkaListener(topics = "topic5",groupId = "jt-group2")
//    public  void  consume2(String message){
//        log.info("consumer consume the message {}",message);
//    }
//
//    @KafkaListener(topics = "topic5",groupId = "jt-group2")
//    public  void  consume3(String message){
//        log.info("consumer consume the message {}",message);
//    }
//    @KafkaListener(topics = "topic5",groupId = "jt-group2")
//    public  void  consume4(String message){
//        log.info("consumer consume the message {}",message);
//    }
//    @KafkaListener(topics = "topic5",groupId = "jt-group2")
//    public  void  consume5(String message){
//        log.info("consumer consume the message {}",message);
//    }

}
