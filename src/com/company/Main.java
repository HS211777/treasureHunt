package com.company;
import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;
public class Main {
    public static ArrayList<ArrayList<String>> board = new ArrayList<>();
    public static ArrayList<ArrayList<Integer>> treasure = new ArrayList<>();

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        for (int i = 0; i < 10; i++) {
            board.add(new ArrayList<>());
            for (int j = 0; j < 8; j++) {
                board.get(i).add("[ ]");
                System.out.print(board.get(i).get(j));
            }
            System.out.println();
        }
        int totalCoins = 0;
        int found = 0;
        int tries = 0;
        for (int i = 0; i < 10; i++) {
            treasure.add(new ArrayList<>());
            for (int j = 0; j < 8; j++) {
                treasure.get(i).add(0);
            }
        }

        for (int i = 0; i < 5; i++) {
            randPos();
        }
        while (found < 5 && tries < 10){
            System.out.println("Enter a y co-ordinate (1-8)");
            int usery = input.nextInt();
            while (usery > 8 || usery < 1){
                System.out.println("Enter a number between 1 and 8");
                usery = input.nextInt();
            }
            usery -= 1;

            System.out.println("Enter an x co-ordinate (1-10)");
            int userx = input.nextInt();
            while (userx > 10 || userx < 1){
                System.out.println("Enter a number between 1 and 10");
                userx = input.nextInt();
            }
            userx -= 1;

            totalCoins += treasure.get(userx).get(usery);
            if (treasure.get(userx).get(usery) > 0){
                board.get(userx).set(usery,"[X]");
                found++;
            }
            else{
                board.get(userx).set(usery,"[0]");
            }
            showBoard();
            tries++;
        }
        System.out.println("you found "+totalCoins);

    }
    public static void showBoard(){
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(board.get(i).get(j));
            }
            System.out.println();
        }
    }
    public static void randPos(){
        Random rn = new Random();
        int randy = rn.nextInt(10)+1;
        int randx = rn.nextInt(8)+1;
        treasure.get(randx).set(randy,randCoins());
    }
    public static int randCoins(){
        Random rn = new Random();
        int coins =  rn.nextInt(100)+1;
        return coins;
    }
}
