package edu.bsu.cs222;

public class GachaSimGraphData {
    private final double rarityProbability;
    private final int numPulls;

    public GachaSimGraphData(double rarityProbability, int numPulls) {
        this.rarityProbability = rarityProbability;
        this.numPulls = numPulls;
    }

    public double getRarityProbability() {
        return rarityProbability;
    }

    public int getNumPulls() {
        return numPulls;
    }
}
