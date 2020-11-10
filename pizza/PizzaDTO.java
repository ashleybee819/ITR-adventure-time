package org.ashley.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PizzaDTO {
    private int id;
    private String crust;
    private String cheese;
    private String toppings;
}
