package repractice;

import java.util.HashMap;

public class CheapLetterDeletion {

    public static void main(String[] args) {
        String str1 = "abccbd";
        int[] deletionCost1 = new int[]{0, 1, 2, 3, 4, 5};
        int result = solution(str1, deletionCost1);
        System.out.println(result);

        String str2 = "aabbcc";
        int[] deletionCost2 = new int[]{1, 2, 1, 2, 1, 2};
        result = solution(str2, deletionCost2);
        System.out.println(result);

        String str3 = "aaaa";
        int[] deletionCost3 = new int[]{3, 4, 5, 6};
        result = solution(str3, deletionCost3);
        System.out.println(result);

        String str4 = "ababa";
        int[] deletionCost4 = new int[]{10, 5, 10, 5, 10};
        result = solution(str4, deletionCost4);
        System.out.println(result);

    }

    public static int solution(String S, int[] C) {
        int result = 0;
        char prevChar = 0;
        for (int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);

            if (prevChar == ch) {
                if (C[i-1] < C[i]) {
                    result += C[i-1];
                } else {
                    result += C[i];
                }
            }
            prevChar = ch;
        }
        return result;
    }
}
