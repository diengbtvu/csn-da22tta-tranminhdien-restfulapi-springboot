
package com.javaweb.service;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class DashboardService {

    public List<Integer> getRevenueData() {
        // Truy vấn database rồi trả về
        return Arrays.asList(450, 480, 460, 520, 580, 550);
    }
}