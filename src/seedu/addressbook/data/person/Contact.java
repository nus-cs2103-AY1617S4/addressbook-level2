package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's contact in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidContact(String)}
 */
public class Contact {
    public static String example;
    public static String messageContactConstraints;
    public static String addressValidationRegex;

    public final String value;
    private boolean isPrivate;

    /**
     * Validates given Contact.
     *
     * @throws IllegalValueException if given contact string is invalid.
     */
    public Contact(String contact, boolean isPrivate, String example, String message, String regex) throws IllegalValueException {
        Contact.example = example;
        Contact.messageContactConstraints = message;
        Contact.addressValidationRegex = regex;
        this.isPrivate = isPrivate;
        String trimmedContact = contact.trim();
        if (!isValidContact(trimmedContact)) {
            throw new IllegalValueException(messageContactConstraints);
        }
        this.value = trimmedContact;
    }
    
    /**
     * Returns true if a given string is a valid person contact.
     */
    public static boolean isValidContact(String test) {
        return test.matches(addressValidationRegex);
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
