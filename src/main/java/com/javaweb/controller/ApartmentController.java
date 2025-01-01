package com.javaweb.controller;

import com.javaweb.dto.ApartmentDTO;
import com.javaweb.repository.entity.ApartmentEntity;
import com.javaweb.service.ApartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
@RestController
public class ApartmentController {

    @Autowired
    private ApartmentService apartmentService;

    @PostMapping("/fe/apartments")
    public void addApartment(@RequestBody ApartmentDTO apartmentDTO) {
        apartmentService.createApartment(apartmentDTO);
    }


    @DeleteMapping("/fe/apartments/{id}")
    public void deleteApartment(@PathVariable Long id) {
        apartmentService.deleteById(id);
    }

    @PutMapping("/fe/apartments/{id}")
    public void updateApartment(@PathVariable Long id, @RequestBody ApartmentDTO apartmentDTO) {
        ApartmentDTO apartment = apartmentService.findById(id).orElse(null);
        if (apartment == null) {
            throw new RuntimeException("Apartment not found");
        }
        apartmentDTO.setId(id);
        apartmentService.updateApartment(apartmentDTO);
    }
    @GetMapping("/fe/apartments/{id}")
    public ApartmentDTO getApartmentById(@PathVariable Long id) {
        return apartmentService.findById(id).orElseThrow(() -> new RuntimeException("Apartment not found"));
    }
}
