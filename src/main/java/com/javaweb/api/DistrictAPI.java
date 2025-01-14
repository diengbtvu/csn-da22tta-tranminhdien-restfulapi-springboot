package com.javaweb.api;

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
    private DistrictRepository   districtRepository;
        @PostMapping
        public ResponseEntity<Void> createDistrict(@RequestBody DistrictEntity districtEntity) {
        return districtRepository.save(districtEntity) != null ? ResponseEntity.ok().build() : ResponseEntity.badRequest().build();
    }

}
