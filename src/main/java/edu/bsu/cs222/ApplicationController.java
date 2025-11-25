package edu.bsu.cs222;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import java.net.URL;
import java.util.ResourceBundle;

public class ApplicationController implements Initializable {
    private String gameChoice = "";
    private String rarityChoice = "";

    public String getGameChoice() {
        return gameChoice;
    }

    public String getRarityChoice() {
        return rarityChoice;
    }

    private String[] pokemonRarityOptions = {"Uncommon","Rare","Ultra Rare","Illustration Rare",
    "Special Illustration Rare","Immersive","Shiny Rare","Double Shiny Rare","Crown Rare"};
    private String[] nikkiRarityOptions = {"3 Stars","4 Stars","5 Stars"};
    private String[] genshinRarityOptions = {"4 Star Character", "4 Star Weapon", "5 Stars"};


    private String[] nikkiBanners = {"Surprise-O-Matic","5-Star Resonance", "4-Star Resonance"};
    private String[] pokemonBanners = {"Single Booster Pack"};
    private String[] genshinBannera = {"Limited Character"};

    int numOfPulls;

    Alert alert = new Alert(Alert.AlertType.ERROR);

    @FXML
    private ChoiceBox<String> GachaGameChoice;
    private String[] gameOptions = {"Pokemon TCGP","Infinity Nikki","Genshin Impact"};

    @FXML
    private ChoiceBox<String> RarityChoice;

    @FXML
    String getGachaGameChoice(ActionEvent event) {
        gameChoice = GachaGameChoice.getValue();
        System.out.println(gameChoice);
        return gameChoice;
    }

    @FXML
    String getRarityChoice(ActionEvent event) {
        rarityChoice = RarityChoice.getValue();
        return rarityChoice;
    }

    @FXML
    private TextField pullsTextField;

    public void exitProgram(ActionEvent actionEvent) {
        System.exit(0);
    }

    @FXML
    public void submitNumberOfPulls(ActionEvent event){
        try {
            numOfPulls = Integer.parseInt(pullsTextField.getText());
        }
        catch (Exception e) {
            alert.setTitle("Error");
            alert.setContentText("Invalid Input. Try again.");
            alert.show();
        }

    }

    @FXML
    public String[] getRarityOptions() {

        if (gameChoice.equals("Pokemon TCGP")) {
            System.out.println(pokemonRarityOptions);
            return pokemonRarityOptions;
        } else if (gameChoice.equals("Infinity Nikki")) {
            System.out.println(nikkiRarityOptions);
            return nikkiRarityOptions;
        } else if (gameChoice.equals("Genshin Impact")){
            System.out.println(genshinRarityOptions);
            return genshinRarityOptions;
        }
        else {
            return new String[]{""};
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        GachaGameChoice.getItems().addAll(gameOptions);
        GachaGameChoice.setOnAction(this::getGachaGameChoice);


        RarityChoice.getItems().addAll(getRarityOptions());
        RarityChoice.setOnAction(this::getRarityChoice);
    }
}
