package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents an Address Unit in the Person's Address data.
 * Guarantees: immutable; is valid as declared in {@link #isValidUnit(String)}
 */
public class Unit {

    public static final String EXAMPLE = "123";
    public static final String MESSAGE_UNIT_CONSTRAINTS = "Unit can be in any format";
    public static final String UNIT_VALIDATION_REGEX = ".+";

    public final String unitValue;
    private boolean isPrivate;
    
    /**
     * Validates given unit.
     *
     * @throws IllegalValueException if given unit string is invalid.
     */
    public Unit(String unit, boolean isPrivate) throws IllegalValueException {
        String trimmedUnit = unit.trim();
        this.isPrivate = isPrivate;
        if (!isValidUnit(trimmedUnit)) {
            throw new IllegalValueException(MESSAGE_UNIT_CONSTRAINTS);
        }
        this.unitValue = trimmedUnit;
    }

    /**
     * Returns true if a given string is a valid person address unit.
     */
    public static boolean isValidUnit(String test) {
        return test.matches(UNIT_VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return unitValue;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Unit // instanceof handles nulls
                && this.unitValue.equals(((Unit) other).unitValue)); // state check
    }

    @Override
    public int hashCode() {
        return unitValue.hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }
}
