package com.gojavaonline3.shkurupiy.finalcore.dlenchuk.io.anagram;

import java.io.IOException;
import java.io.Reader;
import java.util.*;
import java.util.Map.Entry;

/**
 * There is the anagram adapter implementation
 *
 * @author  Dmitrij Lenchuk
 */
public class MapAnagramReader extends Reader implements AnagramReader {

    private Reader in;
    final private Map<String, Set<String>> anagrams;

    private String cashedWord;

    public MapAnagramReader(Reader in) {
        this.in = in;
        this.anagrams = new HashMap<>();
    }

    /*------------------------------------*/
    /*-------------- Reader --------------*/
    /*------------------------------------*/
    @Override
    public int read(char[] cbuf, int off, int len) throws IOException {
        synchronized (this) {
            ensureOpen();
            int charCount = in.read(cbuf, off, len);
            if (charCount > 0) {
                compute(charCount, cbuf);
            } else {
                flush();
            }
            return charCount;
        }
    }

    private void compute(int length, char[] cbuf, boolean cashing) {
        String inputString = (cashedWord == null ? "" : cashedWord) +
                String.valueOf(cbuf, 0, length).toLowerCase().replaceAll("\\p{Punct}+", " ");
        List<String> words = new ArrayList<>(Arrays.asList(inputString.split("\\s+")));
        int lastWordIndex = inputString.lastIndexOf(words.get(words.size() - 1));
        if (cashing) {
            cashedWord = inputString.substring(lastWordIndex);
            words.remove(words.size() - 1);
        } else {
            cashedWord = null;
        }

        words.forEach(item -> {
            if (item != null && !item.equals("")) {
                String key = sortWord(item);
                Set<String> wordAnagrams = anagrams.get(key);
                if (wordAnagrams == null) {
                    wordAnagrams = new HashSet<>();
                    anagrams.put(key, wordAnagrams);
                }
                wordAnagrams.add(item);
            }
        });
    }


    private void compute(int length, char[] cbuf) {
        compute(length, cbuf, true);
    }

    private void ensureOpen() throws IOException {
        if (in == null) {
            throw new IOException("Stream is closed");
        }
    }

    @Override
    public void close() throws IOException {
        synchronized (this) {
            flush();
            if (in == null)
                return;
            try {
                in.close();
            } finally {
                in = null;
            }
        }
    }

    public int readAll() throws IOException {
        int result = 0;
        int charCount;
        char[] buffer = new char[4096];
        while ((charCount = read(buffer, 0, buffer.length)) > 0) {
            result += charCount;
        }
        return result;
    }

    private void flush() {
        if (cashedWord != null && !cashedWord.equals(""))
            compute(0, new char[]{}, false);
        cashedWord = null;
    }

    private String sortWord(String word) {
        char[] chars = word.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    /*------------------------------------*/
    /*---------------- Map ---------------*/
    /*------------------------------------*/
    public int size() {
        return anagrams.size();
    }

    public boolean isEmpty() {
        return anagrams.isEmpty();
    }

    @SuppressWarnings("SuspiciousMethodCalls")
    public boolean containsKey(Object key) {
        return anagrams.containsKey(key);
    }

    public boolean containsValue(Object value) {
        return anagrams.containsKey(sortWord((String) value));
    }

    public Set<String> get(Object key) {
        return anagrams.get(sortWord((String) key));
    }

    public Set<String> keySet() {
        return anagrams.keySet();
    }

    public Collection<Set<String>> values() {
        return anagrams.values();
    }

    public Set<Entry<String, Set<String>>> entrySet() {
        return anagrams.entrySet();
    }

}
