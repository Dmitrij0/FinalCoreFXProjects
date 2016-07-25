package com.gojavaonline3.shkurupiy.finalcore.dlenchuk;

import com.gojavaonline3.shkurupiy.finalcore.dlenchuk.io.anagram.MapAnagramReader;

import java.io.*;
import java.net.URL;

public class AnagramRunner {

    private static final String URL_STRING = "https://habrahabr.ru/post/77382/";
//    private static final String FILE_STRING = "d:/Temp/Book.fb2";

    public static void main(String[] args) {

        try (MapAnagramReader reader =
                     new MapAnagramReader(new BufferedReader(new InputStreamReader(
                             new URL(URL_STRING).openStream())))) {
//        try (MapAnagramReader reader =
//                     new MapAnagramReader(new BufferedReader(new InputStreamReader(
//                             new FileInputStream(new File(FILE_STRING)))))) {

            reader.readAll();
            System.out.println(reader.entrySet());

            reader.entrySet().forEach(item -> {
                if (item.getValue().size() > 1) {
                    System.out.println(item);
                }
            });
            System.out.println(reader.size());

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
