import java.util.Objects;

public class HashMap<K,V> {

    private static final long SerialVersionUID = 1L;

    static final int DEFAULT_INITIAL_CAPACITY = 1 << 4;
    static final int MAXIMUM_CAPACITY = 1 << 30;
    static final float DEFAULT_LOAD_FACTOR = 0.75f;
    static final int TREEIFY_THRESHOLD = 8;
    static final int UNTREEIFY_THRESHOLD = 6;

    transient Entry<K,V>[] table;
    transient int size;
    transient int modCount;
    int capacity;
    int threshHold;
    float loadFactor;

    //constructor1
    public HashMap() {
        this.loadFactor = DEFAULT_LOAD_FACTOR;
        this.capacity = DEFAULT_INITIAL_CAPACITY;
    }

    public HashMap(int initialCapacity) {
        this(initialCapacity, DEFAULT_LOAD_FACTOR);
    }

    public HashMap(int initialCapacity, float loadFactor) {
        if(initialCapacity < 0)
            throw new IllegalArgumentException("Illegal initial capacity: "+ initialCapacity);

        if(loadFactor <= 0 || Float.isNaN(loadFactor))
            throw new IllegalArgumentException("Illegal load factor: " + loadFactor);

        if(initialCapacity > MAXIMUM_CAPACITY) {
            initialCapacity = MAXIMUM_CAPACITY;
        }


        this.loadFactor = loadFactor;
        this.capacity = initialCapacity;
        //this.threshHold =
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public int size() {
        return size;
    }

    public boolean contains(K key) {
        return get(key) != null;
    }

    public V put(K key, V value){
        int hash = hash(key);
        int index = indexFor(hash, table.length);

        if(table == null)
            table = (Entry<K,V>[]) new Entry[capacity];

        if(size >= (loadFactor * capacity)) {
            resize(capacity<<1);
        }

        for(Entry<K,V> e = table[index]; e!= null; e=e.next) {
            if(e.hash == hash && (key == e.key || key.equals(e.key))){
                V oldValue = e.value;
                e.value = value;
                return oldValue;
            }
        }

        addEntry(table, key, value, hash, index);

        ++modCount;
        ++size;

        return null;
    }

    public V get(K key){
        int hash = hash(key);
        int index = indexFor(hash, table.length);

        if(table == null || table[index] == null)
            return null;

        for(Entry<K,V> e = table[index]; e!= null; e = e.next) {
            if(e.hash == hash && (key == e.key || key.equals(e.key))){
                return e.value;
            }
        }

        return null;
    }

    private void resize(int newCapacity) {
        Entry<K,V>[] newTable = (Entry<K,V>[]) new Entry[newCapacity];
        for(Entry<K,V> e: table) {
            int index = indexFor(e.hash, newCapacity);
            addEntry(newTable, e.key, e.value, e.hash, index);
        }
        this.capacity = newCapacity;
        this.table = newTable;
    }

    private void addEntry(Entry<K,V>[] table, K key, V value, int hash, int index) {
        Entry<K, V> e = table[index];
        table[index] = new Entry(key, value, hash, e);
    }

    private int hash(K key){
        int h;
        return (key == null) ? 0 : ((h = key.hashCode()) & 0x7fffffff) ^ (h >>> 16);
    }

    private int indexFor(int h, int length) {
        return h & (length-1);
    }

    static class Entry<K,V> {
        final int hash;
        final K key;
        V value;
        Entry<K,V> next;

        Entry(K key, V value, int hash, Entry<K,V> next) {
            this.key = key;
            this.value = value;
            this.hash = hash;
            this.next = next;
        }

        /*public int hashCode() {
            return Objects.hashCode(key) ^ Objects.hashCode(value);
        }

        public boolean equals(Object o) {
            if(this == o) return true;
            if(o instanceof Entry){
                Entry e = (Entry)o;
                if(Objects.equals(e.key, this.key) && Objects.equals(e.value, this.value))
                    return true;
            }
            return false;
        }*/
    }


    public static void main (String[] args) throws java.lang.Exception {
        // your code goes here
    }
}
