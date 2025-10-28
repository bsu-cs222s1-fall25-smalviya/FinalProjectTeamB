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
    public int getUserRarity() {
        System.out.print("Please enter a number for the rarity (1-Uncommon, 2-Rare, 3-Ultra Rare, 4-Illustration Rare, 5-Special Illustration Rare, 6-Immersive, 7-Shiny rare, 8-Double Shiny Rare, 9-Crown Rare): ");
        return Integer.parseInt(scanner.nextLine());
    }
    public String getUserBanner() {
        System.out.print("Please enter game banner/pack: ");
        return scanner.nextLine();
    }
    public int getUserNumOfPulls(){
        System.out.print("Please enter the number of pulls: ");
        return Integer.parseInt(scanner.nextLine());
    }
}
