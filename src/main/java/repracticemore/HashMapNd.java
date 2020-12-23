package repracticemore;

public class HashMapNd {

    String key;
    int data;

    HashMapNd next;

    public HashMapNd(String key, int data) {
        this.key = key;
        this.data = data;
    }

    @Override
    public String toString() {
        return "HashMapNd{" +
                "key='" + key + '\'' +
                ", data=" + data +
                '}';
    }
}
