package edu.bsu.cs222;

public class FormatOutput {
    //Inupt inupt = new Input(); *Not yet a class

    CalculateProbabilities calculateProbabilities = new CalculateProbabilities();

    public String formatTCGCalculations (double tCGCard4Probability, double tCGCard5Probability, String rarity){
       String formattedOutTCG = ("Card 4: " + tCGCard4Probability + "% chance to be "+ rarity + ".\n"
       + "Card 5: " + tCGCard5Probability + "% chance to be "+ rarity + "." );
        return formattedOutTCG;
    }
}
