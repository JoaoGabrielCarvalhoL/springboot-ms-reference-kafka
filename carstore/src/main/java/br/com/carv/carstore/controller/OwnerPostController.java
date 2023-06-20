package br.com.carv.carstore.controller;

import br.com.carv.carstore.dto.OwnerPostDTO;
import br.com.carv.carstore.mapper.OwnerMapper;
import br.com.carv.carstore.service.OwnerPostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class OwnerPostController {

    private final OwnerPostService ownerPostService;
    public OwnerPostController(OwnerPostService ownerPostService) {
        this.ownerPostService = ownerPostService;
    }

    @PostMapping
    public ResponseEntity<Void> createOwner(@RequestBody OwnerPostDTO ownerPostDTO) {
        ownerPostService.createOwnerPost(ownerPostDTO);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
