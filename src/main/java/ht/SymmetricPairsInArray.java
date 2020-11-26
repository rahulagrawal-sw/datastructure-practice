package ht;

import java.util.Hashtable;

public class SymmetricPairsInArray {
    public static void main(String[] args) {
        int [][] arr = new int[][] {{11, 20}, {30, 40}, {5, 10}, {40, 30}, {10, 5}};
        symmetricArrayBestApproach(arr);
    }

    private static void symmetricArrayBestApproach(int[][] arr) { //O(n)
        Hashtable<Integer, Integer> ht = new Hashtable<>();

        for(int i=0; i<arr.length; i++) {
            if(ht.size() > 1 && ht.get(arr[i][1]) != null && ht.get(arr[i][1]) == arr[i][0])
                System.out.println("symmetric array : " + arr[i][1] + " " + ht.get(arr[i][1]));
            else
                ht.put(arr[i][0], arr[i][1]);
        }
        //System.out.println(ht);
    }

    private static void symmetricArray(int[][] arr) {  //O(n*2)
        for(int i=0; i<arr.length-1; i++) {
            for(int j=i+1; j<arr.length; j++) {
                if (arr[i][0] == arr[j][1] && arr[i][1] == arr[j][0]) {
                    System.out.println("symmetric array : " + arr[i][0] + " " + arr[i][1]);
                }
            }

        }
    }
}

/*for(int j=0; j<arr[i].length; j++) {
                System.out.println("Values at arr["+i+"]["+j+"] is "+arr[i][j]);
            }*/