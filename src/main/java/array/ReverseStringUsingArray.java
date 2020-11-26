package array;

public class ReverseStringUsingArray {
    public static void main(String[] args) {
        String str = "abcde";

        System.out.println(reverse(str));
        System.out.println(reverseBestApproach1(str));
        System.out.println(reverseBestApproach2(str));
    }

    public static String reverseBestApproach1(String str)    {
        // return if string is null or empty
        if (str == null || str.equals(""))
            return str;

        // convert string into bytes
        byte[] bytes = str.getBytes();

        // start from the two end points l and h of the given string
        // and increment l & decrement h at each iteration of the loop
        // until two end-points intersect (l >= h)
        for (int l = 0, h = str.length() - 1; l < h; l++, h--)
        {
            // Swap values at l and h
            byte temp = bytes[l];
            bytes[l] = bytes[h];
            bytes[h] = temp;
        }
        // convert byte array back into the string
        return new String(bytes);
    }

    //following does not deal with UTF-16 surrogate pairs.
    public static String reverseBestApproach2(String str)  {
        // return if string is null or empty
        if (str == null || str.equals(""))
            return str;

        char[] s = str.toCharArray();
        int n = s.length;
        int halfLength = n / 2;
        for (int i=0; i < halfLength; i++) {
            char temp = s[i];
            s[i] = s[n-1-i];
            s[n-1-i] = temp;
        }
        return new String(s);
    }

    public static String reverse(String str) {
        // return if string is null or empty
        if (str == null || str.equals(""))
            return str;

        // get string length
        int n = str.length();

        // create a character array of same size as that of string
        char[] temp = new char[n];

        // fill character array backwards with characters of the string
        for (int i = 0; i < n; i++)
            temp[n - i - 1] = str.charAt(i);

        // convert character array to string and return it
        return String.copyValueOf(temp);
    }
}
