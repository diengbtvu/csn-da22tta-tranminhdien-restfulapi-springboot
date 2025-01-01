package com.javaweb.service;

import com.javaweb.dto.ContractDTO;

import java.util.List;
import java.util.Optional;

public interface ContractService {
    List<ContractDTO> findAll();
    Optional<ContractDTO> findById(Long id);
    void save(ContractDTO contractDTO);
    void saveAndFlush(ContractDTO contractDTO);
    void deleteById(Long id);
    void update(ContractDTO contractDTO);
    List<ContractDTO> searchContracts(String contractCode, String status, String startDate);
}
