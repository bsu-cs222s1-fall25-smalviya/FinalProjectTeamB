package edu.bsu.cs222;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApplication extends Application {
    Output output = new Output();
    RetrieveDataFromDatabase retrieve = new RetrieveDataFromDatabase();
    CalculateProbabilities calculate = new CalculateProbabilities();
    GachaPullSim pullSim = new GachaPullSim();
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start (Stage primaryStage) throws Exception{

        Parent root =  FXMLLoader.load(getClass().getResource("ApplicationUI.fxml"));

        primaryStage.setScene(new Scene(root));
        primaryStage.show();

    }







}
