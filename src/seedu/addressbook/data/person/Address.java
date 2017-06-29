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

    public final String value;
    private boolean isPrivate;
    
    private Block addressBlock;
    private Street addressStreet;
    private Unit addressUnit;
    private PostalCode addressPostalCode;

    /**
     * Validates given address.
     *
     * @throws IllegalValueException if given address string is invalid.
     */
    public Address(String address, boolean isPrivate) throws IllegalValueException {
        String trimmedAddress = address.trim();
        addressBlock = new Block();
        addressStreet = new Street();
        addressUnit = new Unit();
        addressPostalCode = new PostalCode();
        
        
        String[] splitTrimmedAddress = trimmedAddress.split("\\s*,\\s*");
//      a/BLOCK, STREET, UNIT, POSTAL_CODE
        if (splitTrimmedAddress.length >= 1){
            addressBlock = new Block(splitTrimmedAddress[0]);
           
        }
        if (splitTrimmedAddress.length >= 2){
            addressStreet = new Street(splitTrimmedAddress[1]);
        }
        if (splitTrimmedAddress.length >= 3){
            addressUnit = new Unit(splitTrimmedAddress[2]);
        }
        if (splitTrimmedAddress.length >= 4){
            addressPostalCode = new PostalCode(splitTrimmedAddress[3]);
        }
        
        this.isPrivate = isPrivate;
        if (!isValidAddress(trimmedAddress)) {
            throw new IllegalValueException(MESSAGE_ADDRESS_CONSTRAINTS);
        }
        
        this.value = trimmedAddress;
    }

    /* Returns address postal code */
    public String getPostalCode(){
        return addressPostalCode.getPostalCode();
    }
    
    /* Returns address unit code */
    public String getUnit(){
        return addressUnit.getUnit();
    }
    
    /* Returns address street code */
    public String getStreet(){
        return addressStreet.getStreet();
    }
    
    /* Returns address block code */
    public String getBlock(){
        return addressBlock.getBlock();
    }
    
    /**
     * Returns true if a given string is a valid person address.
     */
    public static boolean isValidAddress(String test) {
        return test.matches(ADDRESS_VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Address // instanceof handles nulls
                && this.value.equals(((Address) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }
}
