module com.example.comp_380_project {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.comp_380_project to javafx.fxml;
    exports com.example.comp_380_project;
}