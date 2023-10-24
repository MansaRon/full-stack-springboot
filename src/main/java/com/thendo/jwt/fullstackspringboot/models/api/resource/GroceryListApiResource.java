package com.thendo.jwt.fullstackspringboot.models.api.resource;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.thendo.jwt.fullstackspringboot.models.GlobalApiResponse;
import com.thendo.jwt.fullstackspringboot.models.dto.GroceryDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Getter
@Setter
@ToString
@SuperBuilder
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GroceryListApiResource extends GlobalApiResponse {
    private List<GroceryDTO> data;
}
