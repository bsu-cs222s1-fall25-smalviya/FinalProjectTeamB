package edu.bsu.cs222;

import org.junit.jupiter.api.Test;
import java.util.Scanner;
import static org.junit.jupiter.api.Assertions.*;

public class InputTest {
@Test
    public void testGameInput() {
    Scanner tester = new Scanner("1");
    Input game = new Input(tester);

    int gameInput = game.getUserInput();
    assertEquals(2, gameInput);
}
@Test
    public void testRarityInput(){
    Scanner tester = new Scanner("6");
    Input rarity = new Input(tester);

    int rarityInput = rarity.getUserRarity();
    assertEquals(6, rarityInput);
}}
