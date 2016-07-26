package com.gojavaonline3.shkurupiy.finalcore.dlenchuk;

import com.gojavaonline3.shkurupiy.finalcore.dlenchuk.io.anagram.MapAnagramReader;

import java.io.*;
import java.net.URL;

public class AnagramRunner {

    public static void main(String[] args) {

        try (MapAnagramReader reader = new MapAnagramReader(new BufferedReader(new InputStreamReader(
                AnagramRunner.class.getResourceAsStream("/dlenchuk/SomeBook.fb2"))))) {

            reader.readAll();

            reader.entrySet().forEach(item -> {
                if (item.getValue().size() > 1) {
                    System.out.println(item);
                }
            });
            System.out.println("Total nodes: " + reader.size());

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
