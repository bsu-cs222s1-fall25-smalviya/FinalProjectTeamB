package edu.bsu.cs222;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestFormatOutput {

    @Test
    public void testReformatCalc() {
        FormatOutput formatOutput = new FormatOutput();
        String result = formatOutput.formatCalculationsNoDecimal(89.9);
        Assertions.assertEquals("It will take about 90 pulls to get your desired item", result);
    }

    @Test
    public void testReformatCalc1() {
        FormatOutput formatOutput = new FormatOutput();
        String result = formatOutput.formatCalculationsNoDecimal(1.0006789);
        Assertions.assertEquals("It will take about 1 pulls to get your desired item", result);
    }

    @Test
    public void testReformatCalc3() {
        FormatOutput formatOutput = new FormatOutput();
        String result = formatOutput.roundedProbability(.000006789);
        Assertions.assertEquals("Probability of getting your item: 0.00068% chance", result);
    }

    @Test
    public void testReformatCalc4() {
        FormatOutput formatOutput = new FormatOutput();
        String result = formatOutput.roundedProbability(.010006789);
        Assertions.assertEquals("Probability of getting your item: 1.00% chance", result);
    }
    @Test
    public void testReformatCalc5() {
        FormatOutput formatOutput = new FormatOutput();
        String result = formatOutput.roundedProbability(.123566789);
        Assertions.assertEquals("Probability of getting your item: 12.36% chance", result);
    }
}
