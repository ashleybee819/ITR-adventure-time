package org.ashley.controller;

import org.ashley.dto.PizzaDTO;
import org.ashley.service.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pizza")
public class PizzaController {
    private PizzaService service;

    @Autowired
    public PizzaController(PizzaService s) {
        this.service = s;
    }

    @GetMapping(produces = "application/json")
    public ResponseEntity getAllPizzas() {
        return ResponseEntity.ok(service.getAllPizzas());
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity getPizzaById(@PathVariable int id) {
        return ResponseEntity.ok(service.getPizzaById(id));
    }

    @PostMapping(consumes = "application/json")
    public ResponseEntity createNewPizza(@RequestBody PizzaDTO pizzaDTO) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.createNewPizza(pizzaDTO));
    }
}
