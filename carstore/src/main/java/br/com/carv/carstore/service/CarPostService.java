package br.com.carv.carstore.service;

import br.com.carv.carstore.dto.CarPostDTO;

import java.util.List;

public interface CarPostService {

    void newPostDetails(CarPostDTO carPostDTO);

    List<CarPostDTO> getCarForSales();

    void changeCarSale(CarPostDTO carPostDTO, Long postId);

    void removeCarSale(Long postId);
}
