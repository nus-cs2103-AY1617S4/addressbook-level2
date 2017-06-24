package seedu.addressbook.data.person;

public class Street {
	private final String streetName;

	public Street(String streetName) {
		this.streetName = streetName;
	}

	public String getStreetName() {
		return streetName;
	}

	@Override
	public String toString() {
		return streetName;
	}

	@Override
	public boolean equals(Object other) {
		return other == this // short circuit if same object
				|| (other instanceof Street // instanceof handles nulls
						&& this.streetName.equals(((Street) other).getStreetName())); // state
																						// check
	}

	@Override
	public int hashCode() {
		return streetName.hashCode();
	}

}
