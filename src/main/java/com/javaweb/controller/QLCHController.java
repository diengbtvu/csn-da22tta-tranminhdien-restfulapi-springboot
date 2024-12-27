package com.javaweb.controller;

import com.javaweb.dto.ApartmentDTO;
import com.javaweb.request.ApartmentSearchRequest;
import com.javaweb.service.ApartmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller(value = "qlchController")
public class QLCHController {
    private final ApartmentService apartmentService;

    public QLCHController(ApartmentService apartmentService) {
        this.apartmentService = apartmentService;
    }

    @RequestMapping(value = "/timcanho", method = RequestMethod.GET)
        public ResponseEntity<List<ApartmentDTO>> homePage(ApartmentSearchRequest buildingSearchRequest, HttpServletRequest request) {
            List<ApartmentDTO> apartments = apartmentService.findAll();
            return ResponseEntity.ok(apartments);
        }



}
