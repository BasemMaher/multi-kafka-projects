package producer.producer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import producer.producer.dto.Customer;

import java.util.concurrent.CompletableFuture;

@Service
public class KafkaMessagePublisher {
    @Autowired
    private KafkaTemplate<String,Object>template;

    public void setMessageToTopic(String message){
        CompletableFuture<SendResult<String, Object>> future = template.send("topic6", message);
        future.whenComplete((result,exc)->{
            if( exc == null){
                System.out.println("sent message =[ "+message + " ] with offset=[ " +result.getRecordMetadata().offset() + "]");
            }else {
                System.out.println("Unable to send message = ["+message +"] due to : " + exc.getMessage());
            }
        });
    }

    public void setEventToTopic(Customer customer){
        try {
            CompletableFuture<SendResult<String, Object>> future = template.send("topic8", customer);
            future.whenComplete((result, exc) -> {
                if (exc == null) {
                    System.out.println("sent message =[ " + customer.toString() + " ] with offset=[ " + result.getRecordMetadata().offset() + "]");
                } else {
                    System.out.println("Unable to send message = [" + customer.toString() + "] due to : " + exc.getMessage());
                }
            });
        } catch (Exception e) {
            System.out.println("Error: "+e.getMessage());
        }
    }

}
