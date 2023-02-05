package com.example.Student;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class StudentUI {
    @FXML
    private TableView<Student> studentTable;
    @FXML
    private TableColumn<Student, Integer> idColumn;
    @FXML
    private TableColumn<Student, String> firstNameColumn;
    @FXML
    private TableColumn<Student, String> lastNameColumn;
    @FXML
    private TableColumn<Student, String> emailColumn;
    @FXML
    private TableColumn<Student, String> phoneColumn;
    @FXML
    private TableColumn<Student, String> enrollmentDateColumn;
    @FXML
    private TableColumn<Student, String> programColumn;

    private ObservableList<Student> students = FXCollections.observableArrayList();
    private StudentService studentService;

    public void initialize() throws SQLException {
        String url = "jdbc:sqlite:C:/Users/AbdullAH Malik/IdeaProjects/AcademiaPro/src/main/resources/Database/AcademiaPro.sqlite";
        Connection conn = DriverManager.getConnection(url);
        studentService = new StudentService(new StudentDAOImpl(conn));
        students.addAll(studentService.getAllStudents());
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
        phoneColumn.setCellValueFactory(new PropertyValueFactory<>("phone"));
        enrollmentDateColumn.setCellValueFactory(new PropertyValueFactory<>("enrollmentDate"));
        programColumn.setCellValueFactory(new PropertyValueFactory<>("program"));
        studentTable.setItems(students);
    }

    @FXML
    public void addStudent() {
// Code to add a new student to the database and refresh the table
    }

    @FXML
    public void updateStudent() {
// Code to update a selected student in the database and refresh the table
    }

    @FXML
    public void deleteStudent() {
// Code to delete a selected student from the database and refresh the table
    }
}