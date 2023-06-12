package com.example.appfx;

import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CVManager {
    private TextField experience_Area;
    private TextField presentation_Area;
    private TextField competences_Area;
    private TextField diplomes_Area;

    public String getExperience() {
        return experience_Area.getText();
    }

    public String getPresentation() {
        return presentation_Area.getText();
    }

    public String getCompetences() {
        return competences_Area.getText();
    }

    public String getDiplomes() {
        return diplomes_Area.getText();
    }


    public CVManager(TextField experience_Area, TextField presentation_Area, TextField competences_Area, TextField diplomes_Area) {
        this.experience_Area = experience_Area;
        this.presentation_Area = presentation_Area;
        this.competences_Area = competences_Area;
        this.diplomes_Area = diplomes_Area;
    }



    public void displayCVData() {
        DatabaseManager databaseManager = new DatabaseManager();
        Connection connection = databaseManager.getConnection();

                try {
                    Statement statement = connection.createStatement();
                    String query = "SELECT * FROM datacv";
                    ResultSet resultSet = statement.executeQuery(query);

                    if (resultSet.next()) {
                        String experiences = resultSet.getString("experiences");
                        String presentation = resultSet.getString("presentation");
                        String competences = resultSet.getString("competences");
                        String diplomes = resultSet.getString("diplomes");

                        experience_Area.setText(experiences);
                        presentation_Area.setText(presentation);
                        competences_Area.setText(competences);
                        diplomes_Area.setText(diplomes);
                    }

                    resultSet.close();
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
        databaseManager.closeConnection();
    }
}
