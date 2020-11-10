package org.ashley.repository;

import org.ashley.dto.PizzaDTO;
import org.ashley.service.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class PizzaRepository {
    private NamedParameterJdbcTemplate template;

    @Autowired
    public PizzaRepository(NamedParameterJdbcTemplate t) {
        this.template = t;
    }

    public List<PizzaEntity> getAllPizzas() {
        String query = "SELECT * FROM pizza";
        Map<String, Object> params = new HashMap<>();
        RowMapper<PizzaEntity> rowMapper = new BeanPropertyRowMapper<>(PizzaEntity.class);
        return template.query(query, params, rowMapper);
    }

    public PizzaEntity getPizzaById(int id) {
        String query = "SELECT * FROM pizza WHERE id = :var";
        Map<String, Object> params = new HashMap<>();
        params.put("var", id);
        RowMapper<PizzaEntity> rowMapper = new BeanPropertyRowMapper<>(PizzaEntity.class);
        return template.queryForObject(query, params, rowMapper);
    }

    public void createNewPizza(PizzaDTO pizzaDTO) {
        String query = "INSERT INTO pizza (crust, cheese, toppings) VALUES (:crust, :cheese, :toppings)";
        Map<String, Object> params = new HashMap<>();
        params.put("crust", pizzaDTO.getCrust());
        params.put("cheese", pizzaDTO.getCheese());
        params.put("toppings", pizzaDTO.getToppings());
        template.update(query, params);
    }
}
