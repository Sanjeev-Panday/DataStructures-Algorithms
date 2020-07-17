package datastructures;

import datastructures.adt.UnionFind;

public class WeightedQuickUnionUF implements UnionFind {
    private final int [] id;
    private final int [] weight;
    private int count;

    public WeightedQuickUnionUF(int n) {
        this.count = n;
        this.id = new int[n];
        this.weight = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
            weight[i] = 1;
        }
    }

    @Override
    public void union(int p, int q) {
        int rP = root(p);
        int rQ = root(q);
        if (rP == rQ) return;

        if (weight[rP] < weight[rQ]) {
            id[rP] = rQ;
            weight[rQ] += weight[rP];
        }else {
            id[rQ] = rP;
            weight[rP] += weight[rQ];
        }
        count--;
    }

    @Override
    public boolean isConnected(int p, int q) {
        int rP = root(p);
        int rQ = root(q);
        return (rP == rQ) ;
    }

    @Override
    public int root(int p) {
        while (p != id[p]) {
            p = id[p];
        }
        return p;
    }

    @Override
    public int count() {
        return count;
    }
}
