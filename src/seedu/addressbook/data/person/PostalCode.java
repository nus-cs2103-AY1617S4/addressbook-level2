package seedu.addressbook.data.person;

public class PostalCode {
	private final String value;

	public PostalCode(String val) {
		value = val;
	}

	public String getPostalCode() {
		return value;
	}

	@Override
	public String toString() {
		return value;
	}

	@Override
	public boolean equals(Object other) {
		return other == this // short circuit if same object
				|| (other instanceof PostalCode // instanceof handles nulls
						&& this.value.equals(((PostalCode) other).getPostalCode())); // state
																						// check
	}

	@Override
	public int hashCode() {
		return value.hashCode();
	}

}
