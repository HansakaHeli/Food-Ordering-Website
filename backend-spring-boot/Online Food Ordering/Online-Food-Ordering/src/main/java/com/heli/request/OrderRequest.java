package com.heli.request;

import com.heli.model.Address;
import lombok.Data;

@Data
public class OrderRequest {

    private int restaurantId;
    private Address deliveryAddress;

}
