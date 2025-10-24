package edu.bsu.cs222;


import com.google.gson.*;
import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;

import java.io.*;

public class RetriveDataFromDatabase {
    String filePath = "./src/main/resources/Database.json";


    public double PokemonTCGPocket(int rarity) {
        double resultProbability = 0;
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("Database.json");

        try {
            JSONArray jsonArray = JsonPath.read(inputStream,"$...bannerStats[*]");

        BannerStats[] bannerStats = new BannerStats[jsonArray.size()];

        for (int i=0;i<bannerStats.length; i++){
            JsonArray jsonRarity = JsonPath.read(jsonArray.get(i),"$...rarity");
            String stringRarity = String.valueOf(jsonRarity);
            JsonArray jsonRarityProbability = JsonPath.read(jsonArray.get(i),"$...rarityProbability");
            double doubleRarityProbability = Double.valueOf(String.valueOf(jsonRarityProbability));
            bannerStats[i] = new BannerStats(stringRarity, doubleRarityProbability);
        }

        String desiredRarity = null;

        switch (rarity) {
            case 1:
                desiredRarity = "Uncommon";
                break;
            case 2:
                desiredRarity = "Rare";
                break;
            case 3:
                desiredRarity = "Ultra Rare";
                break;
            case 4:
                desiredRarity = "Illustration Rare";
                break;
            case 5:
                desiredRarity = "Special Illustration Rare";
                break;
            case 6:
                desiredRarity = "Immersive";
                break;
            case 7:
                desiredRarity = "Shiny Rare";
                break;
            case 8:
                desiredRarity = "Double Shiny Rare";
                break;
            case 9:
                desiredRarity = "Crown Rare";
                break;

        }

        for (int i=0; i<bannerStats.length;i++){
            if (bannerStats[i].getRarity().equals(desiredRarity)){
                resultProbability = bannerStats[i].getRarityProbability();
            }
        }
        } catch (IOException e) {
            System.out.println(e);
        }

        return resultProbability;

    }
}
