package edu.bsu.cs222;

public class CalculateProbabilities {


    public double complementaryProbability(double probability, int numOfPulls) {

        return Math.pow(1 - (1 - probability), numOfPulls);
    }

    public double genshinProbability(double softProbability, int numOfPulls) {
        double finalProbability = 0;

        double hardPity = .06;

        for (int i = 0; i <= numOfPulls; i++) {

            if (i == 90) {
                finalProbability = 1;
            } else if (i > 73) {

                finalProbability = softProbability + (hardPity * (i - 73));

            } else finalProbability = softProbability;


        }
        return finalProbability * 100;
    }


    public double genshinProbability50/50(double softProbability, int numOfPulls) {
        double finalProbability = 0;

        double hardPity = .06;

        for (int i = 0; i <= numOfPulls; i++) {

            if (i == 90) {
                finalProbability = 1;
            } else if (i > 73) {

                finalProbability = softProbability + (hardPity * (i - 73));

            } else finalProbability = softProbability;


        }
        return (finalProbability * 100)*.5;
    }
}



