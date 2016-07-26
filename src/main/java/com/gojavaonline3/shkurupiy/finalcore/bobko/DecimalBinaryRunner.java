package com.gojavaonline3.shkurupiy.finalcore.bobko;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.Scanner;

public class DecimalBinaryRunner {

    public static void main(String[] args) {


        String command = "";
        Scanner scanner = new Scanner(System.in);
        DecimalBinaryNumber number = new DecimalBinaryNumberConverter();
        while (!command.equals("exit")) {
            System.out.println("Enter command: set, dec, bin, exit");
            command = scanner.nextLine();
            if (command.equals("set")) {
                System.out.println("Enter number in decimal or binary (0bx..x) format:");
                command = scanner.nextLine();
                while (!command.equals("exit")) {
                    try {
                        number.setValue(command);
                        break;
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                        System.out.println("Enter number in decimal or binary (0bx..x) format or 'exit':");
                        command = scanner.nextLine();
                        continue;
                    }
                }
            } else if (command.equals("dec")) {
                System.out.println(number.getDecimalValue());
            } else if (command.equals("bin")) {
                System.out.println(number.getBinaryValue());
            } else if (command.equals("exit")) {
                break;
            } else {
                System.out.println("Command '" + command + "' not support!");
            }
        }

    }

}
