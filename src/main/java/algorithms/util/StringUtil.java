package algorithms.util;

public class StringUtil {
    public static String reverseAString(String str) {
        if(str.isEmpty() || str.length() == 1) {
            return str;
        }else {
            return reverseAString(str.substring(1)) + str.charAt(0) ;
        }
    }
    public static String removeAdjacentDuplicates(String str) {
        if(str.length() == 1) {
            return str;
        }
        char c = str.charAt(0);
        char next = str.charAt(1);
        return next != c ?  c + removeAdjacentDuplicates(str.substring(1))
                : removeAdjacentDuplicates(str.substring(1));
    }
}
