package array;

public class SecondMinimumDemo {
    public static void main(String[] args) {
        int[] elements = {-5, -4, 0, 2, 10, 3, -5};
        System.out.println(secondMinimum(elements));
    }

    public static int secondMinimum(int [] elements)    {
        int smallest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;
        for (int i = 0; i < elements.length; i++) {
            if (elements[i] < smallest) {
                secondSmallest = smallest;
                smallest = elements[i];
            }
            //&& elements[i] != smallest  is needed if we have smallest value twice .. e.g. -5 above
            else if (elements[i] < secondSmallest && elements[i] != smallest) {
                secondSmallest = elements[i];
            }
        }
        return secondSmallest;
    }
}
