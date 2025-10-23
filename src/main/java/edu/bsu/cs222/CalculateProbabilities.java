package edu.bsu.cs222;

public class CalculateProbabilities {


    public double complementaryProbability(double Probability, int numOfPulls) {

        return Math.pow(1 - (1- Probability), numOfPulls);
    }

}



