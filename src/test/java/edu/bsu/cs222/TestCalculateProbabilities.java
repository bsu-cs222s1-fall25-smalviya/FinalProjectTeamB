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
        double result = calculateProbabilities.genshinProbability(0.0006,  1);
        Assertions.assertEquals(0.06, result);
    }

    @Test
    public void testGenshinCalculatorHardPity1(){
        CalculateProbabilities calculateProbabilities = new CalculateProbabilities();
        double result = calculateProbabilities.genshinProbability(0.0006, 74);
        Assertions.assertEquals(6.0600000000000005, result);
    }

    @Test
    public void testGenshinCalculatorHardPity2(){
        CalculateProbabilities calculateProbabilities = new CalculateProbabilities();
        double result = calculateProbabilities.genshinProbability(0.0006, 75);
        Assertions.assertEquals(12.06, result);
    }

    @Test
    public void testGenshinCalculatorHardPity3(){
        CalculateProbabilities calculateProbabilities = new CalculateProbabilities();
        double result = calculateProbabilities.genshinProbability(0.0006, 80);
        Assertions.assertEquals(42.059999999999995, result);
    }

    @Test
    public void testGenshinCalculatorGarentee(){
        CalculateProbabilities calculateProbabilities = new CalculateProbabilities();
        double result = calculateProbabilities.genshinProbability(0.0006, 90);
        Assertions.assertEquals(100, result);
    }

    @Test
    public void testGenshinCalculator4StarCharacter(){
        CalculateProbabilities calculateProbabilities = new CalculateProbabilities();
        double result = calculateProbabilities.genshinProbablity4StarCharacter(0.0255, 1);
        Assertions.assertEquals(2.5499999999999967, result);
    }

    @Test
    public void testGenshinCalculator4StarCharacter50Percent(){
        CalculateProbabilities calculateProbabilities = new CalculateProbabilities();
        double result = calculateProbabilities.genshinProbablity4StarCharacter(0.0255, 10);
        Assertions.assertEquals(50.0, result);
    }

    @Test
    public void testGenshinCalculator4StarCharacter100Percent(){
        CalculateProbabilities calculateProbabilities = new CalculateProbabilities();
        double result = calculateProbabilities.genshinProbablity4StarCharacter(0.0255, 20);
        Assertions.assertEquals(100.0, result);
    }

    @Test
    public void testGenshinCalculator4StarCharacterRandomUnder(){
        CalculateProbabilities calculateProbabilities = new CalculateProbabilities();
        double result = calculateProbabilities.genshinProbablity4StarCharacter(0.0255, 7);
        Assertions.assertEquals(7.011020920710875E-10, result);
    }

    @Test
    public void testGenshinCalculator4StarCharacterRandomMiddle(){
        CalculateProbabilities calculateProbabilities = new CalculateProbabilities();
        double result = calculateProbabilities.genshinProbablity4StarCharacter(0.0255, 15);
        Assertions.assertEquals(1.2534375659414598E-22, result);
    }

    @Test
    public void testGenshinCalculator4StarCharacterRandomAbove(){
        CalculateProbabilities calculateProbabilities = new CalculateProbabilities();
        double result = calculateProbabilities.genshinProbablity4StarCharacter(0.0255,25);
        Assertions.assertEquals(1.4571508395141893E-38, result);
    }
    @Test
    public void testGenshinCalculator4Starweapon(){
        CalculateProbabilities calculateProbabilities = new CalculateProbabilities();
        double result = calculateProbabilities.genshinProbablity4Wepon(0.0255, 1);
        Assertions.assertEquals(2.5499999999999967, result);
    }

    @Test
    public void testGenshinCalculator4Starweapon50Percent(){
        CalculateProbabilities calculateProbabilities = new CalculateProbabilities();
        double result = calculateProbabilities.genshinProbablity4Wepon(0.0255, 10);
        Assertions.assertEquals(50.0, result);
    }

    @Test
    public void testGenshinCalculator4Starweapon100Percent(){
        CalculateProbabilities calculateProbabilities = new CalculateProbabilities();
        double result = calculateProbabilities.genshinProbablity4Wepon(0.0255, 20);
        Assertions.assertEquals(50.0, result);
    }

    @Test
    public void testGenshinCalculator4StarweaponRandomUnder(){
        CalculateProbabilities calculateProbabilities = new CalculateProbabilities();
        double result = calculateProbabilities.genshinProbablity4Wepon(0.0255, 7);
        Assertions.assertEquals(7.011020920710875E-10, result);
    }

    @Test
    public void testGenshinCalculator4StarweaponRandomMiddle(){
        CalculateProbabilities calculateProbabilities = new CalculateProbabilities();
        double result = calculateProbabilities.genshinProbablity4Wepon(0.0255, 15);
        Assertions.assertEquals(1.2534375659414598E-22, result);
    }

    @Test
    public void testGenshinCalculator4StarweaponRandomAbove(){
        CalculateProbabilities calculateProbabilities = new CalculateProbabilities();
        double result = calculateProbabilities.genshinProbablity4Wepon(0.0255,25);
        Assertions.assertEquals(1.4571508395141893E-38, result);
    }

}
