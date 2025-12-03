package edu.bsu.cs222;

public class CalculateProbabilities {
public double finalProbability;

    public double complementaryProbability(double probability, int numOfPulls) {

        return (1- Math.pow((1- probability), numOfPulls))*100 ;
    }

    public double infinityNikiProbability(double probability, double pity, double pityCount, int numOfPulls) {
    if(numOfPulls<= pityCount){
        finalProbability = 1- Math.pow((1-pity ), numOfPulls);
    } else{
        finalProbability= 1- Math.pow( (1- probability), numOfPulls);
    }

        return finalProbability*100;
    }

    public double genshinProbability(double softProbability, double pity, int numOfPulls) {




            for (int i = 0; i <= numOfPulls; i++) {

                if (i == 90) {
                    finalProbability = 1;
                } else if (i > 73) {

                    finalProbability = softProbability + (pity * (i - 73));

                } else finalProbability = 1- Math.pow( (1- softProbability), numOfPulls);


            }
            return finalProbability* 100;
        }



    public double genshinProbability5050(double softProbability, double pity, int numOfPulls) {



        for (int i = 0; i <= numOfPulls; i++) {

            if (i == 90) {
                finalProbability = 1;
            } else if (i > 73) {

                finalProbability = softProbability + (pity * (i - 73));

            } else finalProbability = 1- Math.pow( (1- softProbability), numOfPulls);


        }
        return (finalProbability * 100) * .5;
    }

    public double genshinProbablity4StarCharacter(double softProbability, int numOfPulls){


        if(numOfPulls==20){
             finalProbability= 100.00;
        } else if (numOfPulls == 10) {
            finalProbability = 50.00;

        } else{
            finalProbability= 1-Math.pow((1 - softProbability), numOfPulls);
        }




return finalProbability* 100;
    }

    public double genshinProbablity4Wepon(double softProbability, int numOfPulls){

        if(numOfPulls==20){
            finalProbability= 100.00;
        } else if (numOfPulls == 10) {
            finalProbability = 50.00;

        } else{
            finalProbability= 1-Math.pow((1 - softProbability), numOfPulls);
        }




        return finalProbability*100;
    }
}






