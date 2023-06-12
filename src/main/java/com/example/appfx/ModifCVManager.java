package com.example.appfx;

import javafx.scene.control.Alert;

import java.sql.*;

public class ModifCVManager {

    private CVManager cvManager;

    public ModifCVManager(CVManager cvManager) {
        this.cvManager = cvManager;
    }

    public void modifyCV() {
        String experience = cvManager.getExperience();
        String presentation = cvManager.getPresentation();
        String competences = cvManager.getCompetences();
        String diplomes = cvManager.getDiplomes();

        DatabaseManager databaseManager = new DatabaseManager();
        Connection connection = databaseManager.getConnection();

        try {
            String query = "UPDATE datacv SET experiences = ?, presentation = ?, competences = ?, diplomes = ? WHERE id = 1";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, experience);
            statement.setString(2, presentation);
            statement.setString(3, competences);
            statement.setString(4, diplomes);

            statement.executeUpdate();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            // Définir le titre et le contenu du popup
            alert.setTitle("Information");
            alert.setHeaderText(null);
            alert.setContentText("La base de donnée du CV a bien été modifiée !");

            // Afficher le popup et attendre la réponse de l'utilisateur
            alert.showAndWait();

            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        databaseManager.closeConnection();
    }
}