package edu.bsu.cs222;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestRetriveDataFromDatabase {

    @Test
    public void testGetPokemonTCGPocketCardProbability(){

        RetriveDataFromDatabase pull = new RetriveDataFromDatabase();
       double result = pull.PokemonTCGPocket(2);
       Assertions.assertEquals(0.2378, result);
       }

    }
