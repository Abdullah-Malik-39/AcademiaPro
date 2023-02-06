package com.example.Student;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class StudentUI implements Initializable {
    private Parent Add, Search, Update, Delete;
    public BorderPane MainWindow;
    public Button SearchButton;
    public Button AddButton;
    public Button UpdateButton;
    public Button DeleteButton;

    public void SearchPressed(ActionEvent actionEvent) {
        MainWindow.setCenter(Search);
    }

    public void AddPressed(ActionEvent actionEvent) {
        MainWindow.setCenter(Add);
    }

    public void UpdatePressed(ActionEvent actionEvent) {
        MainWindow.setCenter(Update);
    }

    public void DeletePressed(ActionEvent actionEvent) {
        MainWindow.setCenter(Delete);
    }

    private Parent loadScene(String sc) throws IOException {
        return FXMLLoader.load(getClass().getResource(sc));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            Add = loadScene("Add.fxml");
            Update =  loadScene("Update.fxml");
            Search =  loadScene("Search.fxml");
            Delete =  loadScene("Delete.fxml");
        } catch (IOException ex) {
            ex.printStackTrace();
        };
    }
}