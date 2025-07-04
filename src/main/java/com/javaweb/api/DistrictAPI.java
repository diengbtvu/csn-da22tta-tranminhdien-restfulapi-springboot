package com.javaweb.api;

import com.javaweb.dto.DistrictDTO;
import com.javaweb.repository.DistrictRepository;
import com.javaweb.repository.entity.DistrictEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/districts")
public class DistrictAPI {
    @Autowired
    private DistrictRepository districtRepository;

    @PostMapping
    public ResponseEntity<?> createDistrict(@RequestBody DistrictDTO districtDTO) {
        if (districtRepository.existsByName(districtDTO.getName())) {
            return ResponseEntity.status(409).body("Tên quận/huyện đã tồn tại");
        }
        DistrictEntity districtEntity = new DistrictEntity();
        districtEntity.setName(districtDTO.getName());
        districtEntity.setCode(districtDTO.getCode());
        districtEntity.setCity(districtDTO.getCity());
        districtEntity.setRegion(districtDTO.getRegion());
        districtRepository.save(districtEntity);
        return ResponseEntity.ok().build();
    }
}
