package com.thendo.jwt.fullstackspringboot.controller;

import com.thendo.jwt.fullstackspringboot.controller.api.AbstractGroceryController;
import com.thendo.jwt.fullstackspringboot.entities.Grocery;
import com.thendo.jwt.fullstackspringboot.models.api.resource.GroceryApiResource;
import com.thendo.jwt.fullstackspringboot.models.api.resource.GroceryDeleteApiResource;
import com.thendo.jwt.fullstackspringboot.models.api.resource.GroceryListApiResource;
import com.thendo.jwt.fullstackspringboot.service.GroceryService;
import com.thendo.jwt.fullstackspringboot.service.implementation.GroceryServiceImpl;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.Date;

@RestController
@RequiredArgsConstructor
public class GroceryController implements AbstractGroceryController {

    private final GroceryService groceryServiceImpl;

    @Override
    @PostMapping("/add")
    @SecurityRequirement(name = "Bearer Authentication")
    public ResponseEntity<GroceryApiResource> addGrocery(@RequestBody @Valid Grocery grocery) {
        return ResponseEntity.ok(
                GroceryApiResource.builder()
                        .timestamp(Instant.now())
                        .data(groceryServiceImpl.addGrocery(grocery))
                        .statusCode(HttpStatus.OK.value())
                        .status("Grocery Item added")
                        .build()
        );
    }

    @Override
    @PutMapping("/edit/{id}")
    @SecurityRequirement(name = "Bearer Authentication")
    public ResponseEntity<GroceryApiResource> editGrocery(@PathVariable long id, @RequestBody @Valid Grocery grocery) {
        return ResponseEntity.ok(
                GroceryApiResource.builder()
                        .timestamp(Instant.now())
                        .data(groceryServiceImpl.editGroceryDTO(id, grocery))
                        .statusCode(HttpStatus.OK.value())
                        .status("Grocery Item edited")
                        .build()
        );
    }

    @Override
    @GetMapping("/get/all")
    @SecurityRequirement(name = "Bearer Authentication")
    public ResponseEntity<GroceryListApiResource> getGroceries() {
        return ResponseEntity.ok(
                GroceryListApiResource.builder()
                        .timestamp(Instant.now())
                        .data(groceryServiceImpl.getGroceries())
                        .statusCode(HttpStatus.OK.value())
                        .status("Groceries retrieved")
                        .build()
        );
    }

    @Override
    @DeleteMapping("/delete/{id}")
    @SecurityRequirement(name = "Bearer Authentication")
    public ResponseEntity<GroceryDeleteApiResource> deleteItemById(@PathVariable long id) {
        groceryServiceImpl.deleteGroceryById(id);
        return ResponseEntity.ok(
                GroceryDeleteApiResource.builder()
                        .timestamp(Instant.now())
                        .data("")
                        .statusCode(HttpStatus.OK.value())
                        .status("Items deleted")
                        .build()
        );
    }

    @Override
    @GetMapping("/filter/prices/{min}/{max}")
    @SecurityRequirement(name = "Bearer Authentication")
    public ResponseEntity<GroceryListApiResource> filterByPrice(@PathVariable Double min, @PathVariable Double max) {
        return ResponseEntity.ok(
                GroceryListApiResource.builder()
                        .timestamp(Instant.now())
                        .data(groceryServiceImpl.getGroceryWithPriceFilter(min, max))
                        .statusCode(HttpStatus.OK.value())
                        .status("Items filtered by price")
                        .build()
        );
    }

    @Override
    @GetMapping("/filter/category/{category}")
    @SecurityRequirement(name = "Bearer Authentication")
    public ResponseEntity<GroceryListApiResource> filterByCategory(@PathVariable String category) {
        return ResponseEntity.ok(
                  GroceryListApiResource.builder()
                          .timestamp(Instant.now())
                          .data(groceryServiceImpl.getGroceryByCategory(category))
                          .statusCode(HttpStatus.OK.value())
                          .status("Category filter by category")
                          .build()
        );
    }

