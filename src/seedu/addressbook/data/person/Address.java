package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's address in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidAddress(String)}
 */
public class Address extends Contact	{

    public static final String EXAMPLE = "123, Jurong West Avenue 1, #10-10, 678543";
    public static final String MESSAGE_ADDRESS_CONSTRAINTS = "Person address must follow format: a/Block, Street, Unit, PostalCode";
    public static final String ADDRESS_VALIDATION_REGEX = ".+";
    public static final String ADDRESS_SPLIT_BY = ",";

    public Block block;
    public Street street;
    public Unit unit;
    public PostalCode postalCode;

    /**
     * Validates given address.
     *
     * @throws IllegalValueException if given address string is invalid.
     */
    public Address(String address, boolean isPrivate) throws IllegalValueException {
    	super(address, isPrivate);
    	if (!isValidAddress(value)){
            throw new IllegalValueException(MESSAGE_ADDRESS_CONSTRAINTS);
        }
    }
    
    /*takes address input, splits into components
     *  and initializes each class within address*/
    public void initialiseAddress(String address){
    	String[] addressComponents = address.split(ADDRESS_SPLIT_BY);
    	block = new Block(addressComponents[0].trim());
    	if (addressComponents.length > 1){
    		street = new Street(addressComponents[1].trim());
    	}
    	else {
    		street = new Street("");
    	}
    	if (addressComponents.length > 2){
    		unit = new Unit(addressComponents[2].trim());
    	}
    	else{
    		unit = new Unit("");
    	}
    	if (addressComponents.length >3){
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
        String line = new String();
        line+=block.toString();
        line+=street.toString();
        line+=unit.toString();
        line+=postalCode.toString();
        return line;
    }

}
