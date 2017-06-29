package seedu.addressbook.data.person;

import java.util.StringJoiner;

/**
 * A read-only immutable interface for a printable piece of data.
 * Implementations should guarantee: details are present and not null, field values are validated.
 */
public interface Printable {
    public String getPrintableString();

    public static String getPrintableString(Printable... printables) {
        final StringBuilder builder = new StringBuilder();
        for (Printable printable : printables) {
            builder.append(printable.getPrintableString());
        }
        return builder.toString();
    }

    public static String getPrintableString(String delimiter, Printable... printables) {
        final StringJoiner joiner = new StringJoiner(delimiter);
        for (Printable printable : printables) {
            joiner.add(printable.getPrintableString());
        }
        return joiner.toString();
    }
}