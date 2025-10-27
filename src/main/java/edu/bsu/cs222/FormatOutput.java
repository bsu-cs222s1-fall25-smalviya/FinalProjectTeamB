package edu.bsu.cs222;

public class FormatOutput {
    Input input = new Input();

    CalculateProbabilities calculateProbabilities = new CalculateProbabilities();

    public String formatCalculations (double probability){
       String formattedOut = ("Probability of getting your item: " + probability +"% chance");
        return formattedOut;
    }
}
