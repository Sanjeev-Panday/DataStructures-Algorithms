package algorithms;

import datastructures.WeightedQuickUnionUF;
import datastructures.adt.UnionFind;

public class Percolation {
   private final boolean [][] openSites;
   private final int n;
   private int numOfOpenSites;
   private final UnionFind uf;
   // creates n-by-n grid, with all sites initially blocked
   public Percolation(int n) {
      if (n <= 0) {
         throw new IllegalArgumentException();
      }
      this.uf = new WeightedQuickUnionUF(n*n);
      this.n = n;
      this.openSites = new boolean[n+1][n+1];
      // This is to connect the top row and bottom row with virtual nodes
      for (int i = 1; i < n; i++) {
         uf.union(0,i);
         uf.union((n*n)-1,(n*n)-i-1);
      }
   }
   // opens the site (row, col) if it is not open already
   public void open(int row, int col) {
      if (!isValidDim(row, col)) {
         throw new IllegalArgumentException();
      }
      if (!isOpen(row, col)) {
         openSites[row][col] = true;
         numOfOpenSites++;
         connectOpenNeighbors(row,col);
      }
   }

   private void connectOpenNeighbors(int row,int col) {
      int p = convertRowColToIndex(row,col);
      // top
      int q = convertRowColToIndex(row-1, col);
      if (q != -1 && isOpen(row-1, col))
         uf.union(p, q);

      // Bottom
      q = convertRowColToIndex(row+1 ,col);
      if (q != -1 && isOpen(row+1, col))
         uf.union(p, q);

      // Left
      q = convertRowColToIndex(row,col-1);
      if (q != -1 && isOpen(row,col-1))
            uf.union(p, q);
      // Right
      q = convertRowColToIndex(row,col+1);
      if (q != -1 && isOpen(row,col+1))
         uf.union(p, q);
   }

   // is the site (row, col) open?
   public boolean isOpen(int row, int col) {
      return openSites[row][col];
   }

   // is the site (row, col) full?
   public boolean isFull(int row, int col){
      if (!isOpen(row, col)) return false;
      int p = convertRowColToIndex(row, col);
      int a = uf.root(p);
      int b = uf.root(0);
      return a == b;
   }

   private int convertRowColToIndex(int row,int col) {
      if (isValidDim(row, col)) {
         return (row - 1) * n + col-1;
      }
      return -1;
   }
   private boolean isValidDim(int row,int col) {
      return row > 0 && col > 0
          && row <= n && col <= n;
   }
   // returns the number of open sites
   public int numberOfOpenSites(){
      return this.numOfOpenSites;
   }

   // does the system percolate?
   public boolean percolates(){
      int a = uf.root(0);
      int b = uf.root(n*n-1);
      return a == b;
   }
}
