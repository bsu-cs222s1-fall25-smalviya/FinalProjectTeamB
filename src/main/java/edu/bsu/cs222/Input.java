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
        return Integer.parseInt(scanner.nextLine());
    }
    public int getUserRarity(String gameTitle) {
        return switch (gameTitle) {
            case "Pokemon TCGP" -> {
                System.out.print("Please enter a number for the rarity (0 - Uncommon, 1 - Rare, 2 - Ultra Rare, " +
                        "3 - Illustration Rare, 4 - Special Illustration Rare, 5 - Immersive, 6 - Shiny rare, 7 - Double Shiny Rare, 8 - Crown Rare): ");
                yield Integer.parseInt(scanner.nextLine());
            }
            case "Infinity Nikki" -> {
                System.out.print("Please enter the number for the rarity (0 - 3★, 1 - 4★, 2 - 5★): ");
                yield Integer.parseInt(scanner.nextLine());
            }
            case "Genshin Impact" -> {
                System.out.print("Please enter the number for your desired rarity: (0 - 3★, 1 - 4★, 2 - 5★): ");
                yield Integer.parseInt(scanner.nextLine());
            }
            default -> Integer.parseInt(scanner.nextLine());
        };

    }
    public String getUserBanner(String gameTitle) {
        String rarity = null;
        switch (gameTitle){
            case "Pokemon TCGP":
                System.out.print("Please enter a number for the banner (0 - Single Standard Booster Pack): ");
                rarity = scanner.nextLine();
                break;
            case "Infinity Nikki":
                System.out.print("Please enter a number for the banner (0 - Surprise-O-Matic, 1 - 5★ Resonance, 2 - 4★ Resonance): ");
                rarity = scanner.nextLine();
                break;
            case "Genshin Impact":
                System.out.print("Please enter a number for the banner (0 - Limited Character, 1 - 5★, 2 - 4★ )");
                rarity = scanner.nextLine();
                break;

        }
        return rarity;
    }
    public int getUserNumOfPulls(){
        System.out.print("Please enter the number of pulls: ");
        return Integer.parseInt(scanner.nextLine());
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
