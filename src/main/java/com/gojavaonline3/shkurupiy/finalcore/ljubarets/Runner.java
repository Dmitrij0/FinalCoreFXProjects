package com.gojavaonline3.shkurupiy.finalcore.ljubarets;

import java.io.IOException;
import java.util.Scanner;

/**
 * Created by Denis Ljubarets on 7/10/16.
 * GoIT Java #3
 */
public class Runner {
    public static void main(String[] args) {

//        Scanner scanner = new Scanner(System.in);
//        System.out.print("URL: ");
//        String resource = scanner.nextLine().trim();
//        System.out.print("Path: ");
//        String location = scanner.nextLine().trim();
//        System.out.print("Extension: ");
//        String extension = scanner.nextLine().trim();

        String resource, location, extension;
        System.out.println("URL: " + (resource = "http://www.ex.ua/103078976?r=3,23776"));
        System.out.println("Path: " + (location = System.getProperty("user.dir")));
        System.out.println("Extension: " + (extension = "mp3"));

        try {
            Downloader downloader = new EXUADownloader(resource, location, extension);
            int count = downloader.get();
            System.out.println("Downloaded: " +count);
        } catch (NotFoundException | IOException e) {
            System.out.println(e.getMessage());
        }

    }
}
