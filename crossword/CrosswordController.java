package org.ashley.controller;

import lombok.extern.slf4j.Slf4j;
import org.ashley.service.CrosswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@Slf4j
@RestController
@RequestMapping("/entries")
public class CrosswordController {
    private CrosswordService service;

    @Autowired
    public CrosswordController(CrosswordService s) {
        this.service = s;
    }

    @CrossOrigin
    @GetMapping(path = "/{clue}")
    public @ResponseBody ResponseEntity getAnswersByClue(@PathVariable String clue) throws SQLException {
        log.info("get called");
        return ResponseEntity.status(HttpStatus.OK).body(service.getAnswersByClue(clue));
    }
}
