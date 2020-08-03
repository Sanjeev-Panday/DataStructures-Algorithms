package datastructures.algorithms.util;

import algorithms.util.Helper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class HelperTest {

    @Test
    public void testShuffle() {
        Integer[] arr = {1,2,3,4,5,6,7,8};
        Helper.shuffle(arr);
        Assert.assertFalse(Helper.isSorted(arr,0,arr.length-1));
    }
}
