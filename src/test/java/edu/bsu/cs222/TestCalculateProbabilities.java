package edu.bsu.cs222;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestCalculateProbabilities {

    @Test
    public void testEnterRarityForCards4(){
        CalculateProbabilities calculateProbabilities = new CalculateProbabilities();
        double result = calculateProbabilities.calculateTGCCard4(89);
        Assertions.assertEquals(89.0, result);
    }

    @Test
    public void testEnterRarityForCards5(){
        CalculateProbabilities calculateProbabilities = new CalculateProbabilities();
        double result = calculateProbabilities.calculateTGCCard5(56);

        Assertions.assertEquals(56.0, result);
    }

    @Test
    public void testEnterRarityForCards4WithDouble(){
        CalculateProbabilities calculateProbabilities = new CalculateProbabilities();
        double result = calculateProbabilities.calculateTGCCard4(4.952);
        Assertions.assertEquals(4.952, result);
    }

    @Test
    public void testEnterRarityForCards5WithDouble(){
        CalculateProbabilities calculateProbabilities = new CalculateProbabilities();
        double result = calculateProbabilities.calculateTGCCard5(19.81);

        Assertions.assertEquals(19.81, result);
    }


}
