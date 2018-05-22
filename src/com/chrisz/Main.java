package com.chrisz;

public class Main {

    // ** create a constant ** -> final indicates constant
    private static final String INVALID_VALUE = "Invalid value";

    public static void main(String[] args) {
        // ***** METHOD OVERLOADING ********
        // Defining two methods with same name, as long as we use different parameters
        // Good practice as you need to remember one name for a method
        int newScore = calculateScore("Chris", 500);
        System.out.println("New score is " + newScore);
        calculateScore(400);
        calculateScore();
        System.out.println(calcFeetAndInchesToCentimeters(8));
        System.out.println(getDurationString(65, 45));
        System.out.println(getDurationString(60));

        // *** Challenge 3 ***
        System.out.println(area(5));
        System.out.println(area(-1, 4.0));

    }
    // two parameters
    public static int calculateScore(String playerName, int score) {
        System.out.println("Player " + playerName + " scored " + score + " points.");
        return score * 1000;
    }

    // one parameter
    public static int calculateScore(int score) {
        System.out.println("Unnamed player scored " + score + " points.");
        return score * 1000;
    }

    // no parameters
    public static int calculateScore() {
        System.out.println("No player name, no player score");
        return 0;
    }

    // won't work
//    public static void calculateScore() {
//        System.out.println("No player name, no player score");
//    }

    // Challenge
    public static double calcFeetAndInchesToCentimeters(int feet, int inches) {
        if(feet >= 0 && inches >= 0 && inches <= 12) { // redundant but following instructions
            inches += feet*12;
            double cm = inches*2.54;
            return cm;
        }
        return -1;
    }

    public static double calcFeetAndInchesToCentimeters(int inches) {
        if(inches >= 0) {
            int feet = inches / 12;
            inches %= 12;
            return calcFeetAndInchesToCentimeters(feet, inches);
        }
        return -1;
    }

    // Challenge 2
    public static String getDurationString(int minutes, int seconds) {
        if(minutes >=0 && seconds >= 0 && seconds < 60) {
           int hours = minutes / 60;
           minutes %= 60;

           String hoursString = (hours < 10) ? "0" + hours + "h" : hours + "h";
           String minutesString = (minutes < 10) ? "0" + minutes + "m" : minutes + "m";
           //String secondsString = (seconds < 10) ? "0" + seconds + "s" : seconds + "s";

            // another way of getting a leading zero for values less than 10
           String secondsString = String.format("%02d", seconds) + "s";
           return hoursString + " " + minutesString + " " + secondsString;
        }
        return INVALID_VALUE;
    }

    public static String getDurationString(int seconds) {
        if(seconds >= 0) {
            int minutes = seconds / 60;
            seconds %= 60;
            return getDurationString(minutes, seconds);
        }
        return INVALID_VALUE;
    }

    // ***************** Challenge 3 ***********************
    public static double area(double radius) {
        if(radius >=0) {
            return 3.14159*Math.pow(radius,2);
        }
        return -1;
    }
    public static double area(double x, double y) {
        if(x >=0 && y >=0) {
            return x*y;
        }
        return -1;
    }
}
