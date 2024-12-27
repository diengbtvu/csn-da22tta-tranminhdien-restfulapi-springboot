package com.javaweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashBoadController {

    @GetMapping("/")
    public String index() {
        return "index";
    }
    @GetMapping("/quanlycanho")
    public String indexqlch() {
        return "index2_qlch";
    }
    @GetMapping("/quanlykhachhang")
    public String indexqlkh() {
        return "index4_qlkh";
    }
    @GetMapping("/quanlythietbi")
    public String indexqltb() {
        return "index5_qltb";
    }
    @GetMapping("/quanlyhopdong")
    public String indexqlhd() {
        return "index3_qlhd";
    }

}