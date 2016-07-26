package com.gojavaonline3.shkurupiy.finalcore.bobko;

import java.util.Scanner;

public class PresentationDecimalBinaryRunner {

    public static void main(String[] args) {
        DecimalBinaryNumber number = new DecimalBinaryNumberConverter();
        System.out.println("Enter command: set, dec, bin, exit");
        System.out.println("set");
        System.out.println("Enter number in decimal or binary (0bx..x) format:");
        System.out.println("956");
        number.setValue("956");
        System.out.println("Enter command: set, dec, bin, exit");
        System.out.println("bin");
        System.out.println(number.getBinaryValue());
        System.out.println("Enter command: set, dec, bin, exit");
        System.out.println("set");
        System.out.println("Enter number in decimal or binary (0bx..x) format:");
        System.out.println("0b1011011100");
        number.setValue("0b1011011100");
        System.out.println("Enter command: set, dec, bin, exit");
        System.out.println("dec");
        System.out.println(number.getDecimalValue());
        System.out.println("Enter command: set, dec, bin, exit");
        System.out.println("exit");

    }

}
