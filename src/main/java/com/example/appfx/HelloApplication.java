package com.example.appfx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("affichage java.fxml"));
        Parent root = fxmlLoader.load();
        HelloController controller = fxmlLoader.getController();

        Scene scene = new Scene(root, 700, 400);
        stage.setTitle("Modification de mon portfolio !");

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}