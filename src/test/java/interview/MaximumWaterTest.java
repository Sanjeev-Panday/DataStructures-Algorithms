package interview;

import org.junit.Assert;
import org.junit.Test;

public class MaximumWaterTest {

    @Test
    public void testMaximumWater() {
        int[] arr = {7, 1, 3, 4, 9};
        Assert.assertEquals(28, MaximumWater.maximumWater(arr));
    }

    @Test
    public void testMaximumWaterEmptyArray() {
        int[] arr = {};
        Assert.assertEquals(0, MaximumWater.maximumWater(arr));
    }

    @Test
    public void testMaximumWaterSingleElement() {
        int[] arr = {7};
        Assert.assertEquals(0, MaximumWater.maximumWater(arr));
    }
}
