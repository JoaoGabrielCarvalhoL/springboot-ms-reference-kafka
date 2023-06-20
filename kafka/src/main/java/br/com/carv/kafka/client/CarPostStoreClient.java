package br.com.carv.kafka.client;

import br.com.carv.kafka.dto.request.CarPostDTO;
import br.com.carv.kafka.dto.request.OwnerPostDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.logging.Logger;

@Service
public class CarPostStoreClient {

    private final String USER_STORE_SERVICE_URI = "http://127.0.0.1:8080/user";
    private final String POST_STORE_CAR_SERVICE_URI = "http://127.0.0.1:8080/sales/cars";
    private final String POST_STORE_SERVICE_URI = "http://127.0.0.1:8080/sales";
    private final RestTemplate restTemplate;
    private final Logger logger = Logger.getLogger(CarPostStoreClient.class.getSimpleName());

    public CarPostStoreClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<CarPostDTO> carForSaleClient() {
        logger.info("Getting all cars from client.");
        ResponseEntity<CarPostDTO[]> response =
                this.restTemplate.getForEntity(POST_STORE_CAR_SERVICE_URI, CarPostDTO[].class);
        return Arrays.asList(Objects.requireNonNull(response.getBody()));
    }

    public void ownerPostClient(OwnerPostDTO ownerPostDTO) {
        logger.info("Send to insert a new resource from client.");
        this.restTemplate.postForEntity(USER_STORE_SERVICE_URI, ownerPostDTO, OwnerPostDTO.class);
    }


    public void changeCarForSaleClient(CarPostDTO carPostDTO, Long id) {
        this.restTemplate.put(POST_STORE_CAR_SERVICE_URI + "/" + id, carPostDTO, CarPostDTO.class);
    }

    public void deleteCarForSaleClient(Long id) {
        this.restTemplate.delete(POST_STORE_CAR_SERVICE_URI + "/" + id);
    }
}
