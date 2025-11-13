package edu.bsu.cs222;

public class Main {
    public static void main(String[] args) {
        Input input = new Input();
        Output output = new Output();
        FormatOutput formatOutput = new FormatOutput();
        RetrieveDataFromDatabase retrieve = new RetrieveDataFromDatabase();
        CalculateProbabilities calculate = new CalculateProbabilities();

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

        int numOfPulls = input.getUserNumOfPulls();

        double singlePull = retrieve.gachaGameProbability(gameTitle, bannerName, rarity);
        double finalProbability = calculate.complementaryProbability(singlePull, numOfPulls);

        if (gameTitle.equals("Genshin Impact")){
            boolean isGuaranteed = input.genshinQuestion(gameTitle);

            if (isGuaranteed){
                finalProbability = calculate.genshinProbability5050(singlePull, numOfPulls);
            }
            else {
                finalProbability = calculate.genshinProbability(singlePull,numOfPulls);
            }
        }


        String formatted = formatOutput.roundedProbability(finalProbability);
        output.print(formatted);

        System.out.println();
        System.out.println("Game: " + gameTitle);
        System.out.println("Banner/Pack: " + bannerName);
        System.out.println("Rarity: " + rarity);
        System.out.println("Final Probability: " + finalProbability);




    }
}
