package br.com.carv.carstore.service.impl;

import br.com.carv.carstore.dto.CarPostDTO;
import br.com.carv.carstore.entity.CarPostEntity;
import br.com.carv.carstore.exception.ResourceNotFound;
import br.com.carv.carstore.mapper.CarMapper;
import br.com.carv.carstore.repository.CarPostRepository;
import br.com.carv.carstore.repository.OwnerPostRepository;
import br.com.carv.carstore.service.CarPostService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Service
public class CarPostServiceImpl implements CarPostService {

    private final CarPostRepository carPostRepository;
    private final OwnerPostRepository ownerPostRepository;
    private final CarMapper carMapper;

    private final Logger logger = Logger.getLogger(CarPostServiceImpl.class.getSimpleName());

    public CarPostServiceImpl(CarPostRepository carPostRepository, CarMapper carMapper, OwnerPostRepository ownerPostRepository) {
        this.carPostRepository = carPostRepository;
        this.carMapper = carMapper;
        this.ownerPostRepository = ownerPostRepository;
    }

    @Override
    public void newPostDetails(CarPostDTO carPostDTO) {
        logger.info("Save new car for sale.");
        CarPostEntity car = this.carMapper.toCar(carPostDTO);
        this.carPostRepository.save(car);
    }

    @Override
    public List<CarPostDTO> getCarForSales() {
        logger.info("Getting all cars for sales.");
        List<CarPostEntity> entities = this.carPostRepository.findAll();
        return entities.stream().map(carMapper::toCarPostDTO).collect(Collectors.toList());
    }

    @Override
    public void changeCarSale(CarPostDTO carPostDTO, Long postId) {
        logger.info("Updating car for sale.");
        CarPostEntity carPostEntity = findById(postId);
        carPostEntity.setModel(carPostDTO.getModel());
        carPostEntity.setBrand(carPostDTO.getBrand());
        carPostEntity.setContact(carPostDTO.getContact());
        carPostEntity.setCity(carPostDTO.getCity());
        carPostEntity.setEngineVersion(carPostDTO.getEngineVersion());
        carPostEntity.setPrice(carPostDTO.getPrice());
        carPostEntity.setCreatedDate(carPostDTO.getCreatedDate());
        carPostEntity.setOwnerPostEntity(this.ownerPostRepository.findById(carPostDTO.getOwnerId()).get());
        this.carPostRepository.saveAndFlush(carPostEntity);

    }

    @Override
    public void removeCarSale(Long postId) {
        logger.info("Remove car by id: " + postId);
        this.carPostRepository.delete(findById(postId));
    }

    private CarPostEntity findById(Long carId) {
        return this.carPostRepository.findById(carId).orElseThrow(() ->
                new ResourceNotFound("Resource not found in database. Id: " + carId));
    }
}
