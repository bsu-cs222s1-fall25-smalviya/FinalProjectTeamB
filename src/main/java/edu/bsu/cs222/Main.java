package edu.bsu.cs222;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Input input = new Input();
        Output output = new Output();
        FormatOutput formatOutput = new FormatOutput();
        RetrieveDataFromDatabase retrieve = new RetrieveDataFromDatabase();
        CalculateProbabilities calculate = new CalculateProbabilities();
        GachaPullSim pullSim = new GachaPullSim();

        int game = input.getUserInput();
        String gameTitle = "";

        switch (game){
            case 1 ->
                gameTitle = "Pokemon TCGP";

            case 2 ->
                gameTitle = "Infinity Nikki";

            case 3 ->
                gameTitle = "Genshin Impact";

            default -> {
                output.printError("Invalid... Please enter 1, 2, or 3");
                return;
            }

        }
        int rarity = input.getUserRarity(gameTitle);

        String bannerName = input.getUserBanner(gameTitle);

        /*
        int numOfPulls = input.getUserNumOfPulls();

        double singlePull = retrieve.gachaGameProbability(gameTitle, bannerName, rarity);
        double finalProbability = calculate.complementaryProbability(singlePull, numOfPulls);
        String formatted = formatOutput.roundedProbability(finalProbability);
        output.print(formatted);
         */

        BannerStats stats = retrieve.gachaGameProbability(gameTitle, bannerName, rarity);
        double rarityProbability = stats.getRarityProbability();
        double rarityPityProbability = stats.getRarityPityProbability();
        int rarityPityCount = stats.getPityCount();

        List<Integer> pullsList = pullSim.userPullsSim(rarityProbability,rarityPityProbability,rarityPityCount);

        double averagePulls = pullSim.averagePullsForDesiredRarity(pullsList);
        double finalProbability = pullSim.probabilityForDesiredRarity(pullsList);




        System.out.println();
        System.out.println("Game: " + gameTitle);
        System.out.println("Banner/Pack: " + bannerName);
        System.out.println("Rarity: " + rarity);
        System.out.println("Average Pulls it would take to get desired rarity: " + averagePulls);
        System.out.println("Probability Based on 10,000 Successful Pulls: " + finalProbability);



    }
}
