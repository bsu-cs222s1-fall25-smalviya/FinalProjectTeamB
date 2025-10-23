package edu.bsu.cs222;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestCalculateProbabilities {

    @Test
    public void testEnterRarityForCards4(){
        CalculateProbabilities calculateProbabilities = new CalculateProbabilities();
        double result = calculateProbabilities.complementaryProbability(89, 1);
        Assertions.assertEquals(89.0, result);
    }




    @Test
    public void testEnterRarityForCardsWithDouble(){
        CalculateProbabilities calculateProbabilities = new CalculateProbabilities();
        double result = calculateProbabilities.complementaryProbability(4.952, 1);
        Assertions.assertEquals(4.952, result);
    }



}
