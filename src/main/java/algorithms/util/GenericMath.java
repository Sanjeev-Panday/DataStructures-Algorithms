package algorithms.util;

public class GenericMath {
    public static int gcd(int num1,int num2) {
        if(num1 > num2)
            return findGcd(num1 ,num2);
        else
            return findGcd(num2, num1);
    }
    private static int findGcd(int num1, int num2) {
        assert num1 >= num2;
        if(num1 % num2 == 0) {
            return num2;
        }
        return findGcd(num2, num1 % num2);
    }

    /**
     * formula used is num1 * num2 = LCM(num1, num2) * GCD(num1, num2)
     * LCM(num1, num2) = (num1 * num2) / GCD(num1, num2)
     * @param num Integer
     * @param num2 Integer
     * @return Integer
     */
    public static int lcm(int num1, int num2) {
        assert num1 > 0 && num2 > 0;
        return (num1 * num2) / gcd(num1, num2);
    }
    public static boolean isPrime(int num) {
        if(num < 2) return false;
        for(int i = 2; i <= Math.sqrt(num); i++) {
            if(num % i == 0) return false;
        }
        return true;
    }
    public static String decimalToBinary(int num) {
        if(num == 0 || num == 1) return String.valueOf(num);
        return decimalToBinary(num / 2) + String.valueOf(num % 2);
    }

    /**
     * Recursive implementation of is prime
     * @param num
     * @param divisor
     * @return
     */
    public static boolean isPrimeRecursive(int num, int divisor) {
        if(divisor == 1) return true;
        if(num % divisor == 0) return false;
        return isPrimeRecursive(num, divisor - 1);
    }
}
