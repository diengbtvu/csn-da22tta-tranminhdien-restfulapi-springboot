package com.javaweb.service.impl;

import com.javaweb.converter.ContractConverter;
import com.javaweb.dto.ContractDTO;
import com.javaweb.repository.ApartmentRepository;
import com.javaweb.repository.ContractRepository;
import com.javaweb.repository.CustomerRepository;
import com.javaweb.repository.entity.ApartmentEntity;
import com.javaweb.repository.entity.ContractEntity;
import com.javaweb.repository.entity.CustomerEntity;
import com.javaweb.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ContractServiceImpl implements ContractService {

    @Autowired
    private ContractRepository contractRepository;

    @Autowired
    private ContractConverter contractConverter;
    @Autowired
    private ApartmentRepository apartmentRepository;
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<ContractDTO> findAll() {
        List<ContractEntity> entities = contractRepository.findAll();
        return entities.stream()
                .map(contractConverter::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<ContractDTO> findById(Long id) {
        Optional<ContractEntity> entity = contractRepository.findById(id);
        return entity.map(contractConverter::convertToDTO);
    }


    @Override
    public void saveAndFlush(ContractDTO contractDTO) {
        ApartmentEntity apartmentEntity = new ApartmentEntity();
        apartmentEntity.setId(contractDTO.getApartmentId());
        ContractEntity contractEntity = contractConverter.convertToEntity(contractDTO);
        contractEntity.setApartment(apartmentEntity);
        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setId(contractDTO.getCustomerId());
        contractEntity.setCustomer(customerEntity);
        contractRepository.saveAndFlush(contractEntity);
    }

    @Override
    public void deleteById(Long id) {
        contractRepository.deleteById(id);
    }

    @Override
    public void update(ContractDTO contractDTO) {
        ContractEntity contractEntity = contractConverter.convertToEntity(contractDTO);
        ApartmentEntity apartment = apartmentRepository.findById(contractDTO.getApartmentId()).orElse(null);
        contractEntity.setApartment(apartment);
        CustomerEntity customer = customerRepository.findById(contractDTO.getCustomerId()).orElse(null);
        contractEntity.setCustomer(customer);
        contractRepository.save(contractEntity);

    }

    @Override
    public List<ContractDTO> searchContracts(String status) {
        List<ContractDTO> contractDTOS = findAll();

        if(status == null || status.isEmpty()) {
            return contractDTOS;
        }
        return contractDTOS.stream()
                .filter(contractDTO -> contractDTO.getPaymentStatus().equals(status))
                .collect(Collectors.toList());
    }
}