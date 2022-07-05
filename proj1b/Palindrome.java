public class Palindrome {

    /** Returns a Deque where the characters appear in the same order as in the String.*/
    public Deque<Character> wordToDeque(String word) {
        Deque deque = new LinkedListDeque();
        int numChars = word.length();
        for (int i = 0; i < numChars; i += 1) {
            deque.addLast(word.charAt(i));
        }
        return deque;
    }

    /** Returns true if the given word is a palindrome.*/
    public boolean isPalindrome(String word) {
        Deque deque = wordToDeque(word);
        return isPalindromeRur(deque);
    }

    private boolean isPalindromeRur(Deque deque) {
        if (deque.size() == 1 || deque.size() == 0) {
            return true;
        }

        if (deque.removeFirst() != deque.removeLast()) {
            return false;
        }

        return isPalindromeRur(deque);
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        Deque deque = wordToDeque(word);
        return isPalindromeRur2(deque, cc);
    }

    private boolean isPalindromeRur2(Deque deque, CharacterComparator cc) {
        if (deque.size() == 1 || deque.size() == 0) {
            return true;
        }

        if (!cc.equalChars((char) deque.removeFirst(), (char) deque.removeLast())) {
            return false;
        }

        return isPalindromeRur2(deque, cc);
    }
}
