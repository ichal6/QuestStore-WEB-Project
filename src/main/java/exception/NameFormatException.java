package exception;

public class NameFormatException extends Exception {
    public NameFormatException(String text, int min, int max) {
        super(String.format("Given name '%s' has incorrect format. It should contain from %d to %d characters.", text, min, max));
    }
}
