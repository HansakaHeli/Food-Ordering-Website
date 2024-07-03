package com.heli.request;

import lombok.Data;

@Data
public class IngredientRequest {

    private String name;
    private int categoryId;
    private int restaurantid;

}
