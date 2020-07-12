package algorithms;

import java.util.HashSet;
import java.util.Scanner;

/**
 * Find triplets (a,b,c) such that for every path between two nodes ( of the triplet ) there is at least one red edge
 */
public class TripletsRedBlackTreeDisjointSet {
    // Array for nodes
    int[] id;
    // Size array to hold component size
    int[] sz;
    int N;
    public TripletsRedBlackTreeDisjointSet(int N) {
        this.N = N;
        id = new int[N+1];
        sz = new int[N+1];
        for(int i=1;i<=N;i++){
            id[i] = i;
            sz[i] = 1;
        }
    }
    public long countTripletsOfRedBlack(){

        // Find out total components of black edges
        HashSet<Integer> uniques = new HashSet<>();
        for(int i = 1;i < N+1; i++) {
            if(sz[i] > 1) {
                uniques.add(id[i]);
            }
        }

        long totalPossibleCombOf3 = combinationsOf3(N);

        for(int x:uniques) {
            int size = sz[x]; // size of black component x
            long totalComOf3WithOnlyBlack  = combinationsOf3(size);
            totalPossibleCombOf3 -= totalComOf3WithOnlyBlack;
            totalPossibleCombOf3 -= combinationsOf2(size) * (N-size);
        }
        long mode = 100_00_00_00_7;
        return totalPossibleCombOf3 % mode;
    }
    void union(int p,int q) {
        int a = findParent(p);
        int b = findParent(q);
        if( a == b) return;
        if(sz[a] < sz[b]) {
            id[a] = b;
            sz[b] += sz[a];
        }else{
            id[b] = a;
            sz[a] += sz[b];
        }
    }
    int findParent(int p) {
        while(p != id[p]) {
            p = id[p];
        }

        return p;
    }
    long combinationsOf3(int n) {
        if( n < 3) return 0;
        long ans = 1;
        for(int i = n;i> (n-3);i--) {
            ans *= i;
        }
        return ans/6;
    }

    long combinationsOf2(int n) {
        if( n < 2) return 0;
        long ans = 1;
        for(int i = n;i>(n-2);i--) {
            ans *= i;
        }
        return ans/2;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        TripletsRedBlackTreeDisjointSet triplets = new TripletsRedBlackTreeDisjointSet(N);
        for(int i=0;i<N-1;i++) {
            int p = sc.nextInt();
            int q = sc.nextInt();
            String c = sc.next();
            if(c.equals("b")){
                triplets.union(p,q);
            }
        }
        long ans = triplets.countTripletsOfRedBlack();
        System.out.println(ans);
    }
}
