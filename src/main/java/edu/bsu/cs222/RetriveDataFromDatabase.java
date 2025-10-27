package edu.bsu.cs222;

import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;
import java.io.InputStream;
import java.util.Map;
// didn't end up using these two
import com.google.gson.*;
import java.io.*;

public class RetriveDataFromDatabase {

    public double gatchaGameProbability( String gameName, String bannerName,int rarity) {//works for all games(just testing for tcg tho)
        double resultProbability = 0;

        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("Database.json");
        if (inputStream == null) {
            System.err.println("Could not find Database.json!");
            return 0;
        }


        try {

            String query = String.format(
                    "$.[?(@.game == '%s')].gameBanner[?(@.bannerName == '%s')].bannerStats[*]",
                    gameName, bannerName
            );

            JSONArray jsonArray = JsonPath.read(inputStream, query);


            BannerStats[] bannerStats = new BannerStats[jsonArray.size()];

            for (int i = 0; i < bannerStats.length; i++) {
                Map<String, Object> stat = (Map<String, Object>) jsonArray.get(i);
                String stringRarity = (String) stat.get("rarity");
                double doubleRarityProbability = ((Number) stat.get("rarityProbability")).doubleValue();
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

            for (BannerStats stat : bannerStats) {
                if (stat.getRarity().equalsIgnoreCase(desiredRarity)) {
                    resultProbability = stat.getRarityProbability();
                    break;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return resultProbability;
    }
}
