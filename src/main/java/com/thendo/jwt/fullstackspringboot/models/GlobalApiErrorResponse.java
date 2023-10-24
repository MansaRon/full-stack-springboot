package com.thendo.jwt.fullstackspringboot.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.time.Instant;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@SuperBuilder
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GlobalApiErrorResponse {

    private String status;
    private Integer statusCode;
    private String errorCode;
    private String message;
    private LocalDateTime timestamp;
    private String path;

}
