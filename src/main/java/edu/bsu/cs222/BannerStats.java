package edu.bsu.cs222;

public class BannerStats {
    private final String rarity;
    private final double rarityProbability;

    public BannerStats(String rarity, double rarityProbability){
        this.rarity = rarity;
        this.rarityProbability = rarityProbability;
    }

    public String getRarity() {
        return rarity;
    }

    public double getRarityProbability() {
        return rarityProbability;
    }
}