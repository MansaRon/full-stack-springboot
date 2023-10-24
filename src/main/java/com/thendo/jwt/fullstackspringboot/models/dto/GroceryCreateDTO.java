package com.thendo.jwt.fullstackspringboot.models.dto;

import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Data
@Builder
@Table(name = "grocery")
public class GroceryCreateDTO {

    private String name;

    private int amount;

    private int numItems;

    private GroceryList category;

    private Date expirationDate;

    private LocalDateTime creationTimeStamp;
}
