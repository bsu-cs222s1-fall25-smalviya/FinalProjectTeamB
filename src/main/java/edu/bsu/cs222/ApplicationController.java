package edu.bsu.cs222;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ApplicationController implements Initializable {

    @FXML
    private ChoiceBox<String> GachaGameChoice;
    private String[] gameOptions = {"Pokemon TCGP","Infinity Nikki","Genshin Impact"};

    Alert alert = new Alert(Alert.AlertType.ERROR);

    @FXML
    private ChoiceBox <String> GenshinGuarentee;
    private String[] guaranteedAnswer = {"Yes", "No"};

    @FXML
    private ChoiceBox <String> BannerChoice;
    private String[] bannerOptions = {""};

    @FXML
    private ChoiceBox RarityChoice;
    private String[] rarityOptions = {""};

    @FXML
    private TextField NumberOfPulls;


    @FXML
    String getGachaGameChoice(ActionEvent event) {
        return (String) GachaGameChoice.getValue();
    }

    @FXML
    private TextArea ResultsArea;



    public void getBannerForGame(ActionEvent event){
        String myGameChoice = GachaGameChoice.getValue();
        String[] bannerOptions = {""};
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
                bannerOptions = null;
        }
        BannerChoice.getItems().addAll(bannerOptions);
    }

    public void getRarityForBanner(ActionEvent event){
        String myBannerChoice = BannerChoice.getValue();
        String[] rarityOptions = {};
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
            default: rarityOptions = null;
        }
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

        BannerChoice.getItems().clear();
        RarityChoice.getItems().clear();

    }








}
