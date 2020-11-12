package org.ashley;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CrosswordEntry {
    private String clue;
    private String answer;

    public String getClue() {
        return clue;
    }

    public String getAnswer() {
        return answer;
    }

    @Override
    public String toString() {
        return this.clue + ", " + this.answer;
    }
}