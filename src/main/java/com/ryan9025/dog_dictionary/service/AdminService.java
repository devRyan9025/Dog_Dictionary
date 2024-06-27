package com.ryan9025.dog_dictionary.service;

import com.ryan9025.dog_dictionary.dto.admin.AdminUserListDto;
import com.ryan9025.dog_dictionary.entity.User;
import com.ryan9025.dog_dictionary.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class AdminService {
    private final UserRepository userRepository;
    public List<AdminUserListDto> getUserList() {
        List<User> userList = userRepository.findAll();
        List<AdminUserListDto> userListDto = new ArrayList<>();
        for(User user : userList) {
            userListDto.add(AdminUserListDto.fromEntity(user));
        }
        return userListDto;
    }
    @Transactional
    public void deleteMember (Long id) {
        userRepository.deleteById(id);
    }
    @Transactional
    public void deleteSelected (List<Long> valueArr) {
        for (Long id : valueArr) {
            log.info("==={}",valueArr);
            userRepository.deleteById(id);
        }
    }
}
