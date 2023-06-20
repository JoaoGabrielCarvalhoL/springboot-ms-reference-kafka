package br.com.carv.kafka.controller;

import br.com.carv.kafka.dto.request.CarPostDTO;
import br.com.carv.kafka.message.KafkaProducerMessage;
import br.com.carv.kafka.service.CarPostStoreService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cars")
public class CarPostController {
    private final CarPostStoreService carPostStoreService;
    private final KafkaProducerMessage kafkaProducerMessage;

    public CarPostController(CarPostStoreService carPostStoreService, KafkaProducerMessage kafkaProducerMessage) {
        this.carPostStoreService = carPostStoreService;
        this.kafkaProducerMessage = kafkaProducerMessage;
    }

    @PostMapping
    public ResponseEntity<Void> postCarForSale(@RequestBody CarPostDTO carPostDTO) {
        kafkaProducerMessage.sendMessage(carPostDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity<List<CarPostDTO>> getCarSales() {
        return ResponseEntity.status(HttpStatus.OK).body(this.carPostStoreService.getCarForSales());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> changeCarForSale(@RequestBody CarPostDTO carPostDTO, @PathVariable("id") Long id) {
        this.carPostStoreService.changeCarForSale(carPostDTO, id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCarForSale(@PathVariable("id") Long id) {
        this.carPostStoreService.removeCarForSale(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
