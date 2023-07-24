module com.example.comp_380_project {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires java.logging;


    opens com.example.comp_380_project to javafx.fxml;
    exports com.example.comp_380_project;
}