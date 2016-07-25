package com.gojavaonline3.shkurupiy.finalcore.dlenchuk.collections.traversal;

import org.junit.Before;
import org.junit.Test;


import java.util.*;

import static org.junit.Assert.*;

public class SimpleTreeMapTest {

    private SimpleTreeMap<Integer, String> simpleTreeMap;

    @Before
    public void setUp() throws Exception {
        simpleTreeMap = new SimpleTreeMap<>();
        simpleTreeMap.put(2, "String 08");
        simpleTreeMap.put(9, "String 01");
        simpleTreeMap.put(5, "String 05");
        simpleTreeMap.put(6, "String 04");
        simpleTreeMap.put(7, "String 03");
        simpleTreeMap.put(1, "String 09");
        simpleTreeMap.put(4, "String 06");
        simpleTreeMap.put(8, "String 02");
        simpleTreeMap.put(3, "String 07");
    }

    @Test
    public void lowerEntry() throws Exception {
        Map.Entry<Integer, String> entry = simpleTreeMap.lowerEntry(5);
        assertEquals((Integer) 4, entry.getKey());
        assertEquals("String 06", entry.getValue());
        assertNull(simpleTreeMap.lowerEntry(1));

        simpleTreeMap.put(200, "String 08");
        simpleTreeMap.put(900, "String 01");
        simpleTreeMap.put(500, "String 05");
        simpleTreeMap.put(600, "String 04");
        simpleTreeMap.put(700, "String 03");
        simpleTreeMap.put(100, "String 09");
        simpleTreeMap.put(400, "String 06");
        simpleTreeMap.put(800, "String 02");
        simpleTreeMap.put(300, "String 07");

        assertEquals((Integer) 9, ((Map.Entry<Integer, String>) simpleTreeMap.lowerEntry(50)).getKey());
        assertEquals((Integer) 9, ((Map.Entry<Integer, String>) simpleTreeMap.lowerEntry(100)).getKey());
        assertEquals((Integer) 100, ((Map.Entry<Integer, String>) simpleTreeMap.lowerEntry(150)).getKey());
        assertEquals((Integer) 200, ((Map.Entry<Integer, String>) simpleTreeMap.lowerEntry(250)).getKey());
        assertEquals((Integer) 300, ((Map.Entry<Integer, String>) simpleTreeMap.lowerEntry(350)).getKey());
        assertEquals((Integer) 400, ((Map.Entry<Integer, String>) simpleTreeMap.lowerEntry(450)).getKey());
        assertEquals((Integer) 500, ((Map.Entry<Integer, String>) simpleTreeMap.lowerEntry(550)).getKey());
        assertEquals((Integer) 600, ((Map.Entry<Integer, String>) simpleTreeMap.lowerEntry(650)).getKey());
        assertEquals((Integer) 700, ((Map.Entry<Integer, String>) simpleTreeMap.lowerEntry(750)).getKey());
        assertEquals((Integer) 800, ((Map.Entry<Integer, String>) simpleTreeMap.lowerEntry(850)).getKey());
        assertEquals((Integer) 900, ((Map.Entry<Integer, String>) simpleTreeMap.lowerEntry(950)).getKey());
        assertEquals((Integer) 900, ((Map.Entry<Integer, String>) simpleTreeMap.lowerEntry(10000)).getKey());
    }

    @Test
    public void lowerKey() throws Exception {
        assertEquals((Integer) 4, simpleTreeMap.lowerKey(5));
        assertNull(simpleTreeMap.lowerKey(1));
    }

