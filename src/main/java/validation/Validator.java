package validation;

import exception.NameFormatException;

public class Validator {

    public void validateName(String text, int min, int max) throws NameFormatException {
        if (text.length() < min || text.length() > max) {
            throw new NameFormatException(text, min, max);
        }
    }
}
