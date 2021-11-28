import java.util.*;

class AsciiCharSequence implements CharSequence {

    private final byte[] input;

    public AsciiCharSequence(byte[] input) {
        this.input = Arrays.copyOfRange(input, 0, input.length);
    }

    @Override
    public int length() {
        return input.length;
    }

    @Override
    public char charAt(int index) {
        return (char) input[index];
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        byte[] subInput = Arrays.copyOfRange(input, start, end);
        return new AsciiCharSequence(subInput);
    }

    @Override
    public String toString() {
        return new String(input);
    }
}