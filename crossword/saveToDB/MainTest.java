package org.ashley;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

public class MainTest {
    public static void main(String[] args) throws IOException {

        ArrayList<CrosswordEntry> crosswordEntries = ReadFile.readEntries();
        String url = "jdbc:mysql://localhost:3306/crossword";

        try {
            Connection conn = DriverManager.getConnection(url, "root", "root");

            for (int i = 0; i < crosswordEntries.size(); i++) {
                PreparedStatement ps = conn.prepareStatement("INSERT INTO entries (clue, answer) VALUES (?, ?);");
                ps.setString(1, crosswordEntries.get(i).getClue());
                ps.setString(2, crosswordEntries.get(i).getAnswer());
                ps.executeUpdate();
                System.out.println(((i * 100.0f) / crosswordEntries.size()) + "% done: " + crosswordEntries.get(i).toString());
            }
            conn.close();
        } catch (SQLException e) {
            System.out.println("connection error: " + e.getMessage());
        }
    }
}
