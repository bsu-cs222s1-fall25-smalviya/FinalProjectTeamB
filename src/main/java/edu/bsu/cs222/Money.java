package edu.bsu.cs222;

public class Money {
    private static final double PokemonPullCost = 1.98;
    private static final double InfinityPullCost = 1.98;
    private final double GenshinPullCost = 2.64;

    public double getCostPull(String gameTitle){
        return switch (gameTitle){
            case "Pokemon TCGP"->PokemonPullCost;
            case "Infinity Nikki"->InfinityPullCost;
            case "Genshin Impact" ->GenshinPullCost;
            default -> 0;
        };
    }
    public double calculateMoney(String gameTitle, int pulls){
        return pulls * getCostPull(gameTitle);
    }
    public int calculateBudget(String gameTitle, double budget){
        return (int) (budget / getCostPull(gameTitle));
    }
}
