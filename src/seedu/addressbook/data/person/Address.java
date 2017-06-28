package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's address in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidAddress(String)}
 */
public class Address {

    public static final String EXAMPLE = "123, Clementi Ave 3, #12-34, 231534";
    public static final String MESSAGE_ADDRESS_CONSTRAINTS = "Person address must be in the following format: a/BLOCK, STREET, UNIT, POSTAL_CODE";
    public static final String ADDRESS_VALIDATION_REGEX = ".+";
    public static final String ADDRESS_SPLIT_BY = ",";

    public Block block;
    public Street street;
    public Unit unit;
    public PostalCode postalCode;
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
        initialiseValues(trimmedAddress);
    }
    private void initialiseValues(String address) {
    	String[] addressComponents = address.split("ADDRESS_SPLIT_BY");
    	block = new Block(addressComponents[0].trim());
    	if (addressComponents.length>1){
    		street = new Street(addressComponents[1].trim());
    	}
    	else{
    		street = new Street("");
    	}
    	if (addressComponents.length>2){
    		unit = new Unit(addressComponents[2].trim());
    	}
    	else{
    		unit = new Unit("");
    	}
    	if (addressComponents.length>3){
    		postalCode = new PostalCode(addressComponents[3].trim());
    	}
    	else{
    		postalCode = new PostalCode("");
    	}
    			
    }

    /**
     * Returns true if a given string is a valid person address.
     */
    public static boolean isValidAddress(String test) {
        return test.matches(ADDRESS_VALIDATION_REGEX);
    }

    @Override
    public String toString() {
    	String text = new String();
    	text+=block.toString();
    	text+=street.toString();
    	text+=unit.toString();
    	text+=postalCode.toString();
        return text;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Address // instanceof handles nulls
                && toString().equals(((Address) other).toString())); // state check
    }

    @Override
    public int hashCode() {
        return toString().hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }
}
