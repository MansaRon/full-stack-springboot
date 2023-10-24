package com.thendo.jwt.fullstackspringboot.service.implementation;

import com.thendo.jwt.fullstackspringboot.mappers.GroceryMapper;
import com.thendo.jwt.fullstackspringboot.models.dto.GroceryDTO;
import com.thendo.jwt.fullstackspringboot.entities.Grocery;
import com.thendo.jwt.fullstackspringboot.exceptions.GroceryException;
import com.thendo.jwt.fullstackspringboot.models.dto.GroceryList;
import com.thendo.jwt.fullstackspringboot.repository.GroceryRepository;
import com.thendo.jwt.fullstackspringboot.service.GroceryService;
import com.thendo.jwt.fullstackspringboot.util.ExecutionTimeLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GroceryServiceImpl implements GroceryService {

    @Autowired
    private final GroceryRepository groceryRepository;
    private final GroceryMapper groceryMapper;

    @ExecutionTimeLogger
    // Get all groceries
    public List<GroceryDTO> getGroceries() {
        List<Grocery> groceries = groceryRepository.findAll();

        return groceries.stream()
                .map(this::convertToGroceryDTO)
                .collect(Collectors.toList());
    }

    @ExecutionTimeLogger
    // add groceries
    public GroceryDTO addGrocery(Grocery grocery) {
        if (grocery.getExpirationDate().before(new Date())) {
            throw new GroceryException("Expiration date entered is preceeds the current date.");
        }

        if (!checkCategory(grocery.getCategory())) {
            throw new GroceryException("Category entered is not part of the list");
        }

        return groceryMapper.toGroceryDTO(groceryRepository.save(grocery));
    }

    @ExecutionTimeLogger
    // edit
    public GroceryDTO editGroceryDTO(Long id, Grocery grocery) {
        return groceryRepository.findById(id)
                .map(groceryMap -> {
                    groceryMap.setName(grocery.getName());
                    groceryMap.setAmount(grocery.getAmount());
                    return groceryMapper.toGroceryDTO(groceryRepository.save(groceryMap));
                })
                .orElse(null);
    }

    @ExecutionTimeLogger
    // delete one
    public void deleteGroceryById(Long id) {
        groceryRepository.findById(id).ifPresent(groceryRepository::delete);
    }

    // filter with price
    public List<GroceryDTO> getGroceryWithPriceFilter(Double min, Double max) {
        List<Grocery> groceries = groceryRepository.findAll();

        return groceries
                .stream()
                .map(this::convertToGroceryDTO)
                .filter(price -> price.getAmount() >= min && price.getAmount() <= max).toList();
    }

    // filter via category
    public List<GroceryDTO> getGroceryByCategory(String category) {
        List<Grocery> groceries = groceryRepository.findAll();

            return groceries
                    .stream()
                    .map(this::convertToGroceryDTO)
                    .filter(categoryFilter -> categoryFilter.equals(category)).toList();
    }

    // filtering via exp date
    public List<GroceryDTO> getGroceryBeforeExpDate(Date date) {
        List<Grocery> groceries = groceryRepository.findAll();

        return groceries
                .stream()
                .map(this::convertToGroceryDTO)
                .filter(expDate -> expDate.getExpirationDate().toInstant().isAfter(date.toInstant()))
                .toList();
    }

    public GroceryDTO convertToGroceryDTO(Grocery grocery) {
        return GroceryDTO.builder()
                .id(grocery.getId())
                .name(grocery.getName())
                .amount(grocery.getAmount())
                .category(grocery.getCategory())
                .expirationDate(grocery.getExpirationDate())
                .build();
    }

    public boolean checkCategory(GroceryList groceryList) {
        GroceryList result = null;
        for (GroceryList list : GroceryList.values()) {
            if (list.name().equals(groceryList.toString())) {
                return true;
            }
        }
        return false;
    }


}
