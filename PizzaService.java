package org.ashley.service;

import org.ashley.dto.PizzaDTO;
import org.ashley.repository.PizzaEntity;
import org.ashley.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PizzaService {
    private PizzaRepository repository;

    @Autowired
    public PizzaService(PizzaRepository r) {
        this.repository = r;
    }

    public List<PizzaDTO> getAllPizzas() {
        List<PizzaEntity> entities = repository.getAllPizzas();
        List<PizzaDTO> retVal = new ArrayList<>();
        for (PizzaEntity c: entities) {
            PizzaDTO crosswordDTO = new PizzaDTO(c.getId(), c.getCrust(), c.getCheese(), c.getToppings());
            retVal.add(crosswordDTO);
        }
        return retVal;
    }

    public PizzaDTO getPizzaById(int id) {
        PizzaEntity entity = repository.getPizzaById(id);
        return new PizzaDTO(entity.getId(), entity.getCrust(), entity.getCheese(), entity.getToppings());
    }

    public PizzaDTO createNewPizza(PizzaDTO pizzaDTO) {
        repository.createNewPizza(pizzaDTO);
        return pizzaDTO;
    }
}
