import org.junit.Test;
import static org.junit.Assert.*;

/** Tests the AList class.
 *  @author Zhengkun Pan
 */

public class ArrayDequeTest {

    @Test
    public void testEmptySize() {
        ArrayDeque arr = new ArrayDeque();
        assertEquals(0, arr.size());
    }

    @Test
    public void testAddRemove() {
        ArrayDeque arr = new ArrayDeque();
        arr.addFirst(3);
        arr.addFirst(4);
        arr.addFirst(5);
        arr.addFirst(6);
        arr.addFirst(7);
        arr.addFirst(8);

    }
}
