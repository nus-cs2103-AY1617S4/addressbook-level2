package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Represents a Person's address in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidAddress(String)}
 */
public class Address extends Contact {

    public static final String EXAMPLE = "123, some street";
    public static final String MESSAGE_ADDRESS_CONSTRAINTS = "Address is entered in the following format: BLOCK, STREET, UNIT, POSTAL_CODE ";
    public static final String ADDRESS_VALIDATION_REGEX = "(\\w+)(, ([^,]+)?(, ([^,]+)?(, (\\d+))?)?)?";
    
    private Block block;
    private Street street;
    private Unit unit;
    private PostalCode postalCode;

    /**
     * Validates given address.
     *
     * @throws IllegalValueException if given address string is invalid.
     */
    public Address(String address, boolean isPrivate) throws IllegalValueException {
    	
    	String trimmedAddress = address.trim();
    	super.isPrivate = isPrivate;
    	
        Pattern parserPattern = Pattern.compile(ADDRESS_VALIDATION_REGEX);
        Matcher parserMatcher = parserPattern.matcher(trimmedAddress);

        if (parserMatcher.find()) {
           block = new Block(parserMatcher.group(1));
           street = new Street(parserMatcher.group(3));
           unit = new Unit(parserMatcher.group(5));
           postalCode = new PostalCode(parserMatcher.group(7));
        }
        else {
           throw new IllegalValueException(MESSAGE_ADDRESS_CONSTRAINTS);
        }
        
        value = block.getValue() + ", " +  street.getValue() + ", " + unit.getValue() + ", " + postalCode.getValue();
    }

    /**
     * Returns true if a given string is a valid person address.
     */
    public static boolean isValidAddress(String test) {
        return test.matches(ADDRESS_VALIDATION_REGEX);
    }


    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Address // instanceof handles nulls
                && this.value.equals(((Address) other).value)); // state check
    }
}

class Block {
	 private String value;
	 
	 public Block(String value) {
		this.value = value;
	}
	
	 public String getValue() {
		return value;
	}
}
class Street {
	 private String value;
	 
	 public Street(String value) {
		this.value = value;
	}
	
	 public String getValue() {
		return value;
	}
}
class Unit {
	 private String value;
	 
	 public Unit(String value) {
		this.value = value;
	}
	
	 public String getValue() {
		return value;
	}
}
	 
class PostalCode {
	 private String value;
	 
	 public PostalCode(String value) {
		this.value = value;
	}
	
	 public String getValue() {
		return value;
	}
}