package com.thendo.jwt.fullstackspringboot.models.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private String login;
    private String token;
    private Set<String> roles;

}
