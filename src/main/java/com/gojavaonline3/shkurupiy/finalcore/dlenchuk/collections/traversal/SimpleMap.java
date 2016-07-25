package com.gojavaonline3.shkurupiy.finalcore.dlenchuk.collections.traversal;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/**
 * The contract of a tree map
 *
 * @author  Dmitrij Lenchuk
 */
public interface SimpleMap<K, V> extends Map<K, V> {

    /**
     * result is greatest entry < key || null (if no such key)
     */
    Entry<K, V> lowerEntry(K key);

    /**
     * result is greatest key < key || null (if no such key)
     */
    K lowerKey(K key);

    /**
     * result is greatest entry <= key || null (if no such key)
     */
    Entry<K, V> floorEntry(K key);

    /**
     * result is greatest key <= key || null (if no such key)
     */
    K floorKey(K key);

    /**
     * result is least entry >= key || null (if no such key)
     */
    Entry<K, V> ceilingEntry(K key);

    /**
     * result is least key >= key || null (if no such key)
     */
    K ceilingKey(K key);

    /**
     * result is least entry > key || null (if no such key)
     */
    Map.Entry<K, V> higherEntry(K key);

    /**
     * result is least entry > key || null (if no such key)
     */
    K higherKey(K key);

    Entry<K, V> firstEntry();

    K firstKey();

    Entry<K, V> rootEntry();

    K rootKey();

    Entry<K, V> lastEntry();

    K lastKey();

    /*---------------------------------------*/
    /*------------- Map methods -------------*/
    /*---------------------------------------*/

    int size();

    boolean isEmpty();

    boolean containsKey(Object key);

    boolean containsValue(Object value);

    V get(Object key);

    V put(K key, V value);

    V remove(Object key);

    void putAll(Map<? extends K, ? extends V> m);

    void clear();

    Set<K> keySet();

    Collection<V> values();

    Set<Entry<K, V>> entrySet();

    boolean equals(Object o);

    int hashCode();

}

    