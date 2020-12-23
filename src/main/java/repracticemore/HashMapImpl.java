package repracticemore;

public class HashMapImpl {
    int bucketSize = 16;
    HashMapNd[] map;

    public HashMapImpl() {
        map = new HashMapNd[this.bucketSize];
    }

    public HashMapImpl(int bucketSize) {
        this.bucketSize = bucketSize;
        map = new HashMapNd[bucketSize];
    }

    private int getIndex(String key) {
        int PRIME = 13;
        int hash = key.hashCode() * PRIME;
        int index = hash % bucketSize;
        if (index < 0) index = 0;
        return index;
    }

    public void putIntoMap(String key, int data) {
        int index = getIndex(key);
        HashMapNd nodeAtIndex = map[index];
        HashMapNd newNode = new HashMapNd(key, data);

        if (null == nodeAtIndex) {
            //No Hash Collision .. It's First Node at this Index
            map[index] = newNode;
            return;
        } else {
            //Hash Collision exist .. now check for duplicateKey
            HashMapNd collideNodeWithSameKey = checkDuplicateKey(nodeAtIndex, key);

            //if data exist with same key
            if (collideNodeWithSameKey != null) {
                collideNodeWithSameKey.data = data;  //override data
            } else {
                //if different key at same index collision then add as next node
                collideNodeWithSameKey = getLastNodeFromLinkedList(nodeAtIndex);
                collideNodeWithSameKey.next = newNode;
            }
        }
    }

    private HashMapNd getLastNodeFromLinkedList(HashMapNd nodeAtIndex) {
        while (nodeAtIndex.next != null) {
            nodeAtIndex = nodeAtIndex.next;
        }
        return nodeAtIndex;
    }

    private HashMapNd checkDuplicateKey(HashMapNd nodeAtIndex, String key) {
        if(nodeAtIndex.key.equals(key)) {
            return nodeAtIndex;
        }
        //check Linked List for duplicate key
        while (nodeAtIndex.next != null) {
            if (nodeAtIndex != null && nodeAtIndex.key.equals(key)) {
                return nodeAtIndex;
            }
            nodeAtIndex = nodeAtIndex.next;
        }
        return null;
    }

    public static void printHashMap(HashMapImpl hashMap) {
        for (int i = 0; i < hashMap.map.length; i++) {
            System.out.println("Bucket Index : " + i);

            HashMapNd currentNode = hashMap.map[i];

            if (null == currentNode) continue;
            System.out.println(currentNode.toString());
            while (currentNode.next != null) {
                System.out.println("..."+currentNode.next.toString());
                currentNode = currentNode.next;
            }
        }
    }
}
