package com.javaweb.controller;
import com.javaweb.dto.ApartmentDTO;
import com.javaweb.dto.ContractDTO;
import com.javaweb.service.ApartmentService;
import com.javaweb.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class ContractController {
    @Autowired
    private ContractService contractService;
    @Autowired
    private ApartmentService apartmentService;

    @PostMapping("/fe/contract")
    public ResponseEntity<Void> createContract(@RequestBody ContractDTO contractDTO) {
        contractService.saveAndFlush(contractDTO);
        ApartmentDTO apartmentDTO = apartmentService.getApartmentById(contractDTO.getApartmentId());
        apartmentDTO.setRented(true);
        apartmentService.updateApartment(apartmentDTO);
        return ResponseEntity.ok().build();
    }

}
