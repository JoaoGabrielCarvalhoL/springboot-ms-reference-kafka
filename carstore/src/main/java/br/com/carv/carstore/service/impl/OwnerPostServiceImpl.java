package br.com.carv.carstore.service.impl;

import br.com.carv.carstore.dto.OwnerPostDTO;
import br.com.carv.carstore.entity.OwnerPostEntity;
import br.com.carv.carstore.mapper.OwnerMapper;
import br.com.carv.carstore.repository.OwnerPostRepository;
import br.com.carv.carstore.service.OwnerPostService;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class OwnerPostServiceImpl implements OwnerPostService {

    private final OwnerMapper ownerMapper;
    private final OwnerPostRepository ownerPostRepository;
    private final Logger logger = Logger.getLogger(OwnerPostServiceImpl.class.getSimpleName());

    public OwnerPostServiceImpl(OwnerMapper ownerMapper, OwnerPostRepository ownerPostRepository) {
        this.ownerMapper = ownerMapper;
        this.ownerPostRepository = ownerPostRepository;
    }

    @Override
    public void createOwnerPost(OwnerPostDTO ownerPostDTO) {
        OwnerPostEntity ownerPostEntity = this.ownerMapper.toOwnerPostEntity(ownerPostDTO);
        this.ownerPostRepository.save(ownerPostEntity);
    }
}
