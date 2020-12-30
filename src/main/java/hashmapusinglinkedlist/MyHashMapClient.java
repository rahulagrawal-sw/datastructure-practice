package hashmapusinglinkedlist;

import java.util.Objects;

public class MyHashMapClient {
    public static void main(String[] args) {
        HashMapImpl hashMap = new HashMapImpl(2);
        hashMap.putIntoMap("PUNE", 10);
        hashMap.putIntoMap("NAGAR", 20);
        hashMap.putIntoMap("AHNAGAR", 20);
        hashMap.putIntoMap("AURANGABAD", 20);
        hashMap.putIntoMap("MUMBAI", 20);

        hashMap.putIntoMap("AHNAGAR", 50);
        HashMapImpl.printHashMap(hashMap);

        System.out.println(Objects.hashCode(null));
    }
}
