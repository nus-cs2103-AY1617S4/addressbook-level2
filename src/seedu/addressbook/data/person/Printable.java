package seedu.addressbook.data.person;

/**
 * A read-only immutable interface for a Person Details in the addressbook.
 * Implementations should guarantee: details are present and not null, field values are validated.
 *
 */
public interface Printable {
	
	// Label stating what detail is this detail (e.g. Phone: )
	public static String LABEL = "";
	
	// Returns the detail with the labelS
	String getPrintableString();

}
