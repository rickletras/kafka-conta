package com.zupedu.conta.conta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class ContaProducer {
    @Value("${spring.kafka.producer.topic}")
    private String topico;

    @Autowired
    private KafkaTemplate<String, Conta> kafkaTemplate;

    @Async
    public void enviar(Conta conta) {
        kafkaTemplate.send(topico, conta);
    }
}
