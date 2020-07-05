package validation;

import exception.StringLengthFormatException;
import exception.TypeFormatException;
import exception.ValueFormatException;

public class Validator {

    public void validateStringLength(String text, int min, int max) throws StringLengthFormatException {
        if (text.length() < min || text.length() > max) {
            throw new StringLengthFormatException(min, max);
        }
    }

    public void validateValue(String numberString, int min, int max) throws ValueFormatException {
        try {
            int value = Integer.parseInt(numberString);
            if (value < min || value > max) {
                throw new ValueFormatException(min, max);
            }
        } catch (NumberFormatException e) {
            throw new ValueFormatException(min, max);
        }
    }

    public void validateType(String text, String type1, String type2) throws TypeFormatException {
        if (text == null
                || (!text.toUpperCase().equals(type1.toUpperCase()) && !text.toUpperCase().equals(type2.toUpperCase()))) {
            throw new TypeFormatException(type1, type2);
        }
    }
}
