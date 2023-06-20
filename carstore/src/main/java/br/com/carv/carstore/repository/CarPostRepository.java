package br.com.carv.carstore.repository;

import br.com.carv.carstore.entity.CarPostEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarPostRepository extends JpaRepository<CarPostEntity, Long> {
}
