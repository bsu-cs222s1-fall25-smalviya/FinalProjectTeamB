package edu.bsu.cs222;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class TestRetriveDataFromDatabase {

    @Test
    public void testGetPokemonTCGPocketCardProbability(){

        RetriveDataFromDatabase pull = new RetriveDataFromDatabase();
       double result = pull.PokemonTCGPocket(2);
       Assertions.assertEquals(0.2378, result);
       }

    }
