package com.thendo.jwt.fullstackspringboot.mappers;

import com.thendo.jwt.fullstackspringboot.models.dto.GroceryCreateDTO;
import com.thendo.jwt.fullstackspringboot.models.dto.GroceryDTO;
import com.thendo.jwt.fullstackspringboot.entities.Grocery;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GroceryMapper {

    GroceryDTO toGroceryDTO(Grocery grocery);

    GroceryCreateDTO createGroceryItem(Grocery grocery);

}
