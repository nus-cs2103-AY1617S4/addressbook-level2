package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

public class Contact {
    public static String EXAMPLE;
    public static String MESSAGE_CONTACT_CONSTRAINTS;
    public static String ADDRESS_VALIDATION_REGEX;

    public final String value;
    private boolean isPrivate;

    /**
     * Validates given address.
     *
     * @throws IllegalValueException if given address string is invalid.
     */
    public Contact(String contact, boolean isPrivate, String example, String message, String regex) throws IllegalValueException {
        EXAMPLE = example;
        MESSAGE_CONTACT_CONSTRAINTS = message;
        ADDRESS_VALIDATION_REGEX = regex;
        this.isPrivate = isPrivate;
        String trimmedContact = contact.trim();
        if (!isValidContact(trimmedContact)) {
            throw new IllegalValueException(MESSAGE_CONTACT_CONSTRAINTS);
        }
        this.value = trimmedContact;
    }
    
    /**
     * Returns true if a given string is a valid person address.
     */
    public static boolean isValidContact(String test) {
        return test.matches(ADDRESS_VALIDATION_REGEX);
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
}
