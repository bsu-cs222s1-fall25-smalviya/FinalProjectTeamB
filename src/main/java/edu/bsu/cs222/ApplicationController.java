package edu.bsu.cs222;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.net.URL;
import java.util.ResourceBundle;

public class ApplicationController implements Initializable {

    @FXML
    private ChoiceBox<String> GachaGameChoice;
    private String[] gameOptions = {"Pokemon TCGP","Infinity Nikki","Genshin Impact"};

    @FXML
    private ChoiceBox RarityChoice;

    @FXML
    public void initializeApplication(){
        GachaGameChoice.setItems(FXCollections.observableArrayList("Pokemon TCGP","Infinity Nikki","Genshin Impact"));



    }

    @FXML
    String getGachaGameChoice(ActionEvent event) {
        return (String) GachaGameChoice.getValue();
    }

    public void exitProgram(ActionEvent actionEvent) {
        System.exit(0);
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        GachaGameChoice.getItems().addAll(gameOptions);

    }
}
