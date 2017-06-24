package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's address in the address book. Guarantees: immutable; is
 * valid as declared in {@link #isValidAddress(String)}
 */
public class Address {

	public static final String EXAMPLE = "123, some street";
	public static final String MESSAGE_ADDRESS_CONSTRAINTS = "Person addresses should be in the format [BLOCK], [STREET], [UNIT](OPTIONAL)"
			+ ", [POSTAL CODE](OPTIONAL)";
	public static final String ADDRESS_VALIDATION_REGEX = ".+";
	private static final String PS = ", ";

	public Block block;
	public Street street;
	public Unit unit;
	public PostalCode postalCode;

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
		initialiseValues(trimmedAddress);
	}

	private void initialiseValues(String address) {
		String[] addressParts = address.split(",");
		block = new Block(addressParts[0].trim());
		street = new Street(addressParts[1].trim());
		if (addressParts.length > 2){unit = new Unit(addressParts[2].trim());}
		if (addressParts.length > 3){postalCode = new PostalCode(addressParts[3].trim());}
	}

	/**
	 * Returns true if a given string is a valid person address.
	 */
	public static boolean isValidAddress(String test) {
		return test.matches(ADDRESS_VALIDATION_REGEX);
	}

	@Override
	public String toString() {
		return block.toString() + PS + street.toString() + PS + unit.toString() + PS + postalCode.toString();
	}

	@Override
	public boolean equals(Object other) {
		return other == this // short circuit if same object
				|| (other instanceof Address // instanceof handles nulls
						&& this.block.equals(((Address) other).block)&& this.street.equals(((Address) other).street)
						&& this.unit.equals(((Address) other).unit)
						&& this.postalCode.equals(((Address) other).postalCode)); // state
																		// check
	}

	@Override
	public int hashCode() {
		return this.toString().hashCode();
	}

	public boolean isPrivate() {
		return isPrivate;
	}
}
