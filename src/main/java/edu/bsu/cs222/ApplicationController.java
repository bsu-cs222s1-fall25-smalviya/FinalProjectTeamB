package edu.bsu.cs222;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;

public class ApplicationController {
    @FXML
    private ChoiceBox<String> GachaGameChoice;

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
}
