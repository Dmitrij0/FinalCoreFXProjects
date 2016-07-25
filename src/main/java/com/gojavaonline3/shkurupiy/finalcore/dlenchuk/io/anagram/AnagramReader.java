package com.gojavaonline3.shkurupiy.finalcore.dlenchuk.io.anagram;

import java.io.Closeable;
import java.io.IOException;
import java.util.*;

/**
 * The contract of an anagrams adapter
 *
 * @author  Dmitrij Lenchuk
 */
public interface AnagramReader extends Closeable {

    int read(char[] cbuf, int off, int len) throws IOException;

    void close() throws IOException;

    int readAll() throws IOException;

    int size();

    boolean isEmpty();

    boolean containsKey(Object key);

    boolean containsValue(Object value);

    Set<String> get(Object key);

    Set<String> keySet();

    Collection<Set<String>> values();

    Set<Map.Entry<String, Set<String>>> entrySet();

}
