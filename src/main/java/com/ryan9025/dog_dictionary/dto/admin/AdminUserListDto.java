package com.ryan9025.dog_dictionary.dto.admin;

import com.ryan9025.dog_dictionary.constant.DogSize;
import com.ryan9025.dog_dictionary.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AdminUserListDto {
    private Long id;
    private String email;
    private String nickname;
    private String region;
    private DogSize dogSize;

    public static AdminUserListDto fromEntity(User user) {
        return AdminUserListDto.builder()
                .id(user.getId())
                .email(user.getEmail())
                .nickname(user.getNickname())
                .region(user.getRegion())
                .dogSize(user.getSize())
                .build();
    }
}
