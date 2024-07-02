package com.heli.request;

import com.heli.model.Category;
import com.heli.model.IngredientsItem;
import lombok.Data;

import java.util.List;

@Data
public class CreateFoodRequest {

    private String name;
    private String description;
    private Long price;

    private Category category;
    private List<String> images;

    private int restaurantId;
    private boolean vegetarin;
    private boolean seasional;
    private List<IngredientsItem> ingredients;

}
