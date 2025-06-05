package producer.producer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import producer.producer.dto.Customer;
import producer.producer.service.KafkaMessagePublisher;

import static org.springframework.http.ResponseEntity.*;

@RestController
@RequestMapping("/producer-app")
public class EventController {

    @Autowired
    private KafkaMessagePublisher kafkaMessagePublisher;

    @GetMapping("/publish/{message}")
    public ResponseEntity<?> publiahMessage(@PathVariable String message) {
        try {
            for (int i=0;i<10000;i++) {
                kafkaMessagePublisher.setMessageToTopic(message +String.valueOf(i));
            }
            return  ok("message published successfully ..");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .build();
        }
    }
    @PostMapping("/publish")
    public void sendEvents(@RequestBody  Customer customer){
        kafkaMessagePublisher.setEventToTopic(customer);
    }



}
