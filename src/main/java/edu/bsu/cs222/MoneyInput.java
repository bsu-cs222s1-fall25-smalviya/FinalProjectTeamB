package edu.bsu.cs222;

import java.util.Scanner;

public class MoneyInput {
    private final Scanner scanner;

    public MoneyInput(Scanner scanner) {//Used for testing
        this.scanner = scanner;
    }

    public MoneyInput(){//This is the default input
        this.scanner = new Scanner(System.in);
    }

    public boolean UsingMoney(){

        System.out.print("Are you using money? Please enter yes of no: ");
        String answer = scanner.nextLine().trim().toLowerCase();
        return answer.equals("yes");
    }

    public int getUserGameInput(){

        System.out.print("Please enter the Gacha Game (Enter 1 for Pokemon TCGP, 2 for Infinity Nikki, or 3 for Genshin Impact): ");
        return Integer.parseInt(scanner.next());
    }
    public String chooseGame(){
        System.out.println("Please select the game you are spending money on...");
        System.out.println("Please enter 1 for Pokemon TCGP");
        System.out.println("Please enter 2 for Infinity Nikki");
        System.out.println("Please enter 3 for Genshin Impact");
        System.out.println("Please enter here: ");

        String game_input = scanner.nextLine().trim();

        return switch (game_input){
            case "1" -> "Pokemon TCGP";
            case "2" -> "Infinity Nikki";
            case "3" -> "Genshin Impact";
            default -> null;
        };
    }

    public boolean chooseMoneyMethod(){
        System.out.print("Enter 1 to calculate the general cost or enter 2 to calculate how many pulls you get with a budget: ");
        String method = scanner.nextLine().trim();
        return method.equals("1"); //true = cost, false = budget
    }
    public int pullsInput(){
        System.out.print("How many pulls are you paying for?: ");
        return Integer.parseInt(scanner.nextLine().trim());
    }
    public double budgetInput(){
        System.out.print("What's your budget?: $");
        return Double.parseDouble(scanner.nextLine().trim());
    }

}
