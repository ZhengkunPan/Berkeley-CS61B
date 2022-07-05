import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByN {

    @Test
    public void testEqualChars() {
        CharacterComparator obn = new OffByN(2);

        assertTrue(obn.equalChars('a', 'c'));
        assertFalse(obn.equalChars('p', 'c'));

        assertTrue(obn.equalChars('c', 'a'));
        assertFalse(obn.equalChars('c', 'p'));

        assertFalse(obn.equalChars('C', 'a'));
        assertFalse(obn.equalChars('M', 'p'));

        assertFalse(obn.equalChars('^', '&'));
    }
}
