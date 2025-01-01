package com.javaweb.controller;

import com.javaweb.dto.ContractDTO;
import com.javaweb.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/hopdong")
public class ContractController {

    @Autowired
    private ContractService contractService;

    @GetMapping
    public String listContracts(Model model) {
        List<ContractDTO> contracts = contractService.findAll();
        model.addAttribute("listContracts", contracts);
        return "index3_qlhd";
    }

    @PostMapping("/create")
    public String createContract(@ModelAttribute ContractDTO contractDTO) {
        contractService.save(contractDTO);
        return "redirect:/hopdong";
    }

    @PostMapping("/update")
    public String updateContract(@ModelAttribute ContractDTO contractDTO) {
        contractService.update(contractDTO);
        return "redirect:/quanlyhopdong";
    }

    @GetMapping("/delete/{id}")
    public String deleteContract(@PathVariable Long id) {
        contractService.deleteById(id);
        return "redirect:/quanlyhopdong";
    }

    @GetMapping("/search")
    public String searchContracts(@RequestParam(required = false) String contractCode,
                                  @RequestParam(required = false) String status,
                                  @RequestParam(required = false) String startDate,
                                  Model model) {
        List<ContractDTO> contracts = contractService.searchContracts(contractCode, status, startDate);
        model.addAttribute("listContracts", contracts);
        return "index3_qlhd";
    }
}
