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

    @Test
    public void testMaximumWaterV2() {
        int[] arr = {7, 1, 3, 4, 9};
        Assert.assertEquals(28, MaximumWater.maximumWaterV2(arr));
    }

    @Test
    public void testMaximumWaterEmptyArrayV2() {
        int[] arr = {};
        Assert.assertEquals(0, MaximumWater.maximumWaterV2(arr));
    }

    @Test
    public void testMaximumWaterSingleElementV2() {
        int[] arr = {7};
        Assert.assertEquals(0, MaximumWater.maximumWaterV2(arr));
    }

    @Test
    public void testMaximumWaterNullArray() {
        int[] arr = null;
        Assert.assertEquals(0, MaximumWater.maximumWaterV2(arr));
    }
}
