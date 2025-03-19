package algorithms.problemsolving;

public class Prime {
    public static void main(String[] args) {
        System.out.println(isPrime(37));
        System.out.println(isPrime(21));
    }

    private static boolean isPrime(int N) {
        for(int i = 2; i * i <= N; i++) {
            if(N % i == 0 && i != N/i) {
                return false;
            }
        }
        return true;
    }
    
}
