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
        switch (gameTitle) {
            case "1":
                System.out.print("Please enter a number for the rarity (0 - Uncommon, 1 - Rare, 2 - Ultra Rare, " +
                        "3 - Illustration Rare, 4 - Special Illustration Rare, 5 - Immersive, 6 - Shiny rare, 7 - Double Shiny Rare, 8 - Crown Rare): ");
                return Integer.parseInt(scanner.nextLine());
            case "2":
                System.out.print("Please enter the number for the rarity (0 - 3★, 1 - 4★, 2 - 5★): ");
                return Integer.parseInt(scanner.nextLine());
            case "3":
                System.out.print("Please enter the number for your desired rarity: (0 - 3★, 1 - 4★, 2 - 5★): ");
                return Integer.parseInt(scanner.nextLine());
        }

        return Integer.parseInt(scanner.nextLine());
    }
    public String getUserBanner(String gameTitle) {
        String rarity = null;
        switch (gameTitle){
            case "1":
                System.out.print("Please enter a number for the banner (0 - Single Standard Booster Pack): ");
                rarity = scanner.next();
            case "2":
                System.out.print("Please enter a number for the banner (0 - Surprise-O-Matic, 1 - 5★ Resonance, 2 - 4★ Resonance): ");
                rarity = scanner.next();
            case "3":
                System.out.print("Please enter a number for the banner ()");
                rarity = scanner.next();
        }
        return rarity;
    }
    public int getUserNumOfPulls(){
        System.out.print("Please enter the number of pulls: ");
        return Integer.parseInt(scanner.nextLine());
    }
}
