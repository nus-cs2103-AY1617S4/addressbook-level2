package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's address in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidAddress(String)}
 */
public class Address {

    public static final String EXAMPLE = "a/123, Clementi Ave 3, #12-34, 231534";
    public static final String MESSAGE_ADDRESS_CONSTRAINTS = "Person addresses should be in this format: a/BLOCK, STREET, UNIT, POSTAL_CODE";
    public static final String ADDRESS_VALIDATION_REGEX = ".+";
    private static final String ADDRESS_PREFIX = "a/";

    private static final int ADDRESS_INDEX_BLOCK = 0;
    private static final int ADDRESS_INDEX_STREET = 1;
    private static final int ADDRESS_INDEX_UNIT = 2;
    private static final int ADDRESS_INDEX_POSTALCODE = 3;
    private static final int ADDRESS_INDEX_TOTAL = 4;
    private static final String ADDRESS_SPLIT = ", ";
    
    private Block block;
    private Street street;
    private Unit unit;
    private PostalCode postalCode;
    private String wholeAddress = toString();
    
    private boolean isPrivate;

    /**
     * Validates given address.
     *
     * @throws IllegalValueException if given address string is invalid.
     */
    public Address(String address, boolean isPrivate) throws IllegalValueException {
        String trimmedAddress = removePrefix(address.trim(), ADDRESS_PREFIX);
        this.isPrivate = isPrivate;
        if (!isValidAddress(trimmedAddress)) {
            throw new IllegalValueException(MESSAGE_ADDRESS_CONSTRAINTS);
        }
        String[] addressArgs = trimmedAddress.split(ADDRESS_SPLIT);
        this.block = new Block(addressArgs[ADDRESS_INDEX_BLOCK]);
        this.street = new Street(addressArgs[ADDRESS_INDEX_STREET]);
        this.unit = new Unit(addressArgs[ADDRESS_INDEX_UNIT]);
        this.postalCode = new PostalCode(addressArgs[ADDRESS_INDEX_POSTALCODE]);
    }
    
    /**
     * Remove prefix of a string if it exists;
     * 
     * @param string to remove prefix
     * @param prefix
     * @return string with prefix removed
     */
    private String removePrefix(String str, String prefix) {
        if (str.startsWith(prefix)) {
            return str.substring(prefix.length());
        } else {
            return str;
        }
    }

    /**
     * Returns true if a given string is a valid person address.
     */
    public static boolean isValidAddress(String test) {
        return (test.matches(ADDRESS_VALIDATION_REGEX) && test.split(ADDRESS_SPLIT).length == ADDRESS_INDEX_TOTAL);
    }

    @Override
    public String toString() {
        String stringToPrint = block + ADDRESS_SPLIT + street + ADDRESS_SPLIT + unit + ADDRESS_SPLIT + postalCode;
        return stringToPrint;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Address // instanceof handles nulls
                && this.wholeAddress.equals(((Address) other).getWholeAddress())); // state check
    }

    @Override
    public int hashCode() {
        return wholeAddress.hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }
    
    public String getWholeAddress() {
        return wholeAddress;
    }
}
