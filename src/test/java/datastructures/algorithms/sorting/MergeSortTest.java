package datastructures.algorithms.sorting;

import algorithms.sorting.Merge;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Arrays;

import static algorithms.util.Helper.isSorted;
@RunWith(JUnit4.class)
public class MergeSortTest {

    @Test
    public void testSortOdd() {
        Integer[] arr = new Integer[]{3,5,6,9,1,2,10};
        Merge.sort(arr);
        Assert.assertTrue(isSorted(arr,0,arr.length-1));
    }

    @Test
    public void testSortEven() {
        Integer[] arr = new Integer[]{10,11,7,3,5,6,9,1};
        Merge.sort(arr);
        Assert.assertTrue(isSorted(arr,0,arr.length-1));
    }

}