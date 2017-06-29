package seedu.addressbook.data.person;

/**
 * Represents Contact details of a Person in AddressBook. extends to Address,
 * Phone, Email
 */
public class Contact {

    protected String value;
    protected boolean isPrivate;

    public Contact() {
        value = new String();
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}