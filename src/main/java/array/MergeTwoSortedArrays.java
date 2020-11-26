package array;

import java.util.Arrays;

public class MergeTwoSortedArrays {
    public static void main(String[] args) {
        int[] arr1 = {1, 3, 5, 7};
        int[] arr2 = {2, 4, 6};
        int[] resultArray = mergeArraysBestApproach(arr1, arr2);
        for(int element : resultArray) {
            System.out.print(element + " ");
        }
    }

    public static int[] mergeArraysBestApproach(int[] arr1, int[] arr2) {
        int n1 = arr1.length;
        int n2 = arr2.length;

        int first = n1 - 1;
        int second = n2 - 1;

        //If you don't want or cannot use ArrayList, then there is a utility method,
        // that will allow you to specify new size, while preserving the elements.
        arr1 = Arrays.copyOf(arr1, n1+n2);

        for(int i=n1+n2-1; i > 0 ; i--) {
            if(second < 0) {
                break;
            }

            if(arr1[first] > arr2[second]) {
                arr1[i] = arr1[first];
                first --;
            } else {
                arr1[i] = arr2[second];
                second --;
            }
        }

        return  arr1;
    }

    public static int[] mergeArrays(int[] arr1, int[] arr2) {
        int i = 0, j = 0, k = 0;
        int n1 = arr1.length;
        int n2 = arr2.length;

        int arr3 [] = new int[n1+n2];
        // Traverse both array
        while (i<n1 && j <n2)  {
            // Check if current element of first
            // array is smaller than current element
            // of second array. If yes, store first
            // array element and increment first array
            // index. Otherwise do same with second array
            if (arr1[i] < arr2[j])
                arr3[k++] = arr1[i++];
            else
                arr3[k++] = arr2[j++];
        }

        // Store remaining elements of first array
        while (i < n1)
            arr3[k++] = arr1[i++];

        // Store remaining elements of second array
        while (j < n2)
            arr3[k++] = arr2[j++];

        return arr3;
    }
}
