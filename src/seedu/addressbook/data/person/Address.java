package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;
import seedu.addressbook.data.person.Contact;
import java.util.ArrayList;

/**
 * Represents a Person's address in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidAddress(String)}
 */
public class Address extends Contact {

    public static final String EXAMPLE = "123, Clementi Ave 3, #12-34, 231534";
    public static final String MESSAGE_ADDRESS_CONSTRAINTS = "Addresses must be in the format \"BLOCK, STREET, UNIT[optional], POSTAL_CODE[optional]\"";

    private static final int MIN_NUMBER_ADDR_FIELDS = 2;
    private static final int MAX_NUMBER_ADDR_FIELDS = 4;

    private static final int BLOCK_DATA_IDX = 0;
    private static final int STREET_DATA_IDX = 1;
    private static final int UNIT_DATA_IDX = 2;
    private static final int POSTAL_CODE_DATA_IDX = 3;
    
    private static final String BLOCK_VALIDATION_REGEX = "\\d+\\w?"; // block is a nonempty mixture of digits followed by an optional alphabet
    private static final String STREET_VALIDATION_REGEX = "(\\w|\\s|\\d)+"; // street is a nonempty mixture of alphabets, whitespace and digits
    private static final String UNIT_VALIDATION_REGEX = "\\#(\\d)+\\-(\\d)+"; // unit is #[digits]-[digits]
    private static final String POSTAL_CODE_VALIDATION_REGEX = "\\d+"; // postal code is nonempty mixture of digits

    private String[] addrFields;

    /**
     * Validates given address.
     *
     * @throws IllegalValueException if given address string is invalid.
     */
    public Address(String address, boolean isPrivate) throws IllegalValueException {
        String trimmedAddress = address.trim();
        this.isPrivate = isPrivate;
        if (!isValidAddress(trimmedAddress)) {
            throw new IllegalValueException(MESSAGE_ADDRESS_CONSTRAINTS);
        }
        this.addrFields = trimmedAddress.split(",");
        this.value = trimmedAddress;
    }

    /**
     * Returns true if a given string is a valid person address.
     */
    public static boolean isValidAddress(String test) {
        final String[] tempAddrFields = test.split(",");
        // check for correct number of fields
        if (tempAddrFields.length < MIN_NUMBER_ADDR_FIELDS
            || tempAddrFields.length > MAX_NUMBER_ADDR_FIELDS) {
            return false;
        }
        // check fields with regex
        if (!tempAddrFields[BLOCK_DATA_IDX].matches(BLOCK_VALIDATION_REGEX)) {
            return false;
        }
        if (!tempAddrFields[STREET_DATA_IDX].matches(STREET_VALIDATION_REGEX)) {
            return false;
        }
        if (tempAddrFields.length == 3) {
            if (!tempAddrFields[UNIT_DATA_IDX].matches(UNIT_VALIDATION_REGEX)
                && !tempAddrFields[UNIT_DATA_IDX].matches(POSTAL_CODE_VALIDATION_REGEX)) {
                return false;
            }
        } else if (tempAddrFields.length == 4) {
            if (!tempAddrFields[UNIT_DATA_IDX].matches(UNIT_VALIDATION_REGEX)) {
                return false;
            }
            if (!tempAddrFields[POSTAL_CODE_DATA_IDX].matches(POSTAL_CODE_VALIDATION_REGEX)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Address // instanceof handles nulls
                && this.value.equals(((Address) other).value)); // state check
    }

    /**
     * Separates the full address into block, street, unit and postal code fields.
     */
    private static ArrayList<String> extractAddrFields(String fullAddr) {
        final ArrayList<String> tempAddrFields = new ArrayList<>();
        while (true) {
            final int demarcIdx = fullAddr.indexOf(',');
            if (demarcIdx != -1) { // this is not the last field to be extracted
                tempAddrFields.add(fullAddr.substring(0, demarcIdx));
                fullAddr = fullAddr.substring(demarcIdx + 1).trim();
            } else { // this is the last field to be extracted
                tempAddrFields.add(fullAddr.trim());
                break;
            }
        }
        return tempAddrFields;
    }
}
