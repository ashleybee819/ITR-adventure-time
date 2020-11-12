package org.ashley;

import java.util.ArrayList;

public class ParseFile {

    public static ArrayList<CrosswordEntry> parseFile(String s) {
        String t = s.substring(53);
        String[] splits = t.split("]");

        ArrayList<CrosswordEntry> crosswordEntries = new ArrayList<CrosswordEntry>();
        ArrayList<String> acrossAnswers = parseAnswerSplits(splits[0]);
        ArrayList<String> downAnswers = parseAnswerSplits(splits[1].split("\\[")[1]);
        ArrayList<String> acrossClues = parseClueSplits(splits[2].split("\\[")[1]);
        ArrayList<String> downClues = parseClueSplits(splits[3].split("\\[")[1]);
        if(acrossClues.size() > 1 && acrossAnswers.size() > 1 && downClues.size() > 1 && downAnswers.size() > 1) {
            crosswordEntries.addAll(addCrosswordEntries(acrossClues, acrossAnswers));
            crosswordEntries.addAll(addCrosswordEntries(downClues, downAnswers));
        }
        return crosswordEntries;
    }

    private static ArrayList<CrosswordEntry> addCrosswordEntries(ArrayList<String> clues, ArrayList<String> answers) {
        ArrayList<CrosswordEntry> crosswordEntries = new ArrayList<>();
        for(int i = 0; i < answers.size(); i++) {
            if (clues.size() > 0 && answers.size() > 0) {
                try {
                    crosswordEntries.add(new CrosswordEntry(clues.get(i), answers.get(i)));
                } catch (Exception e) {
                    System.out.println("exception at addCrossWordEntries: " + e.getMessage());
                }
            }
        }
        return crosswordEntries;
    }

    private static ArrayList<String> parseAnswerSplits(String answerString) {
        String[] splitAnswers = answerString.split(",");
        ArrayList<String> answers = new ArrayList<>();
        for(String answer: splitAnswers) {
            answer = answer.replace("\"", "");
            answers.add(answer);
        }
        return answers;
    }

    private static ArrayList<String> parseClueSplits(String clueString) {
        String[] splitClues = clueString.split("\",\"");
        splitClues[0] = splitClues[0].replace("\"", "");
        splitClues[splitClues.length - 1] = splitClues[splitClues.length - 1].replace("\"", "");
        ArrayList<String> clues = new ArrayList<>();
        for(String clue: splitClues) {
            try {
                clue = clue.split("^[0-9]*\\.*")[1].trim();
                clues.add(clue);
            } catch (Exception e) {
                System.out.println("exception at parseClueSplits: " + e.getMessage());
            }
        }
        return clues;
    }
}
