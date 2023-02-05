module com.example.Student {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires junit;


    opens com.example.Student to javafx.fxml;
    exports com.example.Student;
}