package br.com.carv.carstore.message;

import br.com.carv.carstore.dto.CarPostDTO;
import br.com.carv.carstore.service.CarPostService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
public class KafkaConsumerMessage {

    private final Logger logger = Logger.getLogger(KafkaConsumerMessage.class.getSimpleName());

    private final CarPostService carPostService;

    public KafkaConsumerMessage(CarPostService carPostService) {
        this.carPostService = carPostService;
    }

    @KafkaListener(topics = "car-post-topic", groupId = "store-posts-group")
    public void listening(CarPostDTO carPostDTO) {
        logger.info("Received Car Post information: {}" + carPostDTO);
        carPostService.newPostDetails(carPostDTO);
    }
}
