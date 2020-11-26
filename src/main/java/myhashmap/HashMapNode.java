package myhashmap;

public class HashMapNode<K,V> {
    K key;
    V value;

    HashMapNode nextNode;

    public HashMapNode(K key, V value) {
        this.key = key;
        this.value = value;
    }
}
