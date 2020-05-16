import junit.framework.TestCase;
import org.junit.Test;

public class BinarySearchTreeTest extends TestCase {

    private BinarySearchTree<Integer> bst;

    @Override
    protected void setUp() throws Exception {
        bst = new BinarySearchTree<Integer>();
        bst.insert(8);
        bst.insert(10);
        bst.insert(3);
        bst.insert(1);
        bst.insert(6);
        bst.insert(14);
        bst.insert(4);
        bst.insert(7);
        bst.insert(13);
    }
    @Test
    public void testSize() {
        assertEquals(9,bst.size());
    }
    @Test
    public void testSuccessorWithRightChild() {
         Integer successor = bst.successor(10);
         int val = successor.intValue();
         assertEquals(13,val);
    }
    @Test
    public void testSuccessorForLeaf() {
        Integer successor = bst.successor(7);
        int val = successor.intValue();
        assertEquals(8,val);
    }
    @Test
    public void testInsert(){
        bst.insert(19);
        assertEquals(10,bst.size());
    }
    @Test
    public void testFindPresent() {
        assertTrue(bst.find(13));
    }
}
