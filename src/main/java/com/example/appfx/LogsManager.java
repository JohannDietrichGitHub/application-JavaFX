package com.example.appfx;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

import java.sql.*;

public class LogsManager {
    private TextArea log_Area;

    public LogsManager(TextArea log_Area) {
        this.log_Area = log_Area;
    }

    public void displayLogs() {
        DatabaseManager databaseManager = new DatabaseManager();
        Connection connection = databaseManager.getConnection();

        try {
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM logs";
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                String show_Username = resultSet.getString("username");
                String actions = resultSet.getString("actions");
                Timestamp date_temps = resultSet.getTimestamp("date_temps");

                log_Area.appendText(show_Username + " || " + actions + " || " + date_temps + " || " + "\n");
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        databaseManager.closeConnection();
    }
}