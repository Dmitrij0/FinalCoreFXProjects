package com.gojavaonline3.shkurupiy.finalcore.dlenchuk;

import com.gojavaonline3.shkurupiy.finalcore.dlenchuk.collections.mergesort.SimpleArrayList;
import com.gojavaonline3.shkurupiy.finalcore.dlenchuk.collections.mergesort.SimpleList;

/**
 * Created by Dmitrij Lenchuk on 05.06.2016.
 * List Runner
 */
public class MergeRunner {
    public static void main(String[] args) {

        System.out.println("Merge Sort of Integer...");

        Integer[] arrayOfInteger = new Integer[(int) (Math.random()*100)];
        for (int i = 0; i < arrayOfInteger.length; i++) {
            arrayOfInteger[i] = (int) (Math.random()*1_000);
        }
        SimpleArrayList<Integer> listInteger = new SimpleArrayList<>(arrayOfInteger);
        System.out.println(listInteger);
        System.out.println(listInteger.sort());

    }

}
