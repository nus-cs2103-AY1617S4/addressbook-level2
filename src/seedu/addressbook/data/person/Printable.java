package seedu.addressbook.data.person;

public interface Printable {
    /**
     * A read-only immutable interface for a Person Details in the addressbook.
     * Implementations should guarantee: details are present and not null, field values are validated.
     
     */
    
    String getPrintableString();
}
