package datastructures.algorithms.sorting;

import algorithms.sorting.Quick;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static algorithms.util.Helper.isSorted;

@RunWith(MockitoJUnitRunner.class)
public class QuickSortTest {

    @Test
    public void testSortOdd() {
        Integer[] arr = new Integer[]{3,5,6,9,1,2,10};
        Quick.sort(arr);
        Assert.assertTrue(isSorted(arr,0,arr.length-1));
    }

    @Test
    public void testSortEven() {
        Integer[] arr = new Integer[]{10,11,7,3,5,6,9,1};
        Quick.sort(arr);
        Assert.assertTrue(isSorted(arr,0,arr.length-1));
    }

}
