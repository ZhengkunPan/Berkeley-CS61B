public class OffByN implements CharacterComparator {

    private int difference;

    /** Creates an object.*/
    public OffByN(int N) {
        difference = N;
    }

    @Override
    public boolean equalChars(char x, char y) {
        if (Math.abs(x - y) == difference) {
            return true;
        }
        return false;
    }
}