    @Test
    public void floorEntry() throws Exception {
        Map.Entry<Integer, String> entry = simpleTreeMap.floorEntry(5);
        assertEquals((Integer) 5, entry.getKey());
        assertEquals("String 05", entry.getValue());
        assertEquals((Integer) 5, entry.getKey());
        assertEquals((Integer) 1, ((Map.Entry<Integer, String>) simpleTreeMap.floorEntry(1)).getKey());
        assertNull(simpleTreeMap.floorEntry(0));

        simpleTreeMap.put(200, "String 08");
        simpleTreeMap.put(900, "String 01");
        simpleTreeMap.put(500, "String 05");
        simpleTreeMap.put(600, "String 04");
        simpleTreeMap.put(700, "String 03");
        simpleTreeMap.put(100, "String 09");
        simpleTreeMap.put(400, "String 06");
        simpleTreeMap.put(800, "String 02");
        simpleTreeMap.put(300, "String 07");

        assertEquals((Integer) 9, ((Map.Entry<Integer, String>) simpleTreeMap.floorEntry(50)).getKey());
        assertEquals((Integer) 100, ((Map.Entry<Integer, String>) simpleTreeMap.floorEntry(100)).getKey());
        assertEquals((Integer) 100, ((Map.Entry<Integer, String>) simpleTreeMap.floorEntry(150)).getKey());
        assertEquals((Integer) 200, ((Map.Entry<Integer, String>) simpleTreeMap.floorEntry(250)).getKey());
        assertEquals((Integer) 300, ((Map.Entry<Integer, String>) simpleTreeMap.floorEntry(350)).getKey());
        assertEquals((Integer) 400, ((Map.Entry<Integer, String>) simpleTreeMap.floorEntry(450)).getKey());
        assertEquals((Integer) 500, ((Map.Entry<Integer, String>) simpleTreeMap.floorEntry(550)).getKey());
        assertEquals((Integer) 600, ((Map.Entry<Integer, String>) simpleTreeMap.floorEntry(650)).getKey());
        assertEquals((Integer) 700, ((Map.Entry<Integer, String>) simpleTreeMap.floorEntry(750)).getKey());
        assertEquals((Integer) 800, ((Map.Entry<Integer, String>) simpleTreeMap.floorEntry(850)).getKey());
        assertEquals((Integer) 900, ((Map.Entry<Integer, String>) simpleTreeMap.floorEntry(950)).getKey());
        assertEquals((Integer) 900, ((Map.Entry<Integer, String>) simpleTreeMap.floorEntry(10000)).getKey());
    }

    @Test
    public void floorKey() throws Exception {
        assertEquals((Integer) 5, simpleTreeMap.floorKey(5));
        assertNull(simpleTreeMap.floorKey(0));
    }

    @Test
    public void ceilingEntry() throws Exception {
        Map.Entry<Integer, String> entry = simpleTreeMap.ceilingEntry(5);
        assertEquals((Integer) 5, entry.getKey());
        assertEquals("String 05", entry.getValue());
        assertEquals((Integer) 9, ((Map.Entry<Integer, String>) simpleTreeMap.ceilingEntry(9)).getKey());
        assertNull(simpleTreeMap.ceilingEntry(10));

        simpleTreeMap.put(200, "String 08");
        simpleTreeMap.put(900, "String 01");
        simpleTreeMap.put(500, "String 05");
        simpleTreeMap.put(600, "String 04");
        simpleTreeMap.put(700, "String 03");
        simpleTreeMap.put(100, "String 09");
        simpleTreeMap.put(400, "String 06");
        simpleTreeMap.put(800, "String 02");
        simpleTreeMap.put(300, "String 07");

        assertEquals((Integer) 100, ((Map.Entry<Integer, String>) simpleTreeMap.ceilingEntry(50)).getKey());
        assertEquals((Integer) 100, ((Map.Entry<Integer, String>) simpleTreeMap.ceilingEntry(100)).getKey());
        assertEquals((Integer) 200, ((Map.Entry<Integer, String>) simpleTreeMap.ceilingEntry(150)).getKey());
        assertEquals((Integer) 300, ((Map.Entry<Integer, String>) simpleTreeMap.ceilingEntry(250)).getKey());
        assertEquals((Integer) 400, ((Map.Entry<Integer, String>) simpleTreeMap.ceilingEntry(350)).getKey());
        assertEquals((Integer) 500, ((Map.Entry<Integer, String>) simpleTreeMap.ceilingEntry(450)).getKey());
        assertEquals((Integer) 600, ((Map.Entry<Integer, String>) simpleTreeMap.ceilingEntry(550)).getKey());
        assertEquals((Integer) 700, ((Map.Entry<Integer, String>) simpleTreeMap.ceilingEntry(650)).getKey());
        assertEquals((Integer) 800, ((Map.Entry<Integer, String>) simpleTreeMap.ceilingEntry(750)).getKey());
        assertEquals((Integer) 900, ((Map.Entry<Integer, String>) simpleTreeMap.ceilingEntry(850)).getKey());
        assertNull(simpleTreeMap.ceilingEntry(950));
        assertNull(simpleTreeMap.ceilingEntry(10000));
    }

    @Test
    public void ceilingKey() throws Exception {
        assertEquals((Integer) 5, simpleTreeMap.ceilingKey(5));
        assertNull(simpleTreeMap.ceilingKey(10));
    }

    @Test
    public void higherEntry() throws Exception {
        Map.Entry<Integer, String> entry = simpleTreeMap.higherEntry(5);
        assertEquals((Integer) 6, entry.getKey());
        assertEquals("String 04", entry.getValue());
        assertNull(simpleTreeMap.higherEntry(10));
    }

    @Test
    public void higherKey() throws Exception {
        assertEquals((Integer) 6, simpleTreeMap.higherKey(5));
        assertNull(simpleTreeMap.higherKey(10));
    }

    @Test
    public void firstEntry() throws Exception {
        Map.Entry<Integer, String> entry = simpleTreeMap.firstEntry();
        assertEquals((Integer) 1, entry.getKey());
        assertEquals("String 09", entry.getValue());
        simpleTreeMap.clear();
        assertNull(simpleTreeMap.firstEntry());
    }

    @Test
    public void firstKey() throws Exception {
        assertEquals((Integer) 1, simpleTreeMap.firstKey());
        simpleTreeMap.clear();
        assertNull(simpleTreeMap.firstKey());
    }

    @Test
    public void rootEntry() throws Exception {
        Map.Entry<Integer, String> entry = simpleTreeMap.rootEntry();
        assertEquals((Integer) 5, entry.getKey());
        assertEquals("String 05", entry.getValue());
        simpleTreeMap.clear();
        assertNull(simpleTreeMap.rootEntry());
    }

    @Test
    public void rootKey() throws Exception {
        assertEquals((Integer) 5, simpleTreeMap.rootKey());
        simpleTreeMap.clear();
        assertNull(simpleTreeMap.rootKey());
    }

    @Test
    public void lastEntry() throws Exception {
        Map.Entry<Integer, String> entry = simpleTreeMap.lastEntry();
        assertEquals((Integer) 9, entry.getKey());
        assertEquals("String 01", entry.getValue());
        simpleTreeMap.clear();
        assertNull(simpleTreeMap.lastEntry());
    }

    @Test
    public void lastKey() throws Exception {
        assertEquals((Integer) 9, simpleTreeMap.lastKey());
        simpleTreeMap.clear();
        assertNull(simpleTreeMap.lastKey());
    }

    @Test
    public void size() throws Exception {
        assertEquals(9, simpleTreeMap.size());
        simpleTreeMap.clear();
        assertEquals(0, simpleTreeMap.size());
    }

    @Test
    public void isEmpty() throws Exception {
        assertFalse(simpleTreeMap.isEmpty());
        simpleTreeMap.clear();
        assertTrue(simpleTreeMap.isEmpty());
    }

    @Test
    public void containsKey() throws Exception {
        assertTrue(simpleTreeMap.containsKey(5));
        assertFalse(simpleTreeMap.containsKey(555));
    }

    @Test
    public void containsValue() throws Exception {
        assertTrue(simpleTreeMap.containsValue("String 01"));
        assertFalse(simpleTreeMap.containsValue("Some wrong string"));
    }

    @Test
    public void get() throws Exception {
        assertEquals("String 03", simpleTreeMap.get(7));
        assertEquals("String 07", simpleTreeMap.get(3));
        assertNull(simpleTreeMap.get(555));
    }

