package br.com.carv.carstore.mapper;

import br.com.carv.carstore.dto.CarPostDTO;
import br.com.carv.carstore.entity.CarPostEntity;
import br.com.carv.carstore.entity.OwnerPostEntity;
import org.springframework.stereotype.Component;

@Component
public class CarMapper {

    public CarPostEntity toCar(CarPostDTO carPostDTO) {
        OwnerPostEntity owner = new OwnerPostEntity(carPostDTO.getOwnerName(), carPostDTO.getOwnerType(), carPostDTO.getContact());
        return new CarPostEntity(carPostDTO.getModel(), carPostDTO.getBrand(), carPostDTO.getPrice(),
                carPostDTO.getDescription(), carPostDTO.getEngineVersion(), carPostDTO.getCity(), carPostDTO.getCreatedDate(),
                carPostDTO.getContact(), owner);
    }

    public CarPostDTO toCarPostDTO(CarPostEntity carPostEntity) {
        return new CarPostDTO(carPostEntity.getModel(), carPostEntity.getBrand(), carPostEntity.getPrice(),carPostEntity.getDescription(),
                carPostEntity.getEngineVersion(), carPostEntity.getCity(), carPostEntity.getCreatedDate(),
                carPostEntity.getOwnerPostEntity().getId(), carPostEntity.getOwnerPostEntity().getName(),
                carPostEntity.getOwnerPostEntity().getType(), carPostEntity.getContact());
    }

}
