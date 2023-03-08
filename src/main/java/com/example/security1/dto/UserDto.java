package com.example.security1.dto;

import com.example.security1.model.User;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
public class UserDto {

    private int id;

    private String username;

    private String password;

    private String email;

    private String role;  // ROLE_USER, ROLE_ADMIN

    private Timestamp createDate;

    @Builder
    public UserDto(int id, String username, String password, String email, String role, Timestamp createDate) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
        this.createDate = createDate;
    }

    public User toEntity(UserDto dto) {
        return new User(dto);
    }

}
