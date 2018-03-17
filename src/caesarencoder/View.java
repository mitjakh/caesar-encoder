package caesarencoder;

import java.util.Scanner;

public class View
{
    Scanner scanner = new Scanner(System.in);

    public String initializeText()
    {
        System.out.println("Lab1.1. Caesar cypher\nNNIIDS-371 Khomenko Dmytro\nEnter text you want to encode below:");
        return scanner.nextLine();
    }

    public int initializeKey()
    {
        System.out.println("Enter key: ");
        return scanner.nextInt();
    }

    public void displayResult(String result)
    {
        System.out.println("Cyphered text: " + result);
    }
}
