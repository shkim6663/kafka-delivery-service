package org.example.kafkaredisspring.common.model.kafka.topic;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopics {
	/**
	 * 결제 완료 이벤트를 발생/소비 하기 위한 토픽 명칭입니다/
	 */
	public static final String TOPIC_PAYMENT_COMPLETED = "payment-completed";

	/**
	 * 결제 완료 토픽을 생성하고 파티션 구조를 정의 합니다
	 * 파티션 개수 확장 (1->3)
	 * 데이터 처리를 병렬화
	 * 늘어난 파티션 수만큼 컨슈머 스레드를 할당하여 처리량 증가
	 * @return 3개의 파티션과 1개의 복제본으로 구성
	 */
	@Bean
	public NewTopic paymentCompletedTopic() {
		return TopicBuilder.name(TOPIC_PAYMENT_COMPLETED)
			.partitions(3)
			.replicas(1)
			.build();
	}
}