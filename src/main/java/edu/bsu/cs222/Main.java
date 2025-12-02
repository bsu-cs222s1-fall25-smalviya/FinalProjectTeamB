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
        Money money = new Money();
        MoneyInput moneyInput = new MoneyInput();

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

        String bannerName = input.getUserBanner(gameTitle);

        int rarity = input.getUserRarity(gameTitle);

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

        if (moneyInput.UsingMoney()){
            String moneyGame = moneyInput.chooseGame();
            if (moneyGame == null){
                System.out.println("Invalid game selection...");
            }
            else {
                boolean calculateCost = moneyInput.chooseMoneyMethod();
                if (calculateCost){
                    int paidPulls = moneyInput.pullsInput();
                    double cost = money.calculateMoney(moneyGame, paidPulls);
                    System.out.printf("The cost of %d pulls in %s: $%.2f%n", paidPulls, moneyGame, cost);
                }else {
                    double budget = moneyInput.budgetInput();
                    int pulls = money.calculateBudget(moneyGame, budget);
                    System.out.printf("For a budget of $%.2f, you can get %d pulls in %s.%n", budget, pulls, moneyGame);
                }
            }
        }



        String formatted = formatOutput.roundedProbability(finalProbability);
        output.print(formatted);
        System.out.println();


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
