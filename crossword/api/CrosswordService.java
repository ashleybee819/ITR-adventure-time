package org.ashley.service;

import lombok.extern.slf4j.Slf4j;
import org.ashley.dto.CrosswordDTO;
import org.ashley.repository.CrosswordEntity;
import org.ashley.repository.CrosswordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class CrosswordService {
    private CrosswordRepository repository;

    @Autowired
    public CrosswordService(CrosswordRepository r) {
        this.repository = r;
    }

    public List<CrosswordDTO> getAnswersByClue(String clue) {
        log.info("getting answer with clue: " + clue);
        List<CrosswordEntity> entities = repository.getAnswersByClue(clue);
        List<CrosswordDTO> retVal = new ArrayList<>();
        for (CrosswordEntity e: entities) {
            CrosswordDTO crosswordDTO = new CrosswordDTO(e.getId(), e.getClue(), e.getAnswer());
            retVal.add(crosswordDTO);
        }

        return retVal;
    }
}
