package com.example.appfx;

import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class ContactsManager {
    private ChoiceBox<String> contact_Display;
    private TextArea contenu_Contact_Area;
    private Map<String, Integer> contactIdMap; // Map pour associer le sujet à l'ID

    public String getContact() {
        return contact_Display.getSelectionModel().getSelectedItem();
    }


    public ContactsManager(ChoiceBox<String> contact_Display, TextArea contenu_Contact_Area) {
        this.contact_Display = contact_Display;
        this.contenu_Contact_Area = contenu_Contact_Area;
        this.contactIdMap = new HashMap<>();
    }

    public void populateContactChoiceBox() {
        DatabaseManager databaseManager = new DatabaseManager();
        Connection connection = databaseManager.getConnection();

        try {
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM contact";
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String sujet = resultSet.getString("sujet");
                contactIdMap.put(sujet, id); // Associer le sujet à l'ID dans la Map
                contact_Display.getItems().add(sujet);
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        databaseManager.closeConnection();
    }

    public int getContactId() {
        String selectedContact = getContact();
        return contactIdMap.getOrDefault(selectedContact, -1);
    }

    public Contact getContactDetails(int contactId) {
        Contact contact = null;
        DatabaseManager databaseManager = new DatabaseManager();
        Connection connection = databaseManager.getConnection();

        try {
            String query = "SELECT * FROM contact WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, contactId);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int id = resultSet.getInt("id");
                String raison = resultSet.getString("raison");
                String mail = resultSet.getString("mail");

                contact = new Contact(id, raison, mail); // Créer une instance de la classe Contact avec les détails récupérés
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        databaseManager.closeConnection();

        return contact;
    }
}