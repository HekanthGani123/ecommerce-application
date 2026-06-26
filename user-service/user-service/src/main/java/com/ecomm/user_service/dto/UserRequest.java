package com.ecomm.user_service.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserRequest {

    @NotBlank(message = "Name is Required")
    private String name;

    @Email(message = "Email should valid")
    private String email;

    @NotBlank(message = "Password is compulsory")
    private String password;
}
