package com.javaweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class TestController {

    @GetMapping("/admin")
    public String test() {
        return "admin/index";
    }
}
