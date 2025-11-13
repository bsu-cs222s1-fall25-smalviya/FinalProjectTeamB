package edu.bsu.cs222;

public class CalculateProbabilities {


    public double complementaryProbability(double probability, int numOfPulls) {

        return Math.pow(1 - (1 - probability), numOfPulls);
    }

   /* public double infinityNikiProbability(double probability, double pity, int numOfPulls){



        return finalProbability;
   */

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



    public double genshinProbability5050(double softProbability, int numOfPulls) {
        double finalProbability = 0;

        double hardPity = .06;

        for (int i = 0; i <= numOfPulls; i++) {

            if (i == 90) {
                finalProbability = 1;
            } else if (i > 73) {

                finalProbability = softProbability + (hardPity * (i - 73));

            } else finalProbability = softProbability;


        }
        return (finalProbability * 100) * .5;
    }

    public double genshinProbablity4StarCharacter(double softProbability, int numOfPulls){

        double finalProbability = 0;
        int numOfCharacters = 0;
        if( numOfPulls %10 == 0){
           finalProbability = .5;
            if(numOfPulls %20 == 0){
                int numberOfCharacters = numOfPulls/20;
                finalProbability = 1;
            }
        } else{
            finalProbability= Math.pow(1 - (1 - softProbability), numOfPulls);
        }




return finalProbability;
    }

    public double genshinProbablity4Wepon(double softProbability, int numOfPulls){

        double finalProbability = 0;
        int numOfCharacters = 0;
        if( numOfPulls %10 == 0){
            finalProbability = .1;

        } else{
            finalProbability= Math.pow(1 - (1 - softProbability), numOfPulls);
        }




        return finalProbability;
    }
}






