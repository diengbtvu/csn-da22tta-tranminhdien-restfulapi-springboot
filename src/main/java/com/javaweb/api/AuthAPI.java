package com.javaweb.api;

import com.javaweb.dto.UserAccountDTO;
import com.javaweb.dto.UserLoginDTO;
import com.javaweb.dto.UserRegisterDTO;
import com.javaweb.security.JwtUtil;
import com.javaweb.service.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthAPI {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserAccountService userAccountService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserLoginDTO userLogin) {
        UserAccountDTO user = new UserAccountDTO();
        user.setUserName(userLogin.getUserName());
        user.setPassword(userLogin.getPassword());
        Map<String,String> error = new HashMap<>();
        error.put("error", "Invalid username or password");
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(user.getUserName(), user.getPassword())
            );

            String token = jwtUtil.generateToken(userLogin.getUserName());
            Map<String,String> response = new HashMap<>();
            response.put("token", token);
            return ResponseEntity.ok(response);
        } catch (BadCredentialsException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(
                    error
            );
        }


    }

    @PostMapping("/register")
    public void register(@RequestBody UserRegisterDTO user) {
        UserAccountDTO dto = new UserAccountDTO();
        dto.setUserName(user.getUserName());
        dto.setPassword(user.getPassword());
        dto.setRole(user.getRole());

        dto.setPassword(passwordEncoder.encode(dto.getPassword()));
        userAccountService.save(dto);
    }
}