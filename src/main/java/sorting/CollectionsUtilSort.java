package sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CollectionsUtilSort {
    public static void main(String[] args) {

        int[] arr = { 13, 7, 6, 45, 21, 9, 101, 102 };
        Arrays.sort(arr);
        System.out.printf("Modified arr[] : %s",
                Arrays.toString(arr));

        //===========================================================================
        // Create a list of strings
        List<String> al = new ArrayList<>();
        al.add("Geeks For Geeks");
        al.add("Friends");
        al.add("Dear");
        al.add("Is");
        al.add("Superb");

        /* Collections.sort method is sorting the
        elements of ArrayList in ascending order. */
        Collections.sort(al);

        // Let us print the sorted list
        System.out.println("");
        System.out.println("List after the use of"
                + " Collection.sort() :\n" + al);
    }
}
