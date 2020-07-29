package datastructures.algorithms.sorting;

import algorithms.sorting.Merge;
import algorithms.sorting.Shell;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static algorithms.util.Helper.isSorted;

@RunWith(JUnit4.class)
public class ShellSortTest {

    @Test
    public void testSortOdd() {
        Integer[] arr = new Integer[]{3,5,6,9,1,2,10,18,17,13,11};
        Shell.sort(arr);
        Assert.assertTrue(isSorted(arr,0,arr.length-1));
    }

    @Test
    public void testSortEven() {
        Integer[] arr = new Integer[]{10,11,7,3,5,6,9,1};
        Shell.sort(arr);
        Assert.assertTrue(isSorted(arr,0,arr.length-1));
    }

}