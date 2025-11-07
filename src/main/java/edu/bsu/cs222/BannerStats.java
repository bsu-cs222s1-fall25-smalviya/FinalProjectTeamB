package edu.bsu.cs222;

public class BannerStats {
    private final String rarity;
    private final double rarityProbability;
    private final double rarityPityProbability;
    private final int pityCount;

    public BannerStats(String rarity, double rarityProbability, double rarityPityProbability, int pityCount){
        this.rarity = rarity;
        this.rarityProbability = rarityProbability;
        this.rarityPityProbability = rarityPityProbability;
        this.pityCount = pityCount;
    }

    public String getRarity() {return rarity;}

    public double getRarityProbability() {return rarityProbability;}

    public double getRarityPityProbability() {return rarityPityProbability;}

    public int getPityCount() {return pityCount;}
}