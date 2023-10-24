package com.thendo.jwt.fullstackspringboot.models.dto;

import lombok.Builder;

@Builder
public record SignUpDTO(String firstName, String lastName, String email, String login, char[] password) {
}
