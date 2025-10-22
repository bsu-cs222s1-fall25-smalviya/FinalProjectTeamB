package edu.bsu.cs222;

import org.junit.jupiter.api.Test;

public class TestRetriveDataFromDatabase {

    @Test
    public void testGetPokemonTCGPocketCardProbability(){

        RetriveDataFromDatabase pullDataFromDatabase = new RetriveDataFromDatabase();
        pullDataFromDatabase.PokemonTCGPocket();

    }
}