    @Override
    @GetMapping("/filter/date/{date}")
    @SecurityRequirement(name = "Bearer Authentication")
    public ResponseEntity<GroceryListApiResource> filterByExpirationDate(@PathVariable Date date) {
        return ResponseEntity.ok(
                GroceryListApiResource.builder()
                        .timestamp(Instant.now())
                        .data(groceryServiceImpl.getGroceryBeforeExpDate(date))
                        .statusCode(HttpStatus.OK.value())
                        .status("Category filter by date")
                        .build()
        );
    }

    // add
//    @PostMapping("/add")
//    public ResponseEntity<ApiResponse> addGrocery(@RequestBody Grocery grocery) {
//        logger.info("builder.buildResponse(HttpStatus.CREATED.value(), \"Grocery item added\", groceryService.addGrocery(grocery))");
//        return builder.buildResponse(HttpStatus.CREATED.value(), "Grocery item added", groceryService.addGrocery(grocery));
//    }

    // edit
//    @PutMapping("/edit/{id}")
//    public ResponseEntity<ApiResponse> editGrocery(@PathVariable long id, @RequestBody Grocery grocery) {
//        logger.info("builder.buildResponse(HttpStatus.OK.value(), \"Grocery edited.\", groceryService.editGroceryDTO(id, grocery))");
//        return builder.buildResponse(HttpStatus.OK.value(), "Grocery edited.", groceryService.editGroceryDTO(id, grocery));
//    }

    // get all
//    @GetMapping("/get/all")
//    public ResponseEntity<ApiResponse> getGroceries() {
//        logger.info("builder.buildResponse(HttpStatus.OK.value(), \"Groceries retrieved.\", groceryService.getGroceries())");
//        return builder.buildResponse(HttpStatus.OK.value(), "Groceries retrieved.", groceryService.getGroceries());
//    }

    // delete all
//    @DeleteMapping("/delete/all")
//    public ResponseEntity<ApiResponse> deleteAll() {
//        logger.info("builder.buildResponse(HttpStatus.OK.value(), \"Grocery deleted\")");
//        groceryService.deleteAllGroceries();
//        return builder.buildResponse(HttpStatus.OK.value(), "Grocery deleted");
//    }

    // delete one
//    @DeleteMapping("/delete/{id}")
//    public ResponseEntity<ApiResponse> deleteByID(@PathVariable long id) {
//        logger.info("public ResponseEntity<String> deleteByID(@PathVariable long id)");
//        groceryService.deleteGroceryById(id);
//        return builder.buildResponse(HttpStatus.OK.value(), "All groceries deleted");
//    }

    // filter with price
//    public ResponseEntity<ApiResponse> filterByPrice(@PathVariable Double min, @PathVariable Double max) {
//        logger.info("public ResponseEntity<ApiResponse> filterByPrice(@PathVariable Double min, @PathVariable Double max)");
//        return builder.buildResponse(HttpStatus.CONTINUE.value(), "Grocery items filtered by price", groceryService.getGroceryWithPriceFilter(min, max));
//    }

    // filter with category
//    @GetMapping("/filter/category/{category}")
//    public ResponseEntity<ApiResponse> filterByCategory(@PathVariable String category) {
//        logger.info("public ResponseEntity<ApiResponse> filterByCategory(@PathVariable String category)");
//        return builder.buildResponse(HttpStatus.CONTINUE.value(), "Grocery items filtered by category", groceryService.getGroceryByCategory(category));
//    }

    // filter with date
//    @GetMapping("/filter/date/{date}")
//    public ResponseEntity<ApiResponse> filterByExpirationDate(@PathVariable Date date) {
//        logger.info("public ResponseEntity<ApiResponse> filterByExpirationDate(@PathVariable Date date)");
//        return builder.buildResponse(HttpStatus.CONTINUE.value(), "Grocery items filtered by date", groceryService.getGroceryBeforeExpDate(date));
//    }

}
