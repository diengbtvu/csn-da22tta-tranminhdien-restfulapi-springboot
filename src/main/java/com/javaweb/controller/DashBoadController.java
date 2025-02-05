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
import org.springframework.web.bind.annotation.RequestParam;

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
    public String index(final Model model) {
        List<ApartmentDTO> apartmentDTO = apartmentService.findAll();
        Integer number = apartmentDTO.size();
        model.addAttribute("numberOfApartment", number);
        List<ApartmentDTO> apartmentDTOS = apartmentService.findAll().stream().filter(apartmentDTO1 -> apartmentDTO1.getRented()).collect(Collectors.toList());
        Integer numberRented = apartmentDTOS.size();
        model.addAttribute("numberOfRented", numberRented);
        List<ContractDTO> contractDTOS = contractService.findAll();
        Integer numberContract = contractDTOS.size();
        model.addAttribute("numberOfContract", numberContract);
        List<CustomerDTO> customerDTOS = customerService.findAll();
        Integer numberCustomer = customerDTOS.size();
        model.addAttribute("numberOfCustomer", numberCustomer);

        Integer contractDangHieuLuc = contractService.findAll().stream().filter(contractDTO -> contractDTO.getPaymentStatus().equals("Đang hiệu lực")).collect(Collectors.toList()).size();
        model.addAttribute("contractDangHieuLuc", contractDangHieuLuc);
        Integer contractChuaThanhToan = contractService.findAll().stream().filter(contractDTO -> contractDTO.getPaymentStatus().equals("Chưa thanh toán")).collect(Collectors.toList()).size();
        model.addAttribute("contractChuaThanhToan", contractChuaThanhToan);
        Integer contractHetHieuLuc = contractService.findAll().stream().filter(contractDTO -> contractDTO.getPaymentStatus().equals("Hết hiệu lực")).collect(Collectors.toList()).size();
        model.addAttribute("contractHetHieuLuc", contractHetHieuLuc);
        Integer contractDaThanhToan = contractService.findAll().stream().filter(contractDTO -> contractDTO.getPaymentStatus().equals("Đã thanh toán")).collect(Collectors.toList()).size();
        model.addAttribute("contractDaThanhToan", contractDaThanhToan);

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
        List<ApartmentDTO> allAprtments = apartmentService.findAll();
        model.addAttribute("allAprtments", allAprtments);

        return "index3_qlhd";
    }

    @GetMapping("/searchContracts")
    public String searchContracts(@RequestParam("status") String status, final Model model) {
        List<ContractDTO> items = contractService.searchContracts(status);
        model.addAttribute("listContracts", items);
        List<ApartmentDTO> aprtments = apartmentService.findAll().stream().filter(apartmentDTO -> !apartmentDTO.getRented()).collect(Collectors.toList());
        model.addAttribute("option", aprtments);
        List<CustomerDTO> customers = customerService.findAll();
        model.addAttribute("optionCustomer", customers);
        List<ApartmentDTO> allAprtments = apartmentService.findAll();
        model.addAttribute("allAprtments", allAprtments);

        return "index3_qlhd";
    }
}