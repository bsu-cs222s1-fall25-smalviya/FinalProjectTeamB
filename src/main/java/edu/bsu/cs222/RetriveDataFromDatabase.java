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
            JSONArray jsonArray = JsonPath.read(inputStream,"$['gachaGames'][0]['gameBanners'][0]['bannerStats']");

        BannerStats[] bannerStats = new BannerStats[jsonArray.size()];

        for (int i=0;i<bannerStats.length; i++){
            //JsonArray jsonRarity = JsonPath.read(jsonArray.get(i),"$['gachaGames'][0]['gameBanners'][0]['bannerStats']["+i+"]['rarity]");
            String stringRarity = String.valueOf(JsonPath.read(jsonArray.get(i),"$['gachaGames'][0]['gameBanners'][0]['bannerStats']["+i+"]['rarity']"));
            //JsonArray jsonRarityProbability = JsonPath.read(jsonArray.get(i),"$['gachaGames'][0]['gameBanners'][0]['bannerStats']["+i+"][rarityProbability]");
            double doubleRarityProbability = Double.parseDouble(String.valueOf(JsonPath.read(jsonArray.get(i),"$['gachaGames'][0]['gameBanners'][0]['bannerStats']["+i+"]['rarityProbability']")));
            bannerStats[i] = new BannerStats(stringRarity, doubleRarityProbability);
        }

        String desiredRarity = switch (rarity) {
            case 1 -> "Uncommon";
            case 2 -> "Rare";
            case 3 -> "Ultra Rare";
            case 4 -> "Illustration Rare";
            case 5 -> "Special Illustration Rare";
            case 6 -> "Immersive";
            case 7 -> "Shiny Rare";
            case 8 -> "Double Shiny Rare";
            case 9 -> "Crown Rare";
            default -> null;
        };

            for (BannerStats bannerStat : bannerStats) {
                if (bannerStat.getRarity().equals(desiredRarity)) {
                    resultProbability = bannerStat.getRarityProbability();
                }
            }
        } catch (IOException e) {
            System.out.println(e);
        }

        return resultProbability;

    }
}
