package com.aea.springboot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerDatabase {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumerDatabase.class);

    @KafkaListener(groupId = "wikimediaConsumerGroup", topicPartitions = {@TopicPartition(topic = "wikimedia_recentchange", partitions = {"0", "1"})})
    public void consume(String eventMessage) {
        LOGGER.info(String.format("Event message received => %s", eventMessage));
    }

}
