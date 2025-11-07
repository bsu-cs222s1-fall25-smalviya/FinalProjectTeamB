package edu.bsu.cs222;

import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;
import java.io.InputStream;
import java.util.Map;


public class RetrieveDataFromDatabase {

    public double gachaGameProbability(String gameName, String bannerName, int rarity) {
        double resultProbability = 0;

        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("DatabaseCopy.json");
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
                double doubleRarityPityProbability = ((Number) stat.get("rarityPityProbability")).doubleValue();
                int pityCount = ((Number) stat.get("rarityPityCount")).intValue();
                bannerStats[i] = new BannerStats(stringRarity, doubleRarityProbability, doubleRarityPityProbability, pityCount);
            }

            String desiredRarity = switch (rarity) {
                case 0 -> bannerStats[0].getRarity();
                case 1 -> bannerStats[1].getRarity();
                case 2 -> bannerStats[2].getRarity();
                case 3 -> bannerStats[3].getRarity();
                case 4 -> bannerStats[4].getRarity();
                case 5 -> bannerStats[5].getRarity();
                case 6 -> bannerStats[6].getRarity();
                case 7 -> bannerStats[7].getRarity();
                case 8 -> bannerStats[8].getRarity();
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
