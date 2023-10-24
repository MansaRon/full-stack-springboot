package com.thendo.jwt.fullstackspringboot.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Data
@Builder
@Table(name = "app_person")
public class User {

    @jakarta.persistence.Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank
    @Column(name = "first_name", nullable = false)
    private String firstName;

    @NotBlank
    @Column(name = "last_name", nullable = false)
    private String lastName;

    @NotBlank
    @Column(name = "login", unique = true)
    @Email(regexp = "^(.+)@(\\S+)$")
    private String login;

    @NotBlank
    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "roles")
    private Set<String> roles;

    public void addRoles(String... assignRole) {
        if (roles == null) roles = new HashSet<>();
        roles.addAll(Arrays.asList(assignRole));
    }

    public void removeRoles(String... removeRoles) {
        if (roles == null) return;
        Arrays.asList(removeRoles).forEach(roles::remove);
    }

}
