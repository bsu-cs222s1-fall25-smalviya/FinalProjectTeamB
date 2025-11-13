package edu.bsu.cs222;

public class How {
    public void howItsDone(String gameTitle){
        System.out.println("How It's Done");
        switch (gameTitle){
            case "Pokemon TCGP":
                System.out.println("Pokemon TCGP");
                System.out.println("General Formula: 1-(1-p)n\n" +
                        "P = chance of pulling what you want\n" +
                        "N = number of pulls\n");
                System.out.println("Drop Rates for Standard Booster Packs\n" +
                        "Card 1-3\n" +
                        "Common: 100%\n" +
                        "Card 4\n" +
                        "Uncommon: 89%\n" +
                        "Rare: 4.952%\n" +
                        "Double Rare and Ultra Rare: 1.666%\n" +
                        "Illustration Rare: 2.572%\n" +
                        "Special Illustration Rare: 0.5%\n" +
                        "Immersive Cards: 0.222%\n" +
                        "Shiny Rare: 0.714%\n" +
                        "Double Shiny Rare: 0.333%\n" +
                        "Crown Rare: 0.04%\n" +
                        "Card 5\n" +
                        "Uncommon: 56%\n" +
                        "Rare: 19.81%\n" +
                        "Double Rare and Ultra Rare: 6.664%\n" +
                        "Illustration Rare: 10.288%\n" +
                        "Special Illustration Rare: 2%\n" +
                        "Immersive Cards: 0.888%\n" +
                        "Shiny Rare: 2.857%\n" +
                        "Double Shiny Rare: 1.333%\n" +
                        "Crown Rare: 0.16%\n");
                break;

             case "Infinity Nikki":
                 System.out.println("Infinity Nikki");
                 System.out.println("Surprise-O-Matic\n" +
                         "20,000 Blings per pull (x10 for 200,000)\n" +
                         "No pity system\n" +
                         "5★ Piece: 0.8%\n" +
                         "4★ Piece: 1.6%\n" +
                         "3★ Piece: 97.6%\n" +
                         "5★ Resonance\n" +
                         "Every 10 draws guarantees at least one 4★ or higher\n" +
                         "3★: 82.44%\n" +
                         "4★: \n" +
                         "Base: 3.29%\n" +
                         "Pity: 11.50%\n" +
                         "Pity Count: 10\n" +
                         "5★:\n" +
                         "Base: 1.5%\n" +
                         "Pity: 6.06%\n" +
                         "Pity Count: 20\n");
                 break;

             case "Genshin Impact":
                 System.out.println("Genshin Impact");
                 System.out.println("Limited Character Banner\n" +
                         "160 primos per pull(1600 primos = 10 pull)\n" +
                         "Pulls 1-75 5-star: 0.06% | pulls 76-89 5-star: +6% each pull\n" +
                         " 4-star item = 5.100%; base probability of winning 4-star character = 2.550%, and base probability of winning 4-star weapon = 2.550%; consolidated probability (incl. guarantee) of winning 4-star item = 13.000%; guaranteed to win 4-star or above item at least once per 10 attempts; probability of winning 4-star item through the guarantee = 99.400%, and probability of winning 5-star item through the guarantee = 0.600%.");
                 break;

        }
    }
}
