package edu.bsu.cs222;

import java.math.RoundingMode;

public class FormatOutput {


    public String formatCalculationsNoDecimal(double probability) {

        String intProbability = String.format("%.0f", probability);

        return "It will take about "+ intProbability+" pulls to get your desired item";
    }

    public String roundedProbability(double probability) {

       if (probability>=1){

           return "Probability of getting your item: "+ String.format("%.2f",probability)+"% chance";
       }
       java.math.BigDecimal bd = new java.math.BigDecimal(probability);
       String unrounded = bd.toPlainString();

       int decinalIndex = unrounded.indexOf('.');
       int firstNonZeroIndex = -1;
       for(int i = decinalIndex + 1; i<unrounded.length(); i++){
           if(unrounded.charAt(i) != '0'){
               firstNonZeroIndex = i;
               break;
           }
       }
       int digitsAfterDecimal = (firstNonZeroIndex == -1) ? 2: (firstNonZeroIndex - decinalIndex +1);

       bd = bd.setScale(digitsAfterDecimal, RoundingMode.HALF_UP);
       String output = "Probability of getting your item: " + bd.stripTrailingZeros(). toPlainString()+ "% chance";
       return output;
    }
}

