package com.rana.kafka.producerconsumer.resource;

import com.rana.kafka.producerconsumer.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("kafka")
public class UserResource {
    @Autowired
    KafkaTemplate<String,User> kafkaTemplate;
    private static final String TOPIC = "kafka_Example";
 //   @GetMapping("/publish/{name}")
    @RequestMapping(value = "/publish/{name}",method = RequestMethod.GET)
    public String post(@PathVariable("message") String name){
        kafkaTemplate.send(TOPIC,new User(name,"Technology",12000L));
        return "Published successfully";
    }
}
