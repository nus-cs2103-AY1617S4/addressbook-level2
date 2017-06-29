package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's postal code in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidCode(String)}
 */
public class postalCode {

    public static final String EXAMPLE = "123123";
    public static final String MESSAGE_CODE_CONSTRAINTS = "Postal Code should only contain numbers";
    public static final String CODE_VALIDATION_REGEX = "\\d+";

    public final String value;

    /**
     * Validates given phone number.
     *
     * @throws IllegalValueException if given code string is invalid.
     */
    public postalCode(String code) throws IllegalValueException {
        String trimmedCode = code.trim();
        if (!isValidCode(trimmedCode)) {
            throw new IllegalValueException(MESSAGE_CODE_CONSTRAINTS);
        }
        this.value = trimmedCode;
    }

    /**
     * Returns true if the given string is a valid person postal code number.
     */
    public static boolean isValidCode(String test) {
        return test.matches(CODE_VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof postalCode // instanceof handles nulls
                && this.value.equals(((postalCode) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

}
