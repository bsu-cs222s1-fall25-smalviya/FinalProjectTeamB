package edu.bsu.cs222;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class OutputTest {
    @Test
    public void testPrintFormat(){
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        Output output = new Output();
        FormatOutput formated = new FormatOutput();
        double probability = 0.065;
        String formattedOutPut = formated.formatCalculations(probability);
        output.print(formattedOutPut);
        assertEquals("Probability of getting your item: 0.065% chance", out.toString());
    }
    @Test
    public void testPrintErrorInvalidGame(){
        ByteArrayOutputStream err = new ByteArrayOutputStream();
        System.setErr(new PrintStream(err));
        Output output = new Output();
        output.printError("Invalid... Please enter 1, 2, or 3");

        String printed = err.toString();
        assertTrue(printed.contains("Invalid... Please enter 1, 2, or 3"));

    }

}
