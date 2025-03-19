
package algorithms.problemsolving;

public class Factors {
    public static void main(String[] args) {
      
       System.out.println(countFactors(24));
    }

    private static int countFactors(int N) {
        int ans = 0;
        for(int i = 1 ; i * i <= N; i++) {
            if(N % i == 0) {
                if(i == N / i) {
                    ans += 1;
                }
                ans += 2;
            }
        }
        return ans;
    }
}
