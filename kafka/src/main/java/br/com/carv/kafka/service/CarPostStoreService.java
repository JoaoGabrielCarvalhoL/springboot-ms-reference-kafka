package br.com.carv.kafka.service;

import br.com.carv.kafka.dto.request.CarPostDTO;

import java.util.List;

public interface CarPostStoreService {

    List<CarPostDTO> getCarForSales();

    void changeCarForSale(CarPostDTO carPostDTO, Long ownerId);

    void removeCarForSale(Long id);
}
