package array;

import java.util.Hashtable;

public class FirstNonRepeating {
    public static void main(String[] args) {
        int[] arr = {1, 1, 9, 7, 3};

        Hashtable<Integer, Integer> m = new Hashtable<>();

        for(int i =0 ; i< arr.length; i++) {
            if (m.containsKey(arr[i])) {
                m.put(arr[i], m.get(arr[i]) + 1);
            }
            else {
                m.put(arr[i], 1);
            }
        }

        for(Integer key : m.keySet()) {
            if(m.get(key) == 1)
                System.out.println(key);
        }

    }
}
