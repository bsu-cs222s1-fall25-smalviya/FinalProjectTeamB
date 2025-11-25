package edu.bsu.cs222;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class GraphSimulationTEST extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("TestGraphUI.fxml"));
        //FXMLLoader fxmlLoader = new FXMLLoader(GraphSimulationTEST.class.getResource("TestGraphUI.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Test Graph");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
