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
}
