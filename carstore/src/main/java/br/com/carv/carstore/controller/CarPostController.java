package br.com.carv.carstore.controller;

import br.com.carv.carstore.dto.CarPostDTO;
import br.com.carv.carstore.service.CarPostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping
@RestController("/sales")
public class CarPostController {

    private final CarPostService carPostService;

    public CarPostController(CarPostService carPostService) {
        this.carPostService = carPostService;
    }

    @GetMapping("/cars")
    public ResponseEntity<List<CarPostDTO>> getCarSales() {
        return ResponseEntity.status(HttpStatus.OK).body(carPostService.getCarForSales());
    }

    @PutMapping("/cars/{id}")
    public ResponseEntity<Void> changeCarForSale(@RequestBody CarPostDTO carPostDTO, @PathVariable("id") Long id) {
        this.carPostService.changeCarSale(carPostDTO, id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping("/cars/{id}")
    public ResponseEntity<Void> deleteCarForSale(@PathVariable("id") Long id) {
        this.carPostService.removeCarSale(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
