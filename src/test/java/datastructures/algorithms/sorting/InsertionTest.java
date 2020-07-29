package datastructures.algorithms.sorting;

import algorithms.sorting.Insertion;
import algorithms.sorting.Selection;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static algorithms.util.Helper.isSorted;

@RunWith(JUnit4.class)
public class InsertionTest {

    @Test
    public void testSortInteger() {
        Integer[] arr = new Integer[]{3,5,6,9,1,2,10};
        Insertion.sort(arr);
        Assert.assertTrue(isSorted(arr));
    }

}

