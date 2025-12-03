package edu.bsu.cs222;

import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;

import java.io.InputStream;
import java.util.Map;


public class RetrieveDataFromDatabase {

    public BannerStats gachaGameProbability(String gameName, String bannerName, int rarity) {
        BannerStats result = null;

        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("DatabaseCopy.json");
        if (inputStream == null) {
            System.err.println("Could not find Database.json!");
            return null;
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

            switch (rarity) {
                case 0:
                    result = bannerStats[0];
                    // System.out.println(JSONArray.toJSONString(List.of(bannerStats [0])));
                    break;
                case 1:
                    result = bannerStats[1];
                    // System.out.println(JSONArray.toJSONString(List.of(bannerStats[1])));
                    break;
                case 2:
                    result = bannerStats[2];
                    // System.out.println(JSONArray.toJSONString(List.of(bannerStats[2])));
                    break;
                case 3:
                    result = bannerStats[3];
                    // System.out.println(JSONArray.toJSONString(List.of(bannerStats[3])));
                    break;
                case 4:
                    result = bannerStats[4];
                    // System.out.println(JSONArray.toJSONString(List.of(bannerStats[4])));
                    break;
                case 5:
                    result = bannerStats[5];
                    //System.out.println(JSONArray.toJSONString(List.of(bannerStats[5])));
                    break;
                case 6:
                    result = bannerStats[6];
                    // System.out.println(JSONArray.toJSONString(List.of(bannerStats[6])));
                    break;
                case 7:
                    result = bannerStats[7];
                    // System.out.println(JSONArray.toJSONString(List.of(bannerStats[7])));
                    break;
                case 8:
                    result = bannerStats[8];
                    //System.out.println(JSONArray.toJSONString(List.of(bannerStats[8])));
                    break;

                default:
                    throw new IllegalStateException("Unexpected value: " + rarity);
            }


        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }
}
