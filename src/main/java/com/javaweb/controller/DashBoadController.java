package com.javaweb.controller;

import com.javaweb.dto.ApartmentDTO;
import com.javaweb.dto.ContractDTO;
import com.javaweb.dto.ContractDTOResp;
import com.javaweb.dto.CustomerDTO;
import com.javaweb.repository.CustomerRepository;
import com.javaweb.repository.entity.CustomerEntity;
import com.javaweb.service.ApartmentService;
import com.javaweb.service.ContractService;
import com.javaweb.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class DashBoadController {
    @Autowired
    private ApartmentService apartmentService;
    @Autowired
    private ContractService contractService;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/quanlycanho")
    public String manageApartments(final Model model) {
        List<ApartmentDTO> items = apartmentService.findAll();
        model.addAttribute("apartments", items);

        return "index2_qlch";
    }

    @GetMapping("/quanlykhachhang")
    public String manageCustomers(final Model model) {
        List<CustomerDTO> items = customerService.findAll();
        model.addAttribute("customers", items);
        return "index4_qlkh";
    }

    @GetMapping("/quanlythietbi")
    public String manageDevices() {
        return "index5_qltb";
    }


    @GetMapping("/quanlyhopdong")
    public String manageContracts(final Model model) {
        // Lay ra tat ca can ho rented = 0

        List<ContractDTO> items = contractService.findAll();
        model.addAttribute("listContracts", items);
        List<ApartmentDTO> aprtments = apartmentService.findAll().stream().filter(apartmentDTO -> !apartmentDTO.getRented()).collect(Collectors.toList());
        model.addAttribute("option", aprtments);
        List<CustomerDTO> customers = customerService.findAll();
        model.addAttribute("optionCustomer", customers);

        return "index3_qlhd";
    }
}