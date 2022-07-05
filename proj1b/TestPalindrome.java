import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

    @Test
    public void testIsPalindrome() {
        String word1 = "";
        assertTrue(palindrome.isPalindrome(word1));

        String word2 = " ";
        assertTrue(palindrome.isPalindrome(word2));

        String word3 = "abcd";
        assertFalse(palindrome.isPalindrome(word3));

        String word4 = "aA";
        assertFalse(palindrome.isPalindrome(word4));

        String word5 = "qwertyytrewq";
        assertTrue(palindrome.isPalindrome(word5));

        String word6 = "nolon";
        assertTrue(palindrome.isPalindrome(word6));
    }

    @Test
    public void testIsPalindrome2() {
        CharacterComparator cc = new OffByOne();
        String word1 = "";
        assertTrue(palindrome.isPalindrome(word1, cc));

        String word2 = "a";
        assertTrue(palindrome.isPalindrome(word2, cc));

        String word3 = "xY";
        assertFalse(palindrome.isPalindrome(word3, cc));

        String word4 = "acehfdb";
        assertTrue(palindrome.isPalindrome(word4, cc));

        String word5 = "qwerty";
        assertFalse(palindrome.isPalindrome(word5, cc));

        String word6 = "&l%";
        assertTrue(palindrome.isPalindrome(word6, cc));
    }
}
