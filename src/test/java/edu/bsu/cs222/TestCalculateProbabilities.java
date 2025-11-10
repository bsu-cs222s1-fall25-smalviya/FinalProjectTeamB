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

    @Test
    public void testGenshinCalculatorNoPity(){
        CalculateProbabilities calculateProbabilities = new CalculateProbabilities();
        double result = calculateProbabilities.genshinProbability(0.006,  1);
        Assertions.assertEquals(0.6, result);
    }

    @Test
    public void testGenshinCalculatorHardPity1(){
        CalculateProbabilities calculateProbabilities = new CalculateProbabilities();
        double result = calculateProbabilities.genshinProbability(0.006, 74);
        Assertions.assertEquals(6.6000000000000005, result);
    }

    @Test
    public void testGenshinCalculatorHardPity2(){
        CalculateProbabilities calculateProbabilities = new CalculateProbabilities();
        double result = calculateProbabilities.genshinProbability(0.006, 75);
        Assertions.assertEquals(12.6, result);
    }

    @Test
    public void testGenshinCalculatorHardPity3(){
        CalculateProbabilities calculateProbabilities = new CalculateProbabilities();
        double result = calculateProbabilities.genshinProbability(0.006, 80);
        Assertions.assertEquals(42.6, result);
    }

    @Test
    public void testGenshinCalculatorGarentee(){
        CalculateProbabilities calculateProbabilities = new CalculateProbabilities();
        double result = calculateProbabilities.genshinProbability(0.006, 90);
        Assertions.assertEquals(100, result);
    }

// add test classes for 50/50

}
