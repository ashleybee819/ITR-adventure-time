package org.ashley.repository;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CrosswordEntity {
    private int id;
    private String clue;
    private String answer;
}
