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

public class ApplicationController implements Initializable {

    @FXML
    private ChoiceBox<String> GachaGameChoice;
    private final String[] gameOptions = {"Pokemon TCGP","Infinity Nikki","Genshin Impact"};

    Alert alert = new Alert(Alert.AlertType.ERROR);

    @FXML
    private ChoiceBox <String> GenshinGuarentee;
    private final String[] guaranteedAnswer = {"Yes", "No"};

    @FXML
    private ChoiceBox <String> BannerChoice;
    private final String[] bannerOptions = {""};

    @FXML
    private ChoiceBox RarityChoice;
    private final String[] rarityOptions = {""};

    @FXML
    private TextField NumberOfPulls;


    @FXML
    String getGachaGameChoice(ActionEvent event) {
        return GachaGameChoice.getValue();
    }

    @FXML
    private TextArea ResultsArea;

    @FXML
    private Button howPopup;

    @FXML
    private ChoiceBox GameMoneyPick;

    @FXML
    private ChoiceBox <String> CalculationStyle;
    private final String [] calcStyle = {"Calculate the cost of pulls", "Calculate amount of pulls attainable within a Budget"};

    @FXML
    private Label MethodLabel;



    public void getBannerForGame(ActionEvent event){
        String myGameChoice = GachaGameChoice.getValue();
        if(myGameChoice == null){
            BannerChoice.getItems().clear();
            return;
        }
        String[] bannerOptions;
        switch (myGameChoice) {
            case "Pokemon TCGP":
                bannerOptions = new String[]{"Single Booster Pack"};
                break;
            case "Infinity Nikki":
                bannerOptions = new String[]{"Surprise-O-Matic", "5-Star Resonance", "4-Star Resonance"};
                break;
            case "Genshin Impact":
                bannerOptions = new String[]{"Limited Character"};
                break;
            default:
                bannerOptions = new String[0];
        }
        BannerChoice.getItems().clear();
        BannerChoice.getItems().addAll(bannerOptions);
    }

    public void getRarityForBanner(ActionEvent event){
        String myBannerChoice = BannerChoice.getValue();
        if (myBannerChoice == null || myBannerChoice.isEmpty()){
            RarityChoice.getItems().clear();
            return;
        }
        String[] rarityOptions;
        switch (myBannerChoice) {
            case "Single Booster Pack":
                rarityOptions =new String[]{"Uncommon", "Rare", "Ultra Rare", "Illustration Rare", "Special Illustration Rare", "Immersive", "Shiny Rare", "Double Shiny Rare", "Crown Rare"};
                break;
            case "Surprise-O-Matic" :
                rarityOptions = new String[]{ "3 Stars", "4 Stars", "5 Stars"};
                break;
            case "5-Star Resonance":
                rarityOptions = new String[]{"3 Stars", "4 Stars", "5 Stars"};
                break;
            case "4-Star Resonance":
                rarityOptions = new String[]{"3 Stars", "4 Stars", "5 Stars"};
                break;
            case "Limited Character":
                rarityOptions = new String[]{"4 Star Character", "4 Star Weapon", "5 Stars"};
                break;
            default: rarityOptions = new String[0];
        }
        RarityChoice.getItems().clear();
        RarityChoice.getItems().addAll(rarityOptions);
    }

    private int getIntFromNumOfPulls(){
        int numOfPulls = 10;

        try {
            numOfPulls = Integer.parseInt(NumberOfPulls.getText());
        } catch (Exception e) {

            alert.setTitle("Error");
            alert.setContentText("Invalid Input\n You probably didn't use numbers. Try again.");

            alert.show();

        }

        NumberOfPulls.setText(Integer.toString(numOfPulls));
        return numOfPulls;
    }



    public void exitProgram(ActionEvent actionEvent) {
        System.exit(0);
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        GachaGameChoice.getItems().addAll(gameOptions);
        GenshinGuarentee.getItems().addAll(guaranteedAnswer);
        GachaGameChoice.setOnAction(this::getBannerForGame);
        BannerChoice.setOnAction(this::getRarityForBanner);
        GameMoneyPick.getItems().addAll(gameOptions);
        CalculationStyle.getItems().addAll(calcStyle);
        CalculationStyle.setOnAction(this::getMethod);






    }

