package seedu.addressbook.data.person;

/**
 * Represents a piece of contact information.
 */
public class Contact {
    protected String value;
    protected boolean isPrivate;

    /**
     * Default constructor: ensures that there is no null reference
     */
    public Contact() {
        value = new String();
    }

    @Override
    public String toString() {
        return value;
    }

    /**
     * Alternative getter for clearer code
     */
    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
            || (other instanceof Contact // instanceof handles nulls
            && this.value.equals(((Contact)other).value)); // state check
    }
    
    @Override
    public int hashCode() {
        return value.hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }
}