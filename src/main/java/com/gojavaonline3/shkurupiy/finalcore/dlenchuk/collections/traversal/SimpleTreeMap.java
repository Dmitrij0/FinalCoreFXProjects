package com.gojavaonline3.shkurupiy.finalcore.dlenchuk.collections.traversal;

import java.util.*;

import static com.gojavaonline3.shkurupiy.finalcore.dlenchuk.collections.traversal.SimpleTreeMap.ColorOfTreeNode.*;
import static com.gojavaonline3.shkurupiy.finalcore.dlenchuk.collections.traversal.SimpleTreeMap.Direction.*;

/**
 * There is the tree map implementation based on a red-black tree algorithm.
 * The method remove() is not implemented because the class is only for a traversal
 *
 * @author  Dmitrij Lenchuk
 */
public class SimpleTreeMap<K extends Comparable<K>, V>
        implements SimpleMap<K, V>, Traversal<Map.Entry<K, V>> {

    enum ColorOfTreeNode {
        BLACK,
        RED
    }

    enum Direction {
        LEFT,
        RIGHT
    }

    private Entry<K, V> root;
    private int size;

    public SimpleTreeMap() {
        super();
    }

    public SimpleTreeMap(Map<K, V> map) {
        this();
        putAll(map);
    }

    private Entry<K, V> findEntry(Entry<K, V> root, K key) {
        if (root == null) {
            return null;
        } else {
            if (root.key.compareTo(key) > 0) {
                return findEntry(root.left, key);
            } else if (root.key.compareTo(key) < 0) {
                return findEntry(root.right, key);
            } else {
                return root;
            }
        }
    }

    private Entry<K, V> findEntry(Entry<K, V> entry, K key, Direction direction, boolean equal) {
        int compareResult = entry.getKey().compareTo(key);
        if (direction == LEFT) {
            if (compareResult > 0 || (!equal && compareResult == 0)) {
                return entry.left == null ? null : findEntry(entry.left, key, direction, equal);
            } else if (compareResult < 0) {
                Entry<K, V> foundEntry = entry.right == null ? null : findEntry(entry.right, key, direction, equal);
                return foundEntry == null ? entry : foundEntry;
            } else if (equal && compareResult == 0) {
                return entry;
            }
        } else if (direction == RIGHT) {
            if (compareResult > 0) {
                Entry<K, V> foundEntry = entry.left == null ? null : findEntry(entry.left, key, direction, equal);
                return foundEntry == null ? entry : foundEntry;
            } else if (compareResult < 0 || (!equal && compareResult == 0)) {
                return entry.right == null ? null : findEntry(entry.right, key, direction, equal);
            } else if (equal && compareResult == 0) {
                return entry;
            }
        }
        return null;
    }

    @Override
    public Entry<K, V> lowerEntry(K key) {
        return findEntry(root, key, LEFT, false);
    }

    @Override
    public K lowerKey(K key) {
        Entry<K, V> entry = lowerEntry(key);
        return entry == null ? null : entry.getKey();
    }

    @Override
    public Entry<K, V> floorEntry(K key) {
        return findEntry(root, key, LEFT, true);
    }

    @Override
    public K floorKey(K key) {
        Entry<K, V> entry = floorEntry(key);
        return entry == null ? null : entry.getKey();
    }

    @Override
    public Entry<K, V> ceilingEntry(K key) {
        return findEntry(root, key, RIGHT, true);
    }

    @Override
    public K ceilingKey(K key) {
        Entry<K, V> entry = ceilingEntry(key);
        return entry == null ? null : entry.getKey();
    }

    @Override
    public Entry<K, V> higherEntry(K key) {
        return findEntry(root, key, RIGHT, false);
    }

    @Override
    public K higherKey(K key) {
        Entry<K, V> entry = higherEntry(key);
        return entry == null ? null : entry.getKey();
    }

    @Override
    public Entry<K, V> firstEntry() {
        return getChild(root, LEFT);
    }

    private Entry<K, V> getChild(Entry<K, V> entry, Direction direction) {
        if (entry == null) {
            return null;
        }
        Entry<K, V> childEntry = direction == LEFT ? entry.left : entry.right;
        return childEntry == null ? entry : getChild(childEntry, direction);
    }

    @Override
    public K firstKey() {
        Entry<K, V> entry = firstEntry();
        return entry == null ? null : entry.getKey();
    }

    @Override
    public Entry<K, V> rootEntry() {
        return root;
    }

    @Override
    public K rootKey() {
        return root == null ? null : root.getKey();
    }

    @Override
    public Entry<K, V> lastEntry() {
        return getChild(root, RIGHT);
    }

    @Override
    public K lastKey() {
        Entry<K, V> entry = lastEntry();
        return entry == null ? null : entry.getKey();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    @SuppressWarnings("unchecked")
    public boolean containsKey(Object key) {
        return findEntry(root, (K) key) != null;
    }

    @Override
    @SuppressWarnings("SuspiciousMethodCalls")
    public boolean containsValue(Object value) {
        return values().contains(value);
    }

    @Override
    @SuppressWarnings("unchecked")
    public V get(Object key) {
        Entry<K, V> foundEntry = findEntry(root, (K) key);
        return foundEntry == null ? null : foundEntry.getValue();
    }

    private Iterator<Entry<K, V>> iterator() {
        return new Iterator<Entry<K, V>>() {

            private Entry<K, V> currEntry = firstEntry();

            @Override
            public boolean hasNext() {
                return currEntry != null;
            }

            @Override
            public Entry<K, V> next() {
                Entry<K, V> entry = currEntry;
                currEntry = higherEntry(currEntry.getKey());
                return entry;
            }
        };
    }

    @Override
    public V put(K key, V value) {
        return putNewEntry(root, key, value);
    }

    private V putNewEntry(final Entry<K, V> root, final K key, final V value) {
        if (root == null) {
            this.root = new Entry<>(key, value, null);
            this.root.color = BLACK;
            size++;
            return null;
        } else {
            final K rootKey = root.key;
            if (rootKey.compareTo(key) > 0) {
                if (root.left == null) {
                    balancePut(root.left = new Entry<>(key, value, root));
                    size++;
                    return null;
                } else {
                    return putNewEntry(root.left, key, value);
                }
            } else if (rootKey.compareTo(key) < 0) {
                if (root.right == null) {
                    balancePut(root.right = new Entry<>(key, value, root));
                    size++;
                    return null;
                } else {
                    return putNewEntry(root.right, key, value);
                }
            } else {
                return root.setValue(value);
            }
        }
    }

    private void balancePut(Entry<K, V> entry) {
        Entry<K, V> currEntry = entry;
        /*Correct color of root node*/
        if (currEntry.parent == null) {
            if (currEntry.color == RED) {
                currEntry.color = BLACK;
            }
            return;
        }
        /*Valid Case*/
        if (currEntry.parent.color == BLACK) {
            return;
        }
        /*First Case*/
        if (uncle(currEntry) != null && uncle(currEntry).color == RED) {
            firstCaseBalanceOfPut(currEntry);
            return;
        }
        /*Second Case*/
        if ((currEntry.parent.parent.left == currEntry.parent && currEntry.parent.right == currEntry) ||
                (currEntry.parent.parent.right == currEntry.parent && currEntry.parent.left == currEntry)) {
            Entry<K, V> parentEntry = currEntry.parent;
            secondCaseBalanceOfPut(currEntry);
            currEntry = parentEntry;
        }
        /*Third Case*/
        if ((currEntry.parent.parent.left == currEntry.parent && currEntry.parent.left == currEntry) ||
                (currEntry.parent.parent.right == currEntry.parent && currEntry.parent.right == currEntry)) {
            thirdCaseBalanceOfPut(currEntry);
        }
    }

    private Entry<K, V> uncle(Entry<K, V> entry) {
        return entry.parent.parent.right == entry.parent ?
                entry.parent.parent.left : entry.parent.parent.right;
    }

    private void firstCaseBalanceOfPut(Entry<K, V> entry) {
        uncle(entry).color = BLACK;
        entry.parent.color = BLACK;
        entry.parent.parent.color = RED;
        balancePut(entry.parent.parent);
    }

    private void secondCaseBalanceOfPut(Entry<K, V> entry) {
        if (entry.parent.parent.left == entry.parent) {
            turnLeft(entry);
        } else if (entry.parent.parent.right == entry.parent) {
            turnRight(entry);
        }
    }

    private void thirdCaseBalanceOfPut(Entry<K, V> entry) {
        if (entry.parent.parent.left == entry.parent) {
            turnRight(entry.parent);
            entry.parent.right.color = RED;
        } else if (entry.parent.parent.right == entry.parent) {
            turnLeft(entry.parent);
            entry.parent.left.color = RED;
        }
        entry.parent.color = BLACK;
    }

    private void turnLeft(Entry<K, V> entry) {
        if (entry.parent.parent == null) {
            root = entry;
        } else {
            if (entry.parent.parent.right == entry.parent) {
                entry.parent.parent.right = entry;
            } else if (entry.parent.parent.left == entry.parent) {
                entry.parent.parent.left = entry;
            }
        }
        entry.parent.right = entry.left;
        entry.left = entry.parent;
        entry.parent = entry.parent.parent;
        entry.left.parent = entry;
    }

    private void turnRight(Entry<K, V> entry) {
        if (entry.parent.parent == null) {
            root = entry;
        } else {
            if (entry.parent.parent.left == entry.parent) {
                entry.parent.parent.left = entry;
            } else if (entry.parent.parent.right == entry.parent) {
                entry.parent.parent.right = entry;
            }
        }
        entry.parent.left = entry.right;
        entry.right = entry.parent;
        entry.parent = entry.parent.parent;
        entry.right.parent = entry;
    }

    @Override
    /*ToDo*/
    public V remove(Object key) {
        throw new UnsupportedOperationException("The class is only for travers");
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> map) {
        map.entrySet().forEach(node -> put(node.getKey(), node.getValue()));
    }

    @Override
    public void clear() {
        root = null;
        size = 0;
    }

    @Override
    public Set<K> keySet() {
        Set<K> keys = new HashSet<>();
        iterator().forEachRemaining(entry -> keys.add(entry.key));
        return keys;
    }

    @Override
    public Collection<V> values() {
        Collection<V> values = new ArrayList<>();
        iterator().forEachRemaining(entry -> values.add(entry.value));
        return values;
    }

    @Override
    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> entries = new HashSet<>();
        iterator().forEachRemaining(entries::add);
        return entries;
    }

    private class Entry<KI, VI> implements Map.Entry<KI, VI> {

        private final KI key;
        private VI value;
        Entry<KI, VI> left;
        Entry<KI, VI> right;
        Entry<KI, VI> parent;
        ColorOfTreeNode color = RED;


        Entry(KI key, VI value, Entry<KI, VI> parent) {
            this.key = key;
            this.value = value;
            this.parent = parent;
        }

        @Override
        public KI getKey() {
            return key;
        }

        @Override
        public VI getValue() {
            return value;
        }

        @Override
        public VI setValue(VI value) {
            VI oldValue = this.value;
            this.value = value;
            return oldValue;
        }

        @Override
        @SuppressWarnings("unchecked")
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Entry<KI, VI> entry = (Entry<KI, VI>) o;

            return key.equals(entry.key) && (value != null ? value.equals(entry.value) : entry.value == null);

        }

        @Override
        public int hashCode() {
            int keyHash = (key == null ? 0 : key.hashCode());
            int valueHash = (value == null ? 0 : value.hashCode());
            return keyHash ^ valueHash;
        }

        @Override
        public String toString() {
            return key + " = " + value;
        }

    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Iterator<Entry<K, V>> iterator = iterator();
        iterator.forEachRemaining(entry -> stringBuilder.append(entry).append(iterator.hasNext() ? "; " : ""));
        return stringBuilder.toString();
    }

    @Override
    public Iterator<Map.Entry<K, V>> preOrderIterator() {
        return new AbstractIterator<Map.Entry<K, V>>(root) {
            @Override
            void fillList(Map.Entry<K, V> entry) {
                if (entry == null) {
                    return;
                }
                Entry<K, V> currEntry = (Entry<K, V>) entry;
                entries.add(currEntry);
                fillList(currEntry.left);
                fillList(currEntry.right);
            }
        };
    }

    @Override
    public Iterator<Map.Entry<K, V>> inOrderIterator() {
        return new AbstractIterator<Map.Entry<K, V>>(root) {
            @Override
            void fillList(Map.Entry<K, V> entry) {
                if (entry == null) {
                    return;
                }
                Entry<K, V> currEntry = (Entry<K, V>) entry;
                fillList(currEntry.left);
                entries.add(currEntry);
                fillList(currEntry.right);
            }
        };
    }

    @Override
    public Iterator<Map.Entry<K, V>> postOrderIterator() {
        return new AbstractIterator<Map.Entry<K, V>>(root) {
            @Override
            void fillList(Map.Entry<K, V> entry) {
                if (entry == null) {
                    return;
                }
                Entry<K, V> currEntry = (Entry<K, V>) entry;
                fillList(currEntry.left);
                fillList(currEntry.right);
                entries.add(currEntry);
            }
        };
    }

    private abstract class AbstractIterator<T> implements Iterator<T> {

        final List<T> entries = new ArrayList<>();
        int index;

        AbstractIterator(T rootEntry) {
            fillList(rootEntry);
        }

        abstract void fillList(T entry);

        @Override
        public boolean hasNext() {
            return index < entries.size();
        }

        @Override
        public T next() {
            return entries.get(index++);
        }
    }
}
