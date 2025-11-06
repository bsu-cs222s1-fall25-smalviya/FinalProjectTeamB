package edu.bsu.cs222;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestRetrieveDataFromDatabase {

    @Test
    public void testGetPokemonTCGPocketCardProbability(){

        RetrieveDataFromDatabase pull = new RetrieveDataFromDatabase();
        double result = pull.gachaGameProbability("Pokemon TCGP", "Single Booster Pack", 2);
        Assertions.assertEquals(0.2378, result);
    }

    @Test
    public void testGetPokemonTCGPocketCardProbability1(){

        RetrieveDataFromDatabase pull = new RetrieveDataFromDatabase();
        double result = pull.gachaGameProbability("Pokemon TCGP", "Single Booster Pack",8);
        Assertions.assertEquals(0.0166, result);
    }

}