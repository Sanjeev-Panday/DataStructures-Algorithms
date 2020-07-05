package datastructures;

import datastructures.adt.UnionFind;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class QuickFindUFTest {
    private UnionFind unionFind;

    @Before
    public void setUp() {
        unionFind = new QuickFindUF(10);
        unionFind.union(4,3);
        unionFind.union(3,8);
        unionFind.union(6,5);
        unionFind.union(9,4);
        unionFind.union(2,1);
        unionFind.union(5,0);
        unionFind.union(7,2);
        unionFind.union(6,1);

    }

    @Test
    public void testisConnected() {
        assertTrue( unionFind.isConnected(1,5));
        assertTrue(unionFind.isConnected(4,9));
        assertFalse(unionFind.isConnected(2,3));
    }
    @Test
    public void testComponentCount() {
        assertEquals(2,unionFind.count());
    }
}
