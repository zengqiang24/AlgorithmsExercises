package ProgrammingAssignment1;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private WeightedQuickUnionUF mWeightedQuickUnionUF;
    private int[][] grid;
    private int n;
    private int countOpenSite = 0;

    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException();
        }
        mWeightedQuickUnionUF = new WeightedQuickUnionUF(n);
        this.n = n;
        grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = n; //blocked grids in initial.
            }
        }
    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {
        if (isValidRange(row, col)) {
            throw new IllegalArgumentException();
        }
        if (!isOpen(row, col)) {
            grid[row][col] = row * 10 + col;
            if (row == 0) {
                mWeightedQuickUnionUF.union(grid[row][col], 0);
            }
            if (row == n - 1) {
                mWeightedQuickUnionUF.union(grid[row][col], (n-1)*10+n-1);
            }

// connect opened site around top left bottom right.
            int leftRow = row;
            int leftCol = col - 1;
            if (isOpen(leftRow, leftCol)) {
                mWeightedQuickUnionUF.union(grid[row][col], grid[leftRow][leftCol]);
            }

            int rightRow = row;
            int rightCol = col + 1;
            if (isOpen(rightRow, rightCol)) {
                mWeightedQuickUnionUF.union(grid[row][col], grid[rightRow][rightCol]);
            }
            int topRow = row - 1;
            int topCol = col;
            if (isOpen(topRow, topCol)) {
                mWeightedQuickUnionUF.union(grid[row][col], grid[topRow][topCol]);
            }
            int bottomRow = row + 1;
            int bottomCol = col;
            if (isOpen(bottomRow, bottomCol)) {
                mWeightedQuickUnionUF.union(grid[row][col], grid[bottomRow][bottomCol]);
            }
            countOpenSite++;
        }
    }

    private boolean isValidRange(int row, int col) {
        return 0 <= row && row < n && 0 <= col && col < n;
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        if (isValidRange(row, col)) {
            throw new IllegalArgumentException();
        }
        return grid[row][col] != n;
    }
//    012345678
//    10 11 18
//            88
//    9

    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
        if (isValidRange(row, col)) {
            throw new IllegalArgumentException();
        }
        return (mWeightedQuickUnionUF.connected(grid[row][col], 0));
    }

    // returns the number of open sites
    public int numberOfOpenSites() {
        return countOpenSite;
    }

    // does the system percolate?
    public boolean percolates() {
        return mWeightedQuickUnionUF.connected((n-1)*10+n-1, 0);
    }

    // test client (optional)
    public static void main(String[] args) {

    }

}
