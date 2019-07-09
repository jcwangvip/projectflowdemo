package com.jc.messageservice.kafka.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/kafka")
public class CollectController {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private KafkaTemplate kafkaTemplate;

    @RequestMapping(value = "/send", method = RequestMethod.GET)
    public String sendKafka(String message) {
        try {
            logger.info("kafka的消息={}", message);
            kafkaTemplate.send("test", "key", message);
            logger.info("发送kafka成功.");
            return "success";
        } catch (Exception e) {
            logger.error("发送kafka失败", e);
            return "error";
        }
    }

}