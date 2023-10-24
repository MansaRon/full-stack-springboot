package com.thendo.jwt.fullstackspringboot.controller.api;

import com.thendo.jwt.fullstackspringboot.entities.Grocery;
import com.thendo.jwt.fullstackspringboot.models.GlobalApiErrorResponse;
import com.thendo.jwt.fullstackspringboot.models.GlobalApiResponse;
import com.thendo.jwt.fullstackspringboot.models.api.resource.GroceryApiResource;
import com.thendo.jwt.fullstackspringboot.models.api.resource.GroceryDeleteApiResource;
import com.thendo.jwt.fullstackspringboot.models.api.resource.GroceryListApiResource;
import com.thendo.jwt.fullstackspringboot.models.api.resource.UserApiSignUpResource;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Date;

public interface AbstractGroceryController {

    @Operation(tags = "Grocery Items", summary = "Grocery Items - Adding the grocery items")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Grocery Added",
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = GroceryApiResource.class))}),
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
    public ResponseEntity<GroceryApiResource> addGrocery(@RequestBody Grocery grocery);

    @Operation(tags = "Grocery Items", summary = "Grocery Items - Editing items from the existing list")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Grocery Edited",
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = GroceryApiResource.class))}),
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
    public ResponseEntity<GroceryApiResource> editGrocery(@PathVariable long id, @RequestBody Grocery grocery);

    @Operation(tags = "Grocery Items", summary = "Grocery Items - Retrieving items from the existing list")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Grocery Retrieved",
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = GroceryApiResource.class))}),
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
    public ResponseEntity<GroceryListApiResource> getGroceries();

    @Operation(tags = "Grocery Items", summary = "Grocery Items - Deleting item from the existing list by ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Grocery Retrieved",
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = GroceryApiResource.class))}),
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
    public ResponseEntity<GroceryDeleteApiResource> deleteItemById(@PathVariable long id);

    @Operation(tags = "Grocery Items", summary = "Grocery Items - Filter items via price")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Items filtered",
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = GroceryListApiResource.class))}),
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
    public ResponseEntity<GroceryListApiResource> filterByPrice(@PathVariable Double min, @PathVariable Double max);

    @Operation(tags = "Grocery Items", summary = "Grocery Items - Filter items via category")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Items filtered",
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = GroceryListApiResource.class))}),
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
    public ResponseEntity<GroceryListApiResource> filterByCategory(@PathVariable String category);

    @Operation(tags = "Grocery Items", summary = "Grocery Items - Filter items via date")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Items filtered",
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = GroceryListApiResource.class))}),
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
    public ResponseEntity<GroceryListApiResource> filterByExpirationDate(@PathVariable Date date);
}
