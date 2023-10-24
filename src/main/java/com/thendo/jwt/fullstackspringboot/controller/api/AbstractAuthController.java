package com.thendo.jwt.fullstackspringboot.controller.api;

import com.thendo.jwt.fullstackspringboot.models.GlobalApiErrorResponse;
import com.thendo.jwt.fullstackspringboot.models.api.resource.UserApiSignUpResource;
import com.thendo.jwt.fullstackspringboot.models.dto.CredentialsDTO;
import com.thendo.jwt.fullstackspringboot.models.dto.SignUpDTO;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

public interface AbstractAuthController {

    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "User successfully registered",
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = UserApiSignUpResource.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid request or malformed request",
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = GlobalApiErrorResponse.class))}),
            @ApiResponse(responseCode = "401", description = "Not authorised to access resource",
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = GlobalApiErrorResponse.class))}),
            @ApiResponse(responseCode = "403", description = "Authorisation invalid",
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = GlobalApiErrorResponse.class))}),
            @ApiResponse(responseCode = "404", description = "Resource not found",
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = GlobalApiErrorResponse.class))}),
            @ApiResponse(responseCode = "409", description = "Request could not be completed",
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = GlobalApiErrorResponse.class))}),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = GlobalApiErrorResponse.class))}),
            @ApiResponse(responseCode = "408", description = "Time error",
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = GlobalApiErrorResponse.class))}),
            @ApiResponse(responseCode = "503", description = "Cannot handle request due to maintenance/overload",
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = GlobalApiErrorResponse.class))}),
            @ApiResponse(responseCode = "504", description = "Proxy timeout failure",
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = GlobalApiErrorResponse.class))})
    })
    public ResponseEntity<UserApiSignUpResource> register(@RequestBody SignUpDTO signUpDTO);

    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Successfully logged in.",
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = UserApiSignUpResource.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid request or malformed request",
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = GlobalApiErrorResponse.class))}),
            @ApiResponse(responseCode = "401", description = "Not authorised to access resource",
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = GlobalApiErrorResponse.class))}),
            @ApiResponse(responseCode = "403", description = "Authorisation invalid",
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = GlobalApiErrorResponse.class))}),
            @ApiResponse(responseCode = "404", description = "Resource not found",
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = GlobalApiErrorResponse.class))}),
            @ApiResponse(responseCode = "409", description = "Request could not be completed",
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = GlobalApiErrorResponse.class))}),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = GlobalApiErrorResponse.class))}),
            @ApiResponse(responseCode = "408", description = "Time error",
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = GlobalApiErrorResponse.class))}),
            @ApiResponse(responseCode = "503", description = "Cannot handle request due to maintenance/overload",
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = GlobalApiErrorResponse.class))}),
            @ApiResponse(responseCode = "504", description = "Proxy timeout failure",
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = GlobalApiErrorResponse.class))})
    })
    public ResponseEntity<UserApiSignUpResource> login(@RequestBody CredentialsDTO credentialsDTO);

}
