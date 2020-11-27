package repractice;

import java.util.Arrays;

public class Merge2SortedArrays {
    public static void main(String[] args) {
        int [] array1 = new int[] {10,60,80};
        int [] array2 = new int[] { -5,15,45};

        int n1 = array1.length;
        int n2 = array2.length;

        array1 = Arrays.copyOf(array1, n1+n2);
        n1 = n1-1;
        n2 = n2-1;

        int mergedArrayLength = array1.length-1;

        while(mergedArrayLength > 0) {
            if(array1[n1] < array2[n2]) {
                array1[mergedArrayLength] = array2[n2];
                n2--;
                mergedArrayLength --;
            } else {
                array1[mergedArrayLength] = array1[n1];
                n1--;
                mergedArrayLength --;
            }
        }

        while(n1 >= 0) {
            array1[mergedArrayLength] = array1[n1];
            n1 --;
        }

        while(n2 >= 0) {
            array1[mergedArrayLength] = array2[n2];
            n2 --;
        }

        System.out.println("Array 1 extended length is : " + array1.length);
        //Print sorted result
        for(int num: array1) {
            System.out.println("num:" + num);
        }
    }
}
