package br.com.carv.kafka.controller;

import br.com.carv.kafka.dto.request.CarPostDTO;
import br.com.carv.kafka.dto.request.OwnerPostDTO;
import br.com.carv.kafka.service.CarPostStoreService;
import br.com.carv.kafka.service.OwnerPostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/owners")
public class OwnerPostController {

    private final OwnerPostService ownerPostService;

    public OwnerPostController(OwnerPostService ownerPostService) {
        this.ownerPostService = ownerPostService;
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> changeCarForSale(@RequestBody OwnerPostDTO ownerPostDTO) {
        this.ownerPostService.createOwnerCar(ownerPostDTO);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
