package edu.bsu.cs222;

import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InputTest {
@Test
    public void testGameInput() {
    Scanner tester = new Scanner("1");
    Input gameInput = new Input(tester);

    int game = gameInput.getUserInput();
    assertEquals(1, game);
}
@Test
    public void testRarityInput(){
    Scanner tester = new Scanner("6");
    Input rarityInput = new Input(tester);

    int rarity = rarityInput.getUserRarity("Pokemon TCGP");
    assertEquals(6, rarity);
}
@Test
    public void testBannerInput(){
    Scanner tester = new Scanner("Starter Pack");
    Input bannerInput = new Input(tester);

    String banner = bannerInput.getUserBanner("0");
    assertEquals("Starter Pack", banner);
}
}
