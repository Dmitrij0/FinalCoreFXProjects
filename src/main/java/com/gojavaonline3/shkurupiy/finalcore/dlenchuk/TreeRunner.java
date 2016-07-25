package com.gojavaonline3.shkurupiy.finalcore.dlenchuk;


import com.gojavaonline3.shkurupiy.finalcore.dlenchuk.collections.traversal.SimpleTreeMap;
import com.gojavaonline3.shkurupiy.finalcore.dlenchuk.collections.traversal.Traversal;

import java.util.Map;

public class TreeRunner {

    public static void main(String[] args) {
        Map<Integer, String> inMap = new SimpleTreeMap<>();
        inMap.put(2, "String 08");
        inMap.put(9, "String 01");
        inMap.put(5, "String 05");
        inMap.put(6, "String 04");
        inMap.put(7, "String 03");
        inMap.put(1, "String 09");
        inMap.put(4, "String 06");
        inMap.put(8, "String 02");
        inMap.put(3, "String 07");

        Traversal<Map.Entry<Integer, String>> map = new SimpleTreeMap<>(inMap);
        System.out.println("---------------inOrderIterator---------------");
        map.inOrderIterator().forEachRemaining(System.out::println);
        System.out.println("");
        System.out.println("---------------preOrderIterator---------------");
        map.preOrderIterator().forEachRemaining(System.out::println);
        System.out.println("---------------postOrderIterator---------------");
        map.postOrderIterator().forEachRemaining(System.out::println);

    }

}
