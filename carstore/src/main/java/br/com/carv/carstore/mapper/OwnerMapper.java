package br.com.carv.carstore.mapper;

import br.com.carv.carstore.dto.OwnerPostDTO;
import br.com.carv.carstore.entity.OwnerPostEntity;
import org.springframework.stereotype.Component;

@Component
public class OwnerMapper {

    public OwnerPostEntity toOwnerPostEntity(OwnerPostDTO ownerPostDTO) {
        return new OwnerPostEntity(ownerPostDTO.getName(), ownerPostDTO.getType(), ownerPostDTO.getContactNumber());
    }
}
