package com.javaweb.controller;

import com.javaweb.dto.ApartmentDTO;
import com.javaweb.repository.entity.ApartmentEntity;
import com.javaweb.service.ApartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

@RestController
public class ApartmentController {

    @Autowired
    private ApartmentService apartmentService;

    @PostMapping("/fe/apartments")
    public ResponseEntity<Void> addApartment(@RequestBody ApartmentDTO apartmentDTO) {
        apartmentService.createApartment(apartmentDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/fe/apartments/{id}")
    public ResponseEntity<Void> deleteApartment(@PathVariable Long id) {
        apartmentService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/fe/apartments/{id}")
    public ResponseEntity<Void> updateApartment(@PathVariable Long id, @RequestBody ApartmentDTO apartmentDTO) {
        ApartmentDTO apartment = apartmentService.findById(id).orElse(null);
        if (apartment == null) {
            return ResponseEntity.notFound().build();
        }
        apartmentDTO.setId(id);
        apartmentService.updateApartment(apartmentDTO);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/fe/apartments/{id}")
    public ResponseEntity<ApartmentDTO> getApartmentById(@PathVariable Long id) {
        ApartmentDTO apartment = apartmentService.findById(id).orElse(null);
        if (apartment == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(apartment);
    }
}
