package edu.bsu.cs222;

public class FormatOutput {
    //Inupt inupt = new Input(); *Not yet a class

    CalculateProbabilities calculateProbabilities = new CalculateProbabilities();

    public String formatCalculations (double probability){
       String formattedOut = ("Probability og getting your item: " + probability +"% chance");
        return formattedOut;
    }
}
