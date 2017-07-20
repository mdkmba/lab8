package com.GCircus;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scnr = new Scanner(System.in);
        int atBats = 0;
        int hitCount = 0;
        int baseEarnedCount = 0;
        double battingAve = 0;
        double sluggingPercentage = 0;
        int[] basesEarnedarray;
        boolean doLoop = true;
        int test = 0;

        System.out.println("\n\n\nWelcome to the Batting Average Calculator");

        do {
            do {
                System.out.print("\n\nEnter times at-bat: ");
                while (!scnr.hasNextInt()) { //Prevent user from entering non-integers/garbage
                    String input = scnr.next();
                    System.out.printf("\n%s is not a valid integer. Try again.\nEnter times at-bat: ", input);
                }
                atBats = scnr.nextInt();
                if (atBats <= 1) {
                    System.out.printf("\n%s is not a valid integer.\nAt least 2 at-bats are needed to get a true average. Try again.\n", atBats);
                }
            } while (atBats <= 1);


            basesEarnedarray = new int[atBats];

            System.out.print("\n\nPlease enter the result of each at bat: ");
            System.out.println("\n\n0=out, 1=single, 2=double, 3=triple, 4=home run");

            while (test < atBats) {
                if (test == atBats - 1) {
                    System.out.printf("Number %s Last entry.\nResult for at-bat %s: ", atBats , test + 1);
                } else {
                    System.out.printf("Result for at-bat %s: ", test + 1);
                }
                while (!scnr.hasNextInt()) { //Prevent user from entering non-integers/garbage
                    String input = scnr.next();
                    System.out.printf("%s is not a valid integer. Please re-enter result for at-Bat %s: ", input, test + 1);
                    scnr.nextLine();
                }
                basesEarnedarray[test] = scnr.nextInt();

                if (basesEarnedarray[test] < 0 || basesEarnedarray[test] > 4) {
                    System.out.println("Invalid entry");
                } else {
                    test++;
                }

            }
            for (int c : basesEarnedarray
                    ) {
                if (c > 0) {
                    hitCount++;
                }
                baseEarnedCount += c;
            }
            battingAve = hitCount / (double) atBats;
            sluggingPercentage = baseEarnedCount / (double) atBats;

            System.out.printf("\n\nBatting average: %.3f", battingAve);
            System.out.printf("\nSlugging percentage: %.3f\n\n", sluggingPercentage);

            while(doLoop) {
                System.out.print("Another batter? (y/n): ");
                scnr.nextLine();

                String decide = scnr.nextLine();
                if (decide.equalsIgnoreCase("n")) {
                    doLoop = false;
                }

                else if (decide.equalsIgnoreCase("y")){
                    atBats = 0;
                    hitCount = 0;
                    baseEarnedCount = 0;
                    battingAve = 0;
                    sluggingPercentage = 0;
                    test = 0;
                    break;
                }
                else if (!decide.equalsIgnoreCase("n") || (!decide.equalsIgnoreCase("y"))){
                    System.out.println("Please enter y or n");
                }
            }
        } while (doLoop);

    }
}