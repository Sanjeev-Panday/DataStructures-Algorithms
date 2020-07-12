package datastructures.adt;

public interface UnionFind {

    void union(int p, int q);
    boolean isConnected(int p, int q);
    int root(int p);
    int count();
}
