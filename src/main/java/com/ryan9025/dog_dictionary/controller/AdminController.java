package com.ryan9025.dog_dictionary.controller;

import com.ryan9025.dog_dictionary.dto.admin.AdminUserListDto;
import com.ryan9025.dog_dictionary.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
@Controller
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminController {
    private final AdminService adminService;
    @GetMapping("/userList")
    public String userList(Model model) {
        List<AdminUserListDto> userList = adminService.getUserList();
        model.addAttribute("userList",userList);
        return "/admin/userList";
    }
}
