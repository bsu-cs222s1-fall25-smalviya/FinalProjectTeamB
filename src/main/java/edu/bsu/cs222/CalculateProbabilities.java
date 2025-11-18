package edu.bsu.cs222;

public class CalculateProbabilities {
public double finalProbability;

    public double complementaryProbability(double probability, int numOfPulls) {

        return Math.pow(1 - (1 - probability), numOfPulls) ;
    }

    public double infinityNikiProbability(double probability, double pity, double pityCount, int numOfPulls) {
    if(numOfPulls<= pityCount){
        finalProbability = Math.pow(1 - (1 - pity), numOfPulls);
    } else{
        finalProbability= Math.pow(1 - (1 - probability), numOfPulls);
    }

        return finalProbability*100;
    }

    public double genshinProbability(double softProbability, double pity, int numOfPulls) {




            for (int i = 0; i <= numOfPulls; i++) {

                if (i == 90) {
                    finalProbability = 1;
                } else if (i > 73) {

                    finalProbability = softProbability + (pity * (i - 73));

                } else finalProbability = softProbability;


            }
            return finalProbability* 100;
        }



    public double genshinProbability5050(double softProbability, double pity, int numOfPulls) {



        for (int i = 0; i <= numOfPulls; i++) {

            if (i == 90) {
                finalProbability = 1;
            } else if (i > 73) {

                finalProbability = softProbability + (pity * (i - 73));

            } else finalProbability = softProbability;


        }
        return (finalProbability * 100) * .5;
    }

    public double genshinProbablity4StarCharacter(double softProbability, int numOfPulls){

        int numOfCharacters = 0;
        if(numOfPulls==1){
            finalProbability=softProbability;
        }
        if( numOfPulls %10 == 0){
           finalProbability = .5;
            if(numOfPulls %20 == 0){
                int numberOfCharacters = numOfPulls/20;
                finalProbability = 1;
            }
        } else{
            finalProbability= Math.pow(1 - (1 - softProbability), numOfPulls);
        }




return finalProbability* 100;
    }

    public double genshinProbablity4Wepon(double softProbability, int numOfPulls){

        int numOfCharacters = 0;
        if( numOfPulls %10 == 0){
            finalProbability = .5;

        } else{
            finalProbability= Math.pow(1 - (1 - softProbability), numOfPulls);
        }




        return finalProbability*100;
    }
}






