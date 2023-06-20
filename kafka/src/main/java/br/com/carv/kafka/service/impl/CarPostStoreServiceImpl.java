package br.com.carv.kafka.service.impl;

import br.com.carv.kafka.client.CarPostStoreClient;
import br.com.carv.kafka.dto.request.CarPostDTO;
import br.com.carv.kafka.service.CarPostStoreService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarPostStoreServiceImpl implements CarPostStoreService {

    private final CarPostStoreClient carPostStoreClient;

    public CarPostStoreServiceImpl(CarPostStoreClient carPostStoreClient) {
        this.carPostStoreClient = carPostStoreClient;
    }
    @Override
    public List<CarPostDTO> getCarForSales() {
        return this.carPostStoreClient.carForSaleClient();
    }

    @Override
    public void changeCarForSale(CarPostDTO carPostDTO, Long ownerId) {
        this.carPostStoreClient.changeCarForSaleClient(carPostDTO, ownerId);
    }

    @Override
    public void removeCarForSale(Long id) {
        this.carPostStoreClient.deleteCarForSaleClient(id);
    }
}
