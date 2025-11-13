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
        How how = new How();

        int game = input.getUserInput();
        String gameTitle = null;

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

        int numOfPulls = input.getUserNumOfPulls();

        BannerStats bannerStats = retrieve.gachaGameProbability(gameTitle, bannerName, rarity);
        double singlePull = bannerStats.getRarityProbability();
        double rarityPityProbability = bannerStats.getRarityPityProbability();
        int rarityPityCount = bannerStats.getPityCount();

        double finalProbability = 0.0;

        List<Integer> pullsList = pullSim.userPullsSim(singlePull, rarityPityProbability, rarityPityCount);
        double averagePulls = pullSim.averagePullsForDesiredRarity(pullsList);
        double pullSimProbability = pullSim.probabilityForDesiredRarity(pullsList);


        if (gameTitle.equals("Genshin Impact")){
            boolean isGuaranteed = input.genshinQuestion(gameTitle);

            if (isGuaranteed){
                finalProbability = calculate.genshinProbability5050(singlePull, numOfPulls);
            }
            else {
                finalProbability = calculate.genshinProbability(singlePull,numOfPulls);
            }
        } else if (gameTitle.equals("Pokemon TCGP")){
            finalProbability = calculate.complementaryProbability(singlePull, numOfPulls);
        } else if (gameTitle.equals("Infinity Nikki")) {
            finalProbability = pullSimProbability;
        }



        /*
        String formatted = formatOutput.roundedProbability(finalProbability);
        output.print(formatted);
         */


        System.out.println();
        System.out.println("Game: " + gameTitle);
        System.out.println("Banner/Pack: " + bannerName);
        System.out.println("Rarity: " + bannerStats.getRarity());
        System.out.println("Final Probability: " + finalProbability);
        System.out.println("Average Number of Pulls Based on 10,000 Simulated Successes: ~" + averagePulls);
        System.out.println("Probability based on 10,000 Simulated Successes: ~" + pullSimProbability + "\n");

        how.howItsDone(gameTitle);




    }
}
