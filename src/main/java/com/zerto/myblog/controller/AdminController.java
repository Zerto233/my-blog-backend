package com.zerto.myblog.controller;

import com.zerto.myblog.dto.LoginRequest;
import com.zerto.myblog.dto.LoginResponse;
import com.zerto.myblog.dto.Result;
import com.zerto.myblog.service.AdminService;
import com.zerto.myblog.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private JwtUtils jwtUtils;

    @PostMapping("/login")
    public Result<LoginResponse> login(@RequestBody LoginRequest request) {
        boolean valid = adminService.validateLogin(request.getUsername(), request.getPassword());
        if (!valid) {
            return Result.error("用户名或密码错误");
        }

        String token = jwtUtils.generateToken(request.getUsername());

        LoginResponse response = new LoginResponse();
        response.setToken(token);
        response.setUsername(request.getUsername());

        return Result.success(response);
    }
}