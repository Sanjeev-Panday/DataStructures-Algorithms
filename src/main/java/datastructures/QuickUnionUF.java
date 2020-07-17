package datastructures;

import datastructures.adt.UnionFind;

/**
 * Quick Union implementation of Union find ADT
 * This is a lazy algorithm which in which union operation is optimized
 */
public class QuickUnionUF implements UnionFind {
    private int[] id;
    private int N;
    private int count;
    public QuickUnionUF(int N) {
        // initialized the id array
        this.N = N;
        id = new int[N];
        for ( int i = 0; i < N; i++ ){
            id[i] = i;
        }
        this.count = N; // initially all the elements were part of its own tree. ( component)
    }
    @Override
    public void union(int p, int q) {
        int rp = root(p);
        int rq = root(q);

        // do nothing if both the elements belongs to the same component ( tree )
        if(rp == rq) return;
        id[rp] = rq; // attach first tree to second tree.
        count--;
    }

    @Override
    public boolean isConnected(int p, int q) {
        int rp = root(p);
        int rq = root(q);
        return rp == rq;
    }

    @Override
    public int root(int p) {
        // id[p] is  parent of p, and by traversing id[p] we can reach to the root of the tree to which
        // p belongs to
        // e.g. id[id[id[...id[i]...]]] would be the root of the tree to which i belongs to.
        while( p != id[p]) p = id[p];
        return p;
    }

    /**
     * This method returns total number of connected components
     * @return
     */
    @Override
    public int count() {
        return this.count;
    }
}
