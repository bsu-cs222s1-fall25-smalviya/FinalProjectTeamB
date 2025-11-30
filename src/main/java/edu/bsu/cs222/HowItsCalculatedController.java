package edu.bsu.cs222;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class HowItsCalculatedController implements Initializable {

@FXML
private Button GoBack;



    public void closeHowItsDoneStage(ActionEvent event){
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.close();
    }

    public void showCalcScene()throws IOException {

        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/edu/bsu/cs222/ApplicationUI.fxml"));
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
    public void GoBackToCalcScene(ActionEvent event) throws IOException {
        showCalcScene();
        closeHowItsDoneStage(event);
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
