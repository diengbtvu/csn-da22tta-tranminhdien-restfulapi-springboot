package com.javaweb.repository;

import com.javaweb.repository.entity.DistrictEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DistrictRepository extends JpaRepository<DistrictEntity, Long> {
    List<DistrictEntity> findAll();
    Optional<DistrictEntity> findById(Long id);
    DistrictEntity save(DistrictEntity entity);
    DistrictEntity saveAndFlush(DistrictEntity entity);
    void deleteById(Long id);
    DistrictEntity findByName(String name);
    Boolean existsByName(String name);
}
