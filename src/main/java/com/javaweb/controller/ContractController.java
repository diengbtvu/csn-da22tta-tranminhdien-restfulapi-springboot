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
    @DeleteMapping("/fe/contract/{id}")
    public ResponseEntity<Void> deleteContract(@PathVariable Long id) {
        ContractDTO contractDTO = contractService.findById(id).orElse(null);
        if (contractDTO == null) {
            return ResponseEntity.notFound().build();
        }
        ApartmentDTO apartmentDTO = apartmentService.getApartmentById(contractDTO.getApartmentId());
        apartmentDTO.setRented(false);
        apartmentService.updateApartment(apartmentDTO);
        contractService.deleteById(id);
        return ResponseEntity.ok().build();
    }
    @PutMapping("/fe/contract/{id}")
    public ResponseEntity<Void> updateContract(@PathVariable Long id, @RequestBody ContractDTO contractDTO) {
        Long canhogocid = contractService.findById(id).get().getApartmentId();
        Long canhomoiid = contractDTO.getApartmentId();
        if (canhogocid != canhomoiid) {
            ApartmentDTO apartmentDTO = apartmentService.getApartmentById(canhogocid);
            apartmentDTO.setRented(false);
            apartmentService.updateApartment(apartmentDTO);
            apartmentDTO = apartmentService.getApartmentById(canhomoiid);
            apartmentDTO.setRented(true);
            apartmentService.updateApartment(apartmentDTO);
        }
        contractService.update(contractDTO);
        return ResponseEntity.ok().build();
    }



}
