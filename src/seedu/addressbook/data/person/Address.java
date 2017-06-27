package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's address in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidAddress(String)}
 */
public class Address {

    public static final String EXAMPLE = "123, some street";
    public static final String MESSAGE_ADDRESS_CONSTRAINTS = "Person addresses can be in any format";
    public static final String ADDRESS_VALIDATION_REGEX = ".+";
    
    private static final int INDEX_BLOCK = 0;
    private static final int INDEX_STREET = 1;
    private static final int INDEX_UNIT = 2;
    private static final int INDEX_POSTAL_CODE = 3;

    //public final String value;
    private Block _block;
    private Street _street;
    private Unit _unit;
    private PostalCode _postalCode;
    
    private boolean isPrivate;

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
        
        //this.value = trimmedAddress;
        decomposeAddress(trimmedAddress);
    }
    
    /**
     * Breaksdown an address into block, street, unit and postal code.
     */
    private void decomposeAddress(String trimmedAddress){
        String[] decomposedAddress = trimmedAddress.split(",");
        
        this._block = new Block(decomposedAddress[INDEX_BLOCK].trim());
        this._street = new Street(decomposedAddress[INDEX_STREET].trim());
        this._unit = new Unit(decomposedAddress[INDEX_UNIT].trim());
        this._postalCode = new PostalCode(decomposedAddress[INDEX_POSTAL_CODE].trim());
    }
    
    /**
     * Returns true if a given string is a valid person address.
     */
    public static boolean isValidAddress(String test) {
        return test.matches(ADDRESS_VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        //return value;
        return _block.getValue() + ", " + _street.getValue() + ", "
                + _unit.getValue() + ", " + _postalCode.getValue();
    }
    
    public String getValue(){
        return this.toString();
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Address // instanceof handles nulls
                && this.getValue().equals(((Address) other).getValue())); // state check
    }

    @Override
    public int hashCode() {
        return getValue().hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }
}
