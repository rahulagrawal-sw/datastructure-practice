package myhashmap;

import java.util.ArrayList;
import java.util.List;

public class MyHashMap<K, V> {
    List<HashMapNode<K,V>> [] bucketArray;
    int bucketSize;

    public MyHashMap(int bucketSize){
        this.bucketSize = bucketSize;
        this.bucketArray = new ArrayList[bucketSize];

        for(int i=0; i<bucketSize; i++) {
            this.bucketArray[i] = new ArrayList<>();
        }
    }

    private int getNodeIndex(K key) {
        int hashCode = key.hashCode();
        int index = hashCode % this.bucketSize;
        return index;
    }

    public void put(K key, V value) {
        int index = getNodeIndex(key);
        List<HashMapNode<K,V>> currentIndexBucket = this.bucketArray[index];

        //check if key is already present, then override value with given key
        checkDuplicateKey(key,value);

        //check if value is already present with same key, then skip
        if(checkDuplicateValue(key, value)) {
            System.out.println("same value already existing with same key " + key);
            return;
        }

        //add new node to the chain or without chain if not exist with same key already
        HashMapNode newNode = new HashMapNode(key,value);
        currentIndexBucket.add(newNode);
        this.bucketArray[index]= currentIndexBucket;
    }

    public static void main(String[] args) {
        MyHashMap<String, String> myCustomMap = new MyHashMap(3);

        //same key & different value === Override
        myCustomMap.put("key1","value1");
        myCustomMap.put("key1","value11");

        //same key & same value == Skip
        myCustomMap.put("key2","value2");
        myCustomMap.put("key2","value2");

        myCustomMap.put("key3","value3");
        myCustomMap.put("key4","value4");

        printMyHashMapData(myCustomMap);
    }

    private static void printMyHashMapData(MyHashMap myHashMap) {
        System.out.println("INSIDE printMyHashMapData");
        System.out.println("size of bucket array : "+ myHashMap.bucketArray.length);

        for(int i =0 ; i< myHashMap.bucketArray.length; i++) {
            System.out.println("Data of bucket : " + i);
            List<HashMapNode> nodes = myHashMap.bucketArray[i];
             for(HashMapNode node : nodes) {
                 System.out.println("Node == " + node.key + ":" + node.value);
             }
        }
    }

    private boolean checkDuplicateValue(K key, V value) {
        int index = getNodeIndex(key);

        System.out.println("Data of bucket index : " + index);
        List<HashMapNode<K,V>> nodes = this.bucketArray[index];
        for(HashMapNode node : nodes) {
            if(node.value.equals(value)) {
                return true;
            }
        }
        return false;
    }

    private void checkDuplicateKey(K key, V value) {
        int index = getNodeIndex(key);

        System.out.println("Data of bucket index : " + index);
        List<HashMapNode<K,V>> nodes = this.bucketArray[index];
        List<HashMapNode<K,V>> copiedNodes = new ArrayList<>();
        for(HashMapNode node : nodes) {
            if(node.key.equals(key)) {
                System.out.println("key already exist " + key + ".... overriding value now");
                node.value = value;
            }
            copiedNodes.add(node);
        }
        this.bucketArray[index] = copiedNodes;
    }
}
