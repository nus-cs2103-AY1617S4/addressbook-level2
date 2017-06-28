package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

import java.awt.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Represents a Person's address in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidAddress(String)}
 */
public class Address {

    public static final String EXAMPLE = "123, some street";
    public static final String MESSAGE_ADDRESS_CONSTRAINTS = "Person addresses can be in any format";
    public static final String ADDRESS_VALIDATION_REGEX = "(\\w+)(, ([^,]+)?(, ([^,]+)?(, (\\d+)?)?)?)?";

    public final String value;
    private boolean isPrivate;
    private Block block;
    private Unit unit;
    private PostalCode postalCode;
    private Street street;
    
    /**
     * Validates given address.
     *
     * @throws IllegalValueException if given address string is invalid.
     */
    public Address(String address, boolean isPrivate) throws IllegalValueException {
        
        String trimmedAddress = address.trim();
        Pattern pattern = Pattern.compile(ADDRESS_VALIDATION_REGEX);
        Matcher matcher = pattern.matcher(trimmedAddress);
        
        if(matcher.find()){
            this.block = new Block(matcher.group(1));
            this.street = new Street(matcher.group(3));
            this.unit = new Unit(matcher.group(5));
            this.postalCode = new PostalCode(matcher.group(7));
            this.isPrivate = isPrivate;
        }
        else {
            throw new IllegalValueException(MESSAGE_ADDRESS_CONSTRAINTS);
        }
        this.value = this.toString();
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

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }
    @Override
    public String toString(){
        String result;
        result = block.getNumber();
        result += " " + street.getNumber();
        result += " " + unit.getNumber();
        result += " " + postalCode.getNumber();
        return result;
        
    }
}
