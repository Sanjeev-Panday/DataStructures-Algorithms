package datastructures.algorithms.util;

import algorithms.util.StringUtil;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class StringUtilTest {
    @Test
    public void testReverseString() {
        assertEquals("olleH",StringUtil.reverseAString("Hello"));
        assertEquals("dlroW olleH",StringUtil.reverseAString("Hello World"));
    }

    @Test
    public void removeDuplicates() {
        assertEquals("Helo",StringUtil.removeAdjacentDuplicates("Hello"));
        assertEquals("Helo World",StringUtil.removeAdjacentDuplicates("Hellloo Worrlldd"));
    }
}
