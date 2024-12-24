package com.example.educationalprojects;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

        public static void main(String args[]){

            Random rand = new Random();
            int number = rand.nextInt(100);

            Scanner input = new Scanner(System.in);
            int right = 0;
            int selected;
            int[] wrong = new int[5];
            boolean isWin = false;
            boolean isWrong = false;


            while(right < 5){
                System.out.println("Your Input Guess: ");
                selected = input.nextInt();
                if (selected < 0  || selected > 99) {
                    System.out.println("Please input a value between 0-100!");
                    if (isWrong){
                        right++;
                        System.out.println("Too many wrong input!. Left rights: " + (5 - right));

                    } else {
                        isWrong = true;
                        System.out.println("Your right it will be reduced with Next wrong guess");
                    }
                    continue;
                }
                if (selected == number){
                    System.out.println("Congrats! Your Guess Right =) : " + number);
                    isWin = true;
                    break;
                } else {
                    System.out.println("Your input is wrong!");
                    if (selected > number){
                        System.out.println( selected +" is greater than the secret number! ");
                    } else {
                        System.out.println(selected + " is smaller than the secret number! ");
                    }
                    wrong[right++] = selected;

                    System.out.println( "Your right: " + (5 - right ));
                }
            }
            if (!isWin){
                System.out.println("You Lost!");
                System.out.println("Your Guess and Not Secret Number: " + Arrays.toString(wrong));
            }
        }
    }