    public int convertRarityToNumber(String rarityName){
        int rarity = 0;
        switch (rarityName) {
            case "Uncommon":
                rarity = 0;
                break;
            case "3 Stars":
                rarity = 0;
                break;
            case "4 Star Character":
                rarity = 0;
                break;
            case "Rare":
                rarity = 1;
                break;
            case "4 Stars":
                rarity = 1;
                break;
            case "4 Star Weapon":
                rarity = 1;
                break;
            case "Ultra Rare":
                rarity = 2;
                break;
            case "5 Stars":
                rarity = 2;
                break;
            case "Illustration Rare":
                rarity = 3;
                break;
            case "Special Illustration Rare":
                rarity = 4;
                break;
            case "Immersive":
                rarity = 5;
                break;
            case "Shiny Rare":
                rarity = 6;
            case "Double Shiny Rare":
                rarity = 7;
                break;
            case "Crown Rare":
                rarity = 8;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + rarityName);
        }
        return rarity;
    }

    public void RunButton( ActionEvent actionEvent) {
        ResultsArea.setText(getInfo());
    }

    public String getInfo(){
        if (GachaGameChoice.getValue() == null){
            return "Error: No Game selected.";
        }
        if (BannerChoice.getValue() == null){
            return "Error: No banner selected.";
        }
        if (RarityChoice.getValue() == null){
            return " Error: No rarity selected.";
        }

        Output output = new Output();
        RetrieveDataFromDatabase retrieve = new RetrieveDataFromDatabase();
        CalculateProbabilities calculate = new CalculateProbabilities();
        GachaPullSim pullSim = new GachaPullSim();

        String gameTitle = GachaGameChoice.getValue();
        String bannerName = BannerChoice.getValue();
        int rarity = convertRarityToNumber((String) RarityChoice.getValue());
        int numOfPulls = getIntFromNumOfPulls();

        BannerStats bannerStats = retrieve.gachaGameProbability(gameTitle, bannerName, rarity);

        double singlePull = bannerStats.getRarityProbability();
        double rarityPityProbability = bannerStats.getRarityPityProbability();
        int rarityPityCount = bannerStats.getPityCount();

        List<Integer> pullsList = pullSim.userPullsSim(singlePull, rarityPityProbability, rarityPityCount);

        double averagePulls = pullSim.averagePullsForDesiredRarity(pullsList);
        double pullSimProbability = pullSim.probabilityForDesiredRarity(pullsList);

        double finalProbability = 0.0;

        if (gameTitle.equals("Genshin Impact")){


            if (GenshinGuarentee.getValue() == "Yes"){
                finalProbability = calculate.genshinProbability(singlePull, rarityPityProbability, numOfPulls);
            }
            else {
                finalProbability = calculate.genshinProbability5050(singlePull,rarityPityProbability, numOfPulls);
            }
        } else if (gameTitle.equals("Pokemon TCGP")){
            finalProbability = calculate.complementaryProbability(singlePull, numOfPulls);
        } else if (gameTitle.equals("Infinity Nikki")) {
            finalProbability = calculate.infinityNikiProbability(singlePull, rarityPityProbability, rarityPityCount, numOfPulls);
        }
        FormatOutput formatOutput = new FormatOutput();
        String formatted = formatOutput.roundedProbability(finalProbability);

        String finalResults = ( "Your Results\n"+
                "\n" +
                "Game: " + gameTitle +
                "\n" +"Banner/Pack: " + bannerName +
                "\n" +"Rarity: " + bannerStats.getRarity() +
                "\n" + "Final Probability: " + formatted +
                "\n" + "Average Number of Pulls Based on 10,000 Simulated Successes: ~" + averagePulls + "\n" +
                "Probability based on 10,000 Simulated Successes: ~" + pullSimProbability + "\n");


        return finalResults;
    }


    public void restartApplication(ActionEvent actionEvent) {
        GachaGameChoice.getItems().clear();
        GachaGameChoice.getItems().addAll(gameOptions);
        GenshinGuarentee.getItems().clear();
        GenshinGuarentee.getItems().addAll(guaranteedAnswer);
        BannerChoice.getItems().clear();
        BannerChoice.getItems().addAll(bannerOptions);
        RarityChoice.getSelectionModel().clearSelection();
        RarityChoice.getItems().clear();
        NumberOfPulls.clear();
        ResultsArea.setText("");


    }

    public void closeCalcStage(ActionEvent event){
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.close();
    }

    public void showHIDScene()throws IOException {

        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/edu.bsu.cs222/HowItsCalculatedPopupUI.fxml"));
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
public void HowItsDone(ActionEvent event) throws IOException {
    showHIDScene();
    closeCalcStage(event);

}

public void getMethod(ActionEvent event) {
    String moneyMethod = CalculationStyle.getValue();
    String finalMethood = null;
    if (moneyMethod.equals("Calculate the cost of pulls")) {
        finalMethood = "Enter the number of pulls you want calculated.";
    } else {
        finalMethood = "Enter your budget.";
    }


    MethodLabel.setText(finalMethood);
}







}
