package seedu.addressbook.data.person;

/**
 * General Class for contact details of Person( Email, Address, Phone )
 * Represents a general contact detail
 * @author shuqi
 *
 */

public class Contact {

	private boolean isPrivate;
	public String value;

	public Contact(String value, boolean isPrivate) {
		this.value = value;
		this.isPrivate = isPrivate;
	}
	
	public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Contact // instanceof handles nulls
                && this.value.equals(((Contact) other).value)); // state check
    }
	
	public boolean isPrivate() {
	    return isPrivate;
	}

	@Override
	public int hashCode() {
	    return value.hashCode();
	}

	@Override
	public String toString() {
	    return value;
	}

}