package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's address postal code in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidPostal(String)}
 */
public class PostalCode {

    public static final String EXAMPLE = "231534";
    public static final String MESSAGE_POSTAL_CONSTRAINTS = "Postal Code can be in any format";
    public static final String POSTAL_VALIDATION_REGEX = ".+";

    public final String postalCodeValue;
    private boolean isPrivate;
    
    /**
     * Validates given address.
     *
     * @throws IllegalValueException if given address postalcode string is invalid.
     */
    public PostalCode(String postalcode, boolean isPrivate) throws IllegalValueException {
        String trimmedPostalCode = postalcode.trim();
        this.isPrivate = isPrivate;
        if (!isValidPostal(trimmedPostalCode)) {
            throw new IllegalValueException(MESSAGE_POSTAL_CONSTRAINTS);
        }
        this.postalCodeValue = trimmedPostalCode;
    }

    /**
     * Returns true if a given string is a valid person address postal code.
     */
    public static boolean isValidPostal(String test) {
        return test.matches(POSTAL_VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return postalCodeValue;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof PostalCode // instanceof handles nulls
                && this.postalCodeValue.equals(((PostalCode) other).postalCodeValue)); // state check
    }

    @Override
    public int hashCode() {
        return postalCodeValue.hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }
}
