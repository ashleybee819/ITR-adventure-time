package org.ashley.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class CrosswordRepository {
    private NamedParameterJdbcTemplate template;

    @Autowired
    public CrosswordRepository(NamedParameterJdbcTemplate t) {
        this.template = t;
    }

    public List<CrosswordEntity> getAnswersByClue(String clue) {
        String query = "SELECT DISTINCT clue, answer FROM entries WHERE clue = :var";
        Map<String, Object> params = new HashMap<>();
        params.put("var", clue);
        RowMapper<CrosswordEntity> rowMapper = new BeanPropertyRowMapper<>(CrosswordEntity.class);

        return template.query(query, params, rowMapper);
    }
}
