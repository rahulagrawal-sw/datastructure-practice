package array;

public class FibonacciDemo {
    public static void main(String[] args) {
        System.out.println(calcFibonacci(6));
    }

    private static int calcFibonacci(int n) {
        int arr [] = new int[n+1];
        arr[0] = 0;
        arr[1] = 1;

        for(int i=2; i<=n ;i++) {
            arr[i] = arr[i-2] + arr[i-1];
            System.out.print(arr[i] + " ");
        }
        System.out.println("");

        return arr[n];
    }
}
