package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DatabaseQuery {

    public DatabaseQuery() {

    }
    public List<String[]> getData(/*List<DatasetFilter> filters*/) {
        String url = "jdbc:sqlite:src/main/resources/DataBase.db";
        String sql = "SELECT c.id_ticker, c.date, c.open, c.high, c.low, c.close, c.factor " +
                "FROM price AS c " +
                "JOIN ticker AS p ON c.id_ticker = p.id_ticker " +
                "WHERE p.id_ticker = 107";

        List<String[]> results = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                String[] row = new String[7];
                row[0] = rs.getString("id_ticker");
                row[1] = rs.getString("date");
                row[2] = rs.getString("open");
                row[3] = rs.getString("high");
                row[4] = rs.getString("low");
                row[5] = rs.getString("close");
                row[6] = rs.getString("factor");
                results.add(row);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        // Convert the results to a DataFrame-like structure and filter by date
        List<String[]> filteredResults = new ArrayList<>();
        for (String[] row : results) {
            String date = row[1];
            String open = row[2];
            String high = row[3];
            String low = row[4];
            String close = row[5];
            String factor = row[6];

            //if (date.compareTo("2005-08-24") >= 0 && date.compareTo("2005-09-10") <= 0) {
                filteredResults.add(row);
            //}
        }

        // Print the filtered results
        for (String[] row : filteredResults) {
            //System.out.println(String.join(", ", row));
        }

        return filteredResults;
    }
}
