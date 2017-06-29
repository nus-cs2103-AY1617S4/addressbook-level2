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
    
    public static final int ADDRESS_BLOCK_INDEX = 0;
    public static final int ADDRESS_STREET_INDEX = 1;
    public static final int ADDRESS_UNIT_INDEX = 2;
    public static final int ADDRESS_CODE_INDEX = 3;
    
    public static final String ADDRESS_SPLIT_REGEX = ",";
    
    
    private Block block;
    private Street street;
    private Unit unit;
    private postalCode code;
    private boolean isPrivate;
    
    public String value;

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
        this.value = trimmedAddress;
        		
        String[] addressBySections = trimmedAddress.split(ADDRESS_SPLIT_REGEX);
        this.setBlock(new Block(addressBySections[ADDRESS_BLOCK_INDEX]));
        this.setStreet(new Street(addressBySections[ADDRESS_STREET_INDEX]));
        this.setUnit(new Unit(addressBySections[ADDRESS_UNIT_INDEX]));
        this.setCode(new postalCode(addressBySections[ADDRESS_CODE_INDEX]));
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

	public Block getBlock() {
		return block;
	}

	public void setBlock(Block block) {
		this.block = block;
	}

	public Street getStreet() {
		return street;
	}

	public void setStreet(Street street) {
		this.street = street;
	}

	public postalCode getCode() {
		return code;
	}

	public void setCode(postalCode code) {
		this.code = code;
	}

	public Unit getUnit() {
		return unit;
	}

	public void setUnit(Unit unit) {
		this.unit = unit;
	}
}
