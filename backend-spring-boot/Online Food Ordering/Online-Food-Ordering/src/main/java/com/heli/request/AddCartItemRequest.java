package com.heli.request;

import lombok.Data;

import java.util.List;

@Data
public class AddCartItemRequest {

    private int foodId;
    private int quantity;
    private List<String> ingredients;
}
