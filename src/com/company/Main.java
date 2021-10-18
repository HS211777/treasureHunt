package com.company;
import java.util.Random;
import java.util.Scanner;
public class Main {
    private static String[][] board = new String[10][8];
    private static int[][] treasure = new int[10][8];

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int totalCoins = 0;
        int found = 0;
        int tries = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 8; j++) {
                treasure[i][j] = 0;
            }
        }

        for (int i = 0; i < 5; i++) {
            randPos();
        }
        while (found < 5 && tries < 10){
            showBoard();
            System.out.println("Enter a y co-ordinate (1-8)");
            int usery = input.nextInt();
            while (usery > 8 || usery < 1){
                System.out.println("Enter a number between 1 and 8");
            }
            usery -= 1;

            System.out.println("Enter an x co-ordinate (1-10)");
            int userx = input.nextInt();
            while (userx > 10 || userx < 1){
                System.out.println("Enter a number between 1 and 10");
            }
            userx -= 1;

            totalCoins += treasure[userx][usery];
            if (treasure[userx][usery] > 0){
                board[userx][usery] = "[X]";
                found++;
            }
            else{
                board[userx][usery] = "[0]";
            }
            tries++;
        }
        System.out.println("you found "+totalCoins);

    }
    public static void showBoard(){
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 8; j++) {
                board[i][j] = "[ ]";
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }
    public static void randPos(){
        Random rn = new Random();
        int randy = rn.nextInt(10)+1;
        int randx = rn.nextInt(8)+1;
        treasure[randx][randy] = randCoins();
    }
    public static int randCoins(){
        Random rn = new Random();
        int coins = rn.nextInt(100)+1;
        return coins;
    }
}
