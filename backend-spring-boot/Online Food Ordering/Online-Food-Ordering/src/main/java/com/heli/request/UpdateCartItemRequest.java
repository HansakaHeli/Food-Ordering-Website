package com.heli.request;

import lombok.Data;

@Data
public class UpdateCartItemRequest {

    private int cartItemId;
    private int quantity;
}
