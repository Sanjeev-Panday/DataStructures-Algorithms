package datastructures;

import datastructures.adt.UnionFind;

public class QuickFindUF implements UnionFind {
    private int[] id;
    private int count;
    private int N;
    // Initialize the array with index values, each value forms its own set.
    public QuickFindUF(int N) {
        this.N = N;
        for(int i = 0;i < N; i++) {
            id[i] = i;
        }
        // at the start number of components is equals to the size of Array or total number of objects.
        this.count = N;
    }

    @Override
    public void union(int p, int q) {
        // If p  , q are not connect , merge these two
        if(!isConnected(p,q)) {
            int a = find(p); // component to which p belongs to
            int b = find(q); // component to which q belongs to
            // update all the indexes with value a to b
            for (int i = 0; i < N; i++) {
                if(id[i] == a) id[i] = b;
            }
            count--;
        }
    }

    @Override
    public boolean isConnected(int p, int q) { //Very fast O(1) - constant time
        return id[p] == id[q];
    }

    /**
     * This methods finds the set ( or component ) to which p belongs to.
     * @param p
     * @return
     */
    @Override
    public int find(int p) { // Very fast - O(1) - constant time.
        return id[p];
    }

    @Override
    public int count() {
        return count;
    }
}
