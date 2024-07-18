package org.microservice.withdrawal.handler;

import lombok.extern.slf4j.Slf4j;
import org.microservice.core.WithdrawalRequestedEvent;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@KafkaListener(topics = "withdraw-money-topic", containerFactory = "kafkaListenerContainerFactory")
public class WithdrawalRequestedEventHandler {

    @KafkaHandler
    public void handle(WithdrawalRequestedEvent event) {
        log.info("Received a new withdrawal event: {}", event.getAmount());
    }
}
