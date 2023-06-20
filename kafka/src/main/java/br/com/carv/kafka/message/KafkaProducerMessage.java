package br.com.carv.kafka.message;

import br.com.carv.kafka.dto.request.CarPostDTO;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
@Component
public class KafkaProducerMessage {
    private KafkaTemplate<String, CarPostDTO> kafkaTemplate;
    private final String KAFKA_TOPIC = "car-post-topic";
    public KafkaProducerMessage(KafkaTemplate<String, CarPostDTO> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(CarPostDTO carPostDTO) {
        this.kafkaTemplate.send(KAFKA_TOPIC, carPostDTO);
    }
}
