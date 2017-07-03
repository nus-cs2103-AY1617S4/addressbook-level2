package seedu.addressbook.data.person;

/**
 * Interface to get printable String
 *
 */
public interface Printable {

    public String getPrintableString();

    /**
     * Returns a concatenated version of the printable strings of each object.
     */
    public static String getPrintableString(Printable... printables) {
        StringBuilder personString = new StringBuilder(1000);
        for (Printable printable : printables) {
            personString.append(printable.getPrintableString()+" ");
        }
        return personString.toString();
    }

}