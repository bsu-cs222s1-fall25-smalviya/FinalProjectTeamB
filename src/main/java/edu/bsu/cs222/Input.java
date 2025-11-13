package edu.bsu.cs222;

import java.util.Scanner;

public class Input {
    private final Scanner scanner;

    public Input(Scanner scanner) {//Used for testing
        this.scanner = scanner;
    }

    public Input(){//This is the default input
        this.scanner = new Scanner(System.in);
    }
    public int getUserInput(){

        System.out.print("Please enter the Gacha Game (Enter 1 for Pokemon TCGP, 2 for Infinity Nikki, or 3 for Genshin Impact): ");
        return Integer.parseInt(scanner.next());
    }
    public int getUserRarity(String gameTitle) {
        int rarityswitch = 0;
        switch (gameTitle) {
            case "Pokemon TCGP":
                System.out.print("Please enter a number for your desired rarity (0 - Uncommon, 1 - Rare, 2 - Ultra Rare, " +
                        "3 - Illustration Rare, 4 - Special Illustration Rare, 5 - Immersive, 6 - Shiny rare, 7 - Double Shiny Rare, 8 - Crown Rare): ");
                rarityswitch = Integer.parseInt(scanner.next());
                break;
            case "Infinity Nikki":
                System.out.print("Please enter the number for your desired rarity (0 - 3-Star, 1 - 4-Star, 2 - 5-Star): ");
                rarityswitch = Integer.parseInt(scanner.next());
                break;
            case "Genshin Impact":
                System.out.print("Please enter the number for your desired rarity: (0 - 3-Star, 1 - 4-Star, 2 - 5-Star): ");
                rarityswitch = Integer.parseInt(scanner.next());
                break;
        }

        return rarityswitch;
    }
    public String getUserBanner(String gameTitle) {
        String banner = null;
        switch (gameTitle){
            case "Pokemon TCGP":
                System.out.print("Please enter a number for the banner (0 - Single Standard Booster Pack): ");
                banner = scanner.next();
                banner = "Single Booster Pack";
                break;
            case "Infinity Nikki":
                System.out.print("Please enter a number for the banner (0 - Surprise-O-Matic, 1 - 5-Star Resonance, 2 - 4-Star Resonance): ");
                banner = scanner.next();
                switch (banner){
                    case "0" ->
                            banner = "Surprise-O-Matic";
                    case "1" ->
                        banner = "5-Star Resonance";
                    case "2" ->
                        banner = "4-Star Resonance";
                }
                break;
            case "Genshin Impact":
                System.out.print("Please enter a number for the banner ()");
                banner = scanner.next();
                break;
        }
        return banner;
    }
    public int getUserNumOfPulls(){
        System.out.print("Please enter the number of pulls: ");
        return Integer.parseInt(scanner.next());
    }
}
