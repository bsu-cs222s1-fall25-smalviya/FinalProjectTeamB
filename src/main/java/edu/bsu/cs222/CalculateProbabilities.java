package edu.bsu.cs222;

public class CalculateProbabilities {


    public double complementaryProbability(double probability, int numOfPulls) {

        return Math.pow(1 - (1- probability), numOfPulls);
    }

    public double genshinProbability (double softprobability, double hardProbability, int numOfPulls){
        double finalProbability=0;
        for (int i = 0; i <= numOfPulls ; i++) {
            if (i > 75){
                finalProbability= hardProbability;
            } else  finalProbability =  Math.pow(1 - (1 - softprobability), numOfPulls);
        }
        return finalProbability;
    }

}



