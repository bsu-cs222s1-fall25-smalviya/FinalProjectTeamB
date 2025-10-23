package edu.bsu.cs222;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestFormatOutput {

    @Test
    public void testReformatCalc() {
        FormatOutput formatOutput = new FormatOutput();
        String result = formatOutput.formatCalculations(89.9);
        Assertions.assertEquals("Probability og getting your item: 89.9% chance", result);
    }
}
