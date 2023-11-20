module com.example.sistemakanban {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.sistemakanban to javafx.fxml;
    exports com.example.sistemakanban;
    exports com.example.sistemakanban.classes;
    opens com.example.sistemakanban.classes to javafx.fxml;
}