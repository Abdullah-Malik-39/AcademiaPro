module com.example.Student {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.Student to javafx.fxml;
    exports com.example.Student;
}