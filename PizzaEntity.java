package org.ashley.repository;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PizzaEntity {
    private int id;
    private String crust;
    private String cheese;
    private String toppings;
}
