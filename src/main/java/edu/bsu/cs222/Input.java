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
        int rarity;
        switch (gameTitle) {
            case "Pokemon TCGP" -> {
                System.out.print("Please enter a number for the rarity (0 - Uncommon, 1 - Rare, 2 - Ultra Rare, " +
                        "3 - Illustration Rare, 4 - Special Illustration Rare, 5 - Immersive, 6 - Shiny rare, 7 - Double Shiny Rare, 8 - Crown Rare): ");
                rarity = Integer.parseInt(scanner.next());
                break;
            }
            case "Infinity Nikki" -> {
                System.out.print("Please enter the number for the rarity (0 - 3-Star, 1 - 4-Star, 2 - 5-Star): ");
                rarity = Integer.parseInt(scanner.next());
                break;
            }
            case "Genshin Impact" -> {
                System.out.print("Please enter the number for your desired rarity: (0 - 3-Star, 1 - 4-Star, 2 - 5-Star): ");
                rarity = Integer.parseInt(scanner.next());
                break;
            }
            default -> rarity = Integer.parseInt(null);
        }
        return rarity;
    }

    public String getUserBanner(String gameTitle) {
        String rarity = null;
        switch (gameTitle){
            case "Pokemon TCGP":
                System.out.print("Please enter a number for the banner (0 - Single Standard Booster Pack): ");
                rarity = scanner.next();
                rarity = "Single Standard Booster Pack";
                break;
            case "Infinity Nikki":
                System.out.print("Please enter a number for the banner (0 - Surprise-O-Matic, 1 - 5-Star Resonance, 2 - 4-Star Resonance): ");
                rarity = scanner.next();
                switch (rarity){
                    case "0" ->
                        rarity = "Surprise-O-Matic";
                    case "1" ->
                        rarity = "5-Star Resonance";
                    case "2" ->
                        rarity = "4-Star Resonance";
                }
                break;
            case "Genshin Impact":
                System.out.print("Please enter a number for the banner (0 - Limited Character, 1 - 5-Star, 2 - 4-Star )");
                rarity = scanner.next();
                switch (rarity){
                    case "0" ->
                        rarity = "Limited Character";
                    case "1" ->
                        rarity = "5-Star";
                    case  "2" ->
                        rarity = "4-Star";
                }
                break;
        }
        return rarity;
    }

    public int getUserNumOfPulls(){
        System.out.print("Please enter the number of pulls: ");
        return Integer.parseInt(scanner.next());
    }

    public boolean genshinQuestion(String gameTitle){

        if (!gameTitle.equals("Genshin Impact")) {
            return false;
        }
        System.out.print("Are you guaranteed? Please enter yes of no: ");
        String answer = scanner.nextLine().trim().toLowerCase();
        return answer.equals("yes");
    }
}
