package org.ashley;

import java.io.*;
import java.util.ArrayList;

public class ReadFile {

    public static ArrayList<CrosswordEntry> readEntries() {

        BufferedReader br = null;
        String line = "";
        ArrayList<CrosswordEntry> crosswordEntries = new ArrayList<>();
        try {
            for (int year = 1988; year < 1989; year++) {
                for (int month = 1; month < 13; month++) {
                    for (int day = 1; day < 32; day++) {
                        File file = new File("C:\\Users\\HP\\Documents\\GitHub\\nyt_crosswords\\" + year + "\\" + month + "\\" + day + ".json");
                        if (file.exists()) {
                            br = new BufferedReader(new FileReader("C:\\Users\\HP\\Documents\\GitHub\\nyt_crosswords\\" + year + "\\" + month + "\\" + day + ".json"));
                            line = br.readLine();
                            crosswordEntries.addAll(ParseFile.parseFile(line));
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return crosswordEntries;
    }
}
