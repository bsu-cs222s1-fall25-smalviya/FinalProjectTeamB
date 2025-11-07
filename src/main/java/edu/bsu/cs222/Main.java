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

        String bannerName = input.getUserBanner();

        int numOfPulls = input.getUserNumOfPulls();

        double singlePull = retrieve.gachaGameProbability(gameTitle, bannerName, rarity);
        double finalProbability = calculate.complementaryProbability(singlePull, numOfPulls);
        String formatted = formatOutput.formatCalculations(finalProbability*100);
        output.print(formatted);

        System.out.println("                      ");
        System.out.println("Game: " + gameTitle);
        System.out.println("Banner/Pack: " + bannerName);
        System.out.println("Rarity: " + rarity);



    }
}
