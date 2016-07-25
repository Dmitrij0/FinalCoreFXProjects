package com.gojavaonline3.shkurupiy.finalcore.dlenchuk.io.anagram;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.StringReader;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

import static org.junit.Assert.*;

public class MapAnagramReaderTest {

    private MapAnagramReader reader;

    private static final String ORIGINAL_STRING =
            "This is the anagram string. irSgnt aagmnra si hisT eht. irgnSt agmanra is isTh hte.";

    @Before
    public void setUp() throws Exception {
        reader = new MapAnagramReader(new StringReader(ORIGINAL_STRING));
    }

    @Test
    public void read() throws Exception {
        int originalLength = ORIGINAL_STRING.length();
        char[] cbuf = new char[originalLength];
        int charCount = reader.read(cbuf, 0, originalLength);
        assertEquals("The length of the original string is '" + originalLength +
                "' but it is read '" + charCount + "' chars", originalLength, charCount);
        assertTrue("\nExpected: \"" + ORIGINAL_STRING + "\"\n" +
                        "Actual: \"" + (cbuf.length == 0 ? null : String.valueOf(cbuf)) + "\"",
                Arrays.equals(ORIGINAL_STRING.toCharArray(), cbuf));
    }

    @Test(expected = IOException.class)
    public void close() throws Exception {
        reader.close();
        char[] cbuf = new char[ORIGINAL_STRING.length()];
        reader.read(cbuf, 0, ORIGINAL_STRING.length());
    }

    @Test
    public void readAll() throws Exception {
        assertEquals("An error of the loading", ORIGINAL_STRING.length(), reader.readAll());
        assertEquals("The original string contains '5' anagrams. But actual is '" + reader.size() + '\'',
                5, reader.size());
    }

    @Test
    public void size() throws Exception {
        assertEquals("The Map is empty. But actual is '" + reader.size() + '\'',
                0, reader.size());
        reader.readAll();
        assertEquals("The original string contains '5' anagrams. But actual is '" + reader.size() + '\'',
                5, reader.size());
    }

    @Test
    public void isEmpty() throws Exception {
        assertTrue("The Map is empty", reader.isEmpty());
        reader.readAll();
        assertFalse("The Map is not empty", reader.isEmpty());
    }

    @Test
    public void containsKey() throws Exception {
        assertFalse("The Map is empty", reader.containsKey("the"));
        reader.readAll();
        assertTrue("The Map contains a key", reader.containsKey("eht"));
    }

    @Test
    public void containsValue() throws Exception {
        assertFalse("The Map is empty", reader.containsValue("the"));
        reader.readAll();
        assertTrue("The Map contains a value", reader.containsValue("the"));
    }

    @Test
    public void get() throws Exception {
        Set<String> anagramSet = reader.get("the");
        assertTrue("The Set is empty", anagramSet == null || anagramSet.size() == 0);
        reader.readAll();
        anagramSet = reader.get("the");
        assertTrue("The Set is not empty", anagramSet != null);
        assertEquals(3, anagramSet.size());
        assertTrue(anagramSet.contains("the"));
        assertTrue(anagramSet.contains("eht"));
        assertTrue(anagramSet.contains("hte"));
    }

    @Test
    public void keySet() throws Exception {
        Set<String> stringSet = reader.keySet();
        assertTrue("The Set is empty", stringSet == null || stringSet.size() == 0);
        reader.readAll();
        stringSet = reader.keySet();
        assertTrue("The Map contains a value",
                stringSet.containsAll(Arrays.asList("hist", "is", "eht", "aaagmnr", "ginrst")));
    }

    @Test
    public void values() throws Exception {
        Collection<Set<String>> values = reader.values();
        assertTrue("The List is empty", values == null || values.size() == 0);
        reader.readAll();
        values = reader.values();
        assertEquals(5, values.size());
    }

    @Test
    public void entrySet() throws Exception {
        Set<Map.Entry<String, Set<String>>> entries = reader.entrySet();
        assertTrue("The List is empty", entries == null || entries.size() == 0);
        reader.readAll();
        entries = reader.entrySet();
        assertEquals(5, entries.size());
    }

}