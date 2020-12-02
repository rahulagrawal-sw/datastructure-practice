package repractice;

public class FindSecondLargestElement {
    public static void main(String[] args) {
        int [] array1 = new int[] {90, 60, 80, 30, 25};

        findSecondLargest(array1);

        findSecondSmallest(array1);
    }

    private static void findSecondLargest(int[] array1) {
        int firstLargest = Integer.MAX_VALUE;
        int secondLargest = Integer.MAX_VALUE;

        for(int num: array1) {
            if(firstLargest > num) {
                firstLargest = num;
            } else if(secondLargest > num && secondLargest > firstLargest) {
                secondLargest = num;
                firstLargest = secondLargest;
            }
        }

        System.out.println("Second Largest is " + secondLargest);
    }

    private static void findSecondSmallest(int[] array1) {
        int firstSmallest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;

        for(int num: array1) {
            if(num < firstSmallest) {
                firstSmallest = num;
            }

            if(num > firstSmallest && num < secondSmallest) {
                secondSmallest = num;
            }
        }

        System.out.println("Second Smallest is " + secondSmallest);
    }
}
