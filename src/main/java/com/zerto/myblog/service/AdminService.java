package com.zerto.myblog.service;

import com.zerto.myblog.entity.Admin;
import com.zerto.myblog.mapper.AdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @Autowired
    private AdminMapper adminMapper;

    public Admin findByUsername(String username) {
        return adminMapper.findByUsername(username);
    }

    public boolean validateLogin(String username, String password) {
        Admin admin = adminMapper.findByUsername(username);
        if (admin == null) {
            return false;
        }
        // 暂用明文对比（后续可改为 BCrypt 加密）
        return admin.getPassword().equals(password);
    }
}