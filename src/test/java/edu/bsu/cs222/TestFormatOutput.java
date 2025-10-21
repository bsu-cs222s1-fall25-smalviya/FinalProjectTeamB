package edu.bsu.cs222;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestFormatOutput {

    @Test
    public void testReformatCalc() {
        FormatOutput formatOutput = new FormatOutput();
        String result = formatOutput.formatTCGCalculations(89.0, 56.0, "Uncommon");
        Assertions.assertEquals("Card 4: 89.0% chance to be Uncommon.\n" +
                "Card 5: 56.0% chance to be Uncommon.", result);
    }
}
