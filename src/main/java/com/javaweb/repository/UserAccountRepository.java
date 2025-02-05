package com.javaweb.repository;

import com.javaweb.repository.entity.UserAccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserAccountRepository extends JpaRepository<UserAccountEntity, Long> {
    List<UserAccountEntity> findAll();
    Optional<UserAccountEntity> findById(Long id);
    UserAccountEntity save(UserAccountEntity entity);
    UserAccountEntity saveAndFlush(UserAccountEntity entity);
    void deleteById(Long id);
    UserAccountEntity findByuserName(String username);
    Boolean existsByUserName(String userName);
    Optional<UserAccountEntity> findByUserName(String userName);
}