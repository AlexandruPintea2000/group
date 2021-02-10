package com.napier.sem;

import java.sql.*;
import java.util.Scanner;

/**
 *
 */
public class Main {

    public static void main(String[] args){

        // present users choices
        int choice;
        Scanner sc = new Scanner(System.in);
        System.out.println("Please select one of the following options: ");
        System.out.println("1. Generate all the countries in the world organised by largest population to smallest");
        System.out.println("2. Generate all the countries in a continent organised by largest population to smallest");
        System.out.println("3. Generate all the countries in a region organised by largest population to smallest.");
        // get input from user
        choice = sc.nextInt();

        System.out.println("You selected " + choice);
    }
}