    @Test
    public void put() throws Exception {
        assertEquals("String 09", simpleTreeMap.get(1));
        assertEquals("String 08", simpleTreeMap.get(2));
        assertEquals("String 07", simpleTreeMap.get(3));
        assertEquals("String 06", simpleTreeMap.get(4));
        assertEquals("String 05", simpleTreeMap.get(5));
        assertEquals("String 04", simpleTreeMap.get(6));
        assertEquals("String 03", simpleTreeMap.get(7));
        assertEquals("String 02", simpleTreeMap.get(8));
        assertEquals("String 01", simpleTreeMap.get(9));

        assertEquals("String 08", simpleTreeMap.put(2, "String 08. Second Edition."));

        assertEquals("String 08. Second Edition.", simpleTreeMap.get(2));

        simpleTreeMap.put(104, "String 106");
        simpleTreeMap.put(105, "String 105");
        simpleTreeMap.put(102, "String 108");
        simpleTreeMap.put(101, "String 109");
        simpleTreeMap.put(106, "String 104");
        simpleTreeMap.put(107, "String 103");
        simpleTreeMap.put(109, "String 101");
        simpleTreeMap.put(103, "String 107");
        simpleTreeMap.put(108, "String 102");

        assertEquals("String 109", simpleTreeMap.get(101));
        assertEquals("String 108", simpleTreeMap.get(102));
        assertEquals("String 107", simpleTreeMap.get(103));
        assertEquals("String 106", simpleTreeMap.get(104));
        assertEquals("String 105", simpleTreeMap.get(105));
        assertEquals("String 104", simpleTreeMap.get(106));
        assertEquals("String 103", simpleTreeMap.get(107));
        assertEquals("String 102", simpleTreeMap.get(108));
        assertEquals("String 101", simpleTreeMap.get(109));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void remove() throws Exception {
        assertEquals("String 07", simpleTreeMap.remove(3));
        assertNull(simpleTreeMap.remove(555));
    }

    @Test
    public void putAll() throws Exception {
        Map<Integer, String> map = new HashMap<>();
        map.put(10, "HashMap Item String 01");
        map.put(11, "HashMap Item String 02");
        map.put(12, "HashMap Item String 03");
        map.put(13, "HashMap Item String 04");
        map.put(14, "HashMap Item String 05");
        simpleTreeMap.putAll(map);
        assertEquals("HashMap Item String 01", simpleTreeMap.get(10));
        assertEquals("HashMap Item String 02", simpleTreeMap.get(11));
        assertEquals("HashMap Item String 03", simpleTreeMap.get(12));
        assertEquals("HashMap Item String 04", simpleTreeMap.get(13));
        assertEquals("HashMap Item String 05", simpleTreeMap.get(14));
    }

    @Test
    public void createWithMap() throws Exception {
        Map<Integer, String> map = new HashMap<>();
        map.put(10, "HashMap Item String 01");
        map.put(11, "HashMap Item String 02");
        map.put(12, "HashMap Item String 03");
        map.put(13, "HashMap Item String 04");
        map.put(14, "HashMap Item String 05");
        simpleTreeMap = new SimpleTreeMap<>(map);
        assertEquals("HashMap Item String 01", simpleTreeMap.get(10));
        assertEquals("HashMap Item String 02", simpleTreeMap.get(11));
        assertEquals("HashMap Item String 03", simpleTreeMap.get(12));
        assertEquals("HashMap Item String 04", simpleTreeMap.get(13));
        assertEquals("HashMap Item String 05", simpleTreeMap.get(14));
    }

    @Test
    public void clear() throws Exception {
        assertFalse(simpleTreeMap.isEmpty());
        simpleTreeMap.clear();
        assertTrue(simpleTreeMap.isEmpty());
    }

    @Test
    public void keySet() throws Exception {
        for (int i = 1; i <= 9; i++) {
            Set<Integer> keys = simpleTreeMap.keySet();
            assertTrue("The key '" + i + "' is absent", keys.contains(i));
        }
    }

    @Test
    public void values() throws Exception {
        for (int i = 1; i <= 9; i++) {
            assertTrue("The value 'String 0" + i + "' is absent", simpleTreeMap.values().contains("String 0" + i));
        }
    }

    @Test
    public void entrySet() throws Exception {
        final Set<Map.Entry<Integer, String>> entries = simpleTreeMap.entrySet();
        assertEquals(simpleTreeMap.size(), simpleTreeMap.entrySet().size());
        entries.forEach(entry -> {
                    assertTrue("Invalid key '" + entry.getKey() + "'",
                            simpleTreeMap.keySet().contains(entry.getKey()));
                    assertTrue("Invalid value '" + entry.getValue() + "'",
                            simpleTreeMap.values().contains(entry.getValue()));
                }
        );
        simpleTreeMap.keySet().forEach(key ->
                assertTrue("Key '" + key + "' isn't presented",
                        entries.stream().filter(entry -> entry.getKey().equals(key)).count() > 0));

        simpleTreeMap.values().forEach(value ->
                assertTrue("Value '" + value + "' isn't presented",
                        entries.stream().filter(entry -> entry.getValue().equals(value)).count() > 0));

    }

}