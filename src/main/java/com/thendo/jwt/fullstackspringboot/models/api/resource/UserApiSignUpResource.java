package com.thendo.jwt.fullstackspringboot.models.api.resource;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.thendo.jwt.fullstackspringboot.models.GlobalApiResponse;
import com.thendo.jwt.fullstackspringboot.models.dto.UserDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@ToString
@SuperBuilder
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserApiSignUpResource extends GlobalApiResponse {
    private UserDTO data;
}
