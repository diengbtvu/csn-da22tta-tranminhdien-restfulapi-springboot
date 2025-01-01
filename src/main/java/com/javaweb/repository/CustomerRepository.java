package com.javaweb.repository;

import com.javaweb.repository.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository extends JpaRepository<CustomerEntity,Long> {

    List<CustomerEntity> findAll();
    Optional<CustomerEntity> findById(Long id);
    <S extends CustomerEntity> S save(S entity);
    // Update the entity and flush changes instantly
    <S extends CustomerEntity> S saveAndFlush(S entity);
    void deleteById(Long id);

    @Query("SELECT c.name FROM CustomerEntity c WHERE c.id = :id")
    String findNameById(@Param("id") Long id);
}
