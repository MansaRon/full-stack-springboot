package com.thendo.jwt.fullstackspringboot.service;

import com.thendo.jwt.fullstackspringboot.entities.Grocery;
import com.thendo.jwt.fullstackspringboot.models.dto.GroceryDTO;
import com.thendo.jwt.fullstackspringboot.models.dto.GroceryList;

import java.util.Date;
import java.util.List;

public interface GroceryService {
    List<GroceryDTO> getGroceries();

    GroceryDTO addGrocery(Grocery grocery);

    GroceryDTO editGroceryDTO(Long id, Grocery grocery);

    void deleteGroceryById(Long id);

    List<GroceryDTO> getGroceryWithPriceFilter(Double min, Double max);

    List<GroceryDTO> getGroceryByCategory(String category);

    List<GroceryDTO> getGroceryBeforeExpDate(Date date);

    GroceryDTO convertToGroceryDTO(Grocery grocery);

    boolean checkCategory(GroceryList groceryList);
}
