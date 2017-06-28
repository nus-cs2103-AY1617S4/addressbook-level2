package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's address in the address book. Guarantees: immutable; is
 * valid as declared in {@link #isValidAddress(String)}
 */
public class Address {

    public static final String EXAMPLE = "123, Clementi Ave 3, #12-34, 231534";
    public static final String MESSAGE_ADDRESS_CONSTRAINTS = "Person addresses must be in form of <BLOCK, STREET, UNIT, POSTAL_CODE>";
    public static final String ADDRESS_VALIDATION_REGEX = ".+";

    public static final int ADDRESS_DATA_INDEX_BLOCK = 0;
    public static final int ADDRESS_DATA_INDEX_STREET = 1;
    public static final int ADDRESS_DATA_INDEX_UNIT = 2;
    public static final int ADDRESS_DATA_INDEX_POSTALCODE = 3;
    public static final String ADDRESS_DATA_SPLITTER = ", ";

    private final Block block;
    private final Street street;
    private final Unit unit;
    private final PostalCode postalCode;
    private boolean isPrivate;

    /**
     * Validates given address.
     *
     * @throws IllegalValueException
     *             if given address string is invalid.
     */
    public Address(String address, boolean isPrivate) throws IllegalValueException {
        String trimmedAddress = address.trim();
        this.isPrivate = isPrivate;
        if (!isValidAddress(trimmedAddress)) {
            throw new IllegalValueException(MESSAGE_ADDRESS_CONSTRAINTS);
        }
        String[] splittedAddress = address.split(ADDRESS_DATA_SPLITTER);
        this.block = new Block(splittedAddress[ADDRESS_DATA_INDEX_BLOCK],isPrivate);
        this.street = new Street(splittedAddress[ADDRESS_DATA_INDEX_STREET],isPrivate);
        this.unit = new Unit(splittedAddress[ADDRESS_DATA_INDEX_UNIT],isPrivate);
        this.postalCode = new PostalCode(splittedAddress[ADDRESS_DATA_INDEX_POSTALCODE],isPrivate);
    }

    /**
     * Returns true if a given string is a valid person address.
     */
    public static boolean isValidAddress(String test) {
        return test.matches(ADDRESS_VALIDATION_REGEX) && test.split(ADDRESS_DATA_SPLITTER).length>=4;
    }

    @Override
    public String toString() {
        return this.block + ADDRESS_DATA_SPLITTER + this.street + ADDRESS_DATA_SPLITTER + this.unit
                + ADDRESS_DATA_SPLITTER + this.postalCode;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Address // instanceof handles nulls
                        && this.toString().equals(((Address) other).toString())); // state
                                                                                  // check
    }

    @Override
    public int hashCode() {
        return toString().hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }
}
