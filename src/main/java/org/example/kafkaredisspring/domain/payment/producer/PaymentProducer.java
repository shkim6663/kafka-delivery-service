package org.example.kafkaredisspring.domain.payment.producer;

import static org.example.kafkaredisspring.common.model.kafka.topic.KafkaTopics.TOPIC_PAYMENT_COMPLETED;

import lombok.RequiredArgsConstructor;
import org.example.kafkaredisspring.common.model.kafka.event.PaymentCompletedEvent;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentProducer {

    private final KafkaTemplate<String, PaymentCompletedEvent> paymentCompletedEventKafkaTemplate;

    public void send(String key,PaymentCompletedEvent event) {
		/**
		 * 기존 send (topic, event) -> send(topic, key, event)
		 * key를 추가함으로써 동일한 주문은 동일한 파티션으로 전송됨
		 */
        paymentCompletedEventKafkaTemplate.send(TOPIC_PAYMENT_COMPLETED, key,event);
    }

}
