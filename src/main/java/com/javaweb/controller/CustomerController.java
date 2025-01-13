package com.javaweb.controller;
import com.javaweb.api.AuthAPI;
import com.javaweb.api.UserAPI;
import com.javaweb.dto.*;
import com.javaweb.model.ErrorResponseDTO;
import com.javaweb.repository.UserAccountRepository;
import com.javaweb.repository.entity.UserAccountEntity;
import com.javaweb.service.ApartmentService;
import com.javaweb.service.ContractService;
import com.javaweb.service.CustomerService;
import com.javaweb.service.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class CustomerController {

    @Autowired
    private UserAccountService userAccountService;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Autowired
    private UserAccountRepository userAccountRepository;
    @Autowired
    private CustomerService customerService;

    @PostMapping("/fe/customer")
    public ResponseEntity<Object> createCustomer(@RequestBody CustomerDTORes customerDTORes) {
        // Kiểm tra username đã tồn tại chưa
        if (userAccountRepository.existsByUserName(customerDTORes.getUserName())) {
            return ResponseEntity
                    .status(HttpStatus.CONFLICT)
                    .body(new ErrorResponseDTO("Username đã tồn tại"));
        }

        try {
            UserAccountEntity userAccountEntity = new UserAccountEntity();
            userAccountEntity.setUserName(customerDTORes.getUserName());
            userAccountEntity.setPassword(passwordEncoder.encode(customerDTORes.getPassword()));
            userAccountEntity.setRole("TENANT");
            userAccountEntity = userAccountRepository.save(userAccountEntity);

            CustomerDTO customerDTO = new CustomerDTO();
            customerDTO.setUserAccount(userAccountEntity);
            customerDTO.setName(customerDTORes.getFullName());
            customerDTO.setPhoneNumber(customerDTORes.getPhone());
            customerDTO.setEmail(customerDTORes.getEmail());
            customerService.save(customerDTO);

            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ErrorResponseDTO("Lỗi khi tạo tài khoản"));
        }
    }

    @GetMapping("/searchCustomerByName")
    public String searchCustomers(@RequestParam(required = false) String keyword, Model model) {
        List<CustomerDTO> customers = customerService.findAll().stream().filter(customer -> {
            if (keyword.contains(customer.getName())) {
                return true;
            }
            return customer.getName().toLowerCase().contains(keyword.toLowerCase());
        }).collect(Collectors.toList());

        model.addAttribute("customers", customers);
        return "index4_qlkh"; // Tên template của bạn
    }

    @DeleteMapping("/deleteCustomer/{id}")
    public String deleteCustomer(@PathVariable Long id) {
        customerService.deleteById(id);
        UserAccountEntity userAccountEntity = userAccountRepository.findById(id).get();
        userAccountRepository.delete(userAccountEntity);

        return "index4_qlkh"; // Tên template của bạn
    }




}
