package br.com.carv.kafka.service.impl;

import br.com.carv.kafka.client.CarPostStoreClient;
import br.com.carv.kafka.dto.request.OwnerPostDTO;
import br.com.carv.kafka.service.OwnerPostService;
import org.springframework.stereotype.Service;

@Service
public class OwnerPostServiceImpl implements OwnerPostService {

    private final CarPostStoreClient carPostStoreClient;

    public OwnerPostServiceImpl(CarPostStoreClient carPostStoreClient) {
        this.carPostStoreClient = carPostStoreClient;
    }
    @Override
    public void createOwnerCar(OwnerPostDTO ownerPostDTO) {
        this.carPostStoreClient.ownerPostClient(ownerPostDTO);
    }
}
