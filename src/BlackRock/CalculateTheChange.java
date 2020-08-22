package BlackRock;

/*  Calculate the Change
    The goal of this question is to design a cash register program. Your register currently has the following notes/coins within it:
        o One Pence: 01
        o Two Pence: 02
        o Five Pence: 05
        o Ten Pence: 10
        o Twenty Pence: 20
        o Fifty Pence: 50
        o One Pound: 1
        o Two Pounds: 2
        o Five Pounds: 5
        o Ten Pounds: 10
        o Twenty Pounds: 20
        o Fifty Pounds: 50
    The aim of the program is to calculate the change that has to be returned to the customer with the least number of coins/notes.
    Note that the expectation is to have an object-oriented solution - think about creating classes for better reusability.

    Input:
    Your program should read lines of text from standard input (this is already part of the initial template).
    Each line contains two numbers which are separated by a semicolon.
    The first is the Purchase price (PP) and the second is the cash (CH) given by the customer.

    Output:
    For each line of input print a single line to standard output which is the change to be returned to the customer.
    If CH == PP print out Zero. If CH > PP, print the amount that needs to be returned (in terms of the currency values).
    Any other case where the result is an error, the output should be ERROR.

    The output should the change from highest to lowest denomination.

    Test 1:
    Input:
    20
    10
    Expected Output:
    ERROR

    Test 2:
    Input:
    8.75
    50
    Expected Output:
    Twenty Pounds, Twenty Pounds, One Pound, Twenty Pence, Five Pence

    Test 3:
    Input:
    11.25
    20
    Expected Output:
    Five Pounds, Two Pounds, One Pound, Fifty Pence, Twenty Pence, Five Pence
 */

import java.util.Scanner;

public class CalculateTheChange {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double price = sc.nextDouble();
        double cash = sc.nextDouble();
        if (price == cash) {
            System.out.print("Zero");
            return;
        }
        if (price > cash) {
            System.out.print("ERROR");
            return;
        }
        calculate(price, cash);
    }

    private static void calculate(double price, double cash) {
        double change = cash - price;
        StringBuilder sb = new StringBuilder();
        Money[] vals = Money.values();
        for (Money money : vals) {
            int amount = (int) (change / money.getVal());
            change -= amount * money.getVal();
            change = (double) (Math.round(change * 100)) / 100;
            if (amount != 0) {
                for (int i = 0; i < amount; i++) {
                    sb.append(money.getAmount()).append(", ");
                }
            }
            if (change == 0) {
                break;
            }
        }
        System.out.print(sb.substring(0, sb.length() - 2));
    }

    enum Money {
        Fifty_Pounds(50, "Fifty Pounds"), Twenty_Pounds(20, "Twenty Pounds"), Ten_Pounds(10, "Ten Pounds"), Five_Pounds(5, "Five Pounds"), Two_Pounds(2, "Two Pounds"), One_Pound(1, "One Pound"),
        Fifty_Pence(0.5, "Fifty Pence"), Twenty_Pence(0.2, "Twenty Pence"), Ten_Pence(0.1, "Ten Pence"), Five_Pence(0.05, "Five Pence"), Two_Pence(0.02, "Two Pence"), One_Pence(0.01, "One Pence");

        private double val;
        private String amount;

        private Money(double val, String amount) {
            this.val = val;
            this.amount = amount;
        }

        public double getVal() {
            return val;
        }

        public String getAmount() {
            return amount;
        }
    }
}
