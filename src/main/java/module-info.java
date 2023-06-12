module com.example.appfx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.appfx to javafx.fxml;
    exports com.example.appfx;
}