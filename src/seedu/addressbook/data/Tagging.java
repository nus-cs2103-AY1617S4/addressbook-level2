package seedu.addressbook.data;

import java.util.ArrayList;
import java.util.List;
import java.lang.StringBuilder;

import seedu.addressbook.data.person.Person;
import seedu.addressbook.data.tag.Tag;

/**
 * Associates between Person and Tag, keeping a history of all Tags added/deleted.
 */
public class Tagging {
    private static final boolean ADD = true;

    private final Person person;
    private final Tag tag;
    private final boolean isAdd;

    /**
     * Constructor to ensure no fields are left uninitialised
     */
    public Tagging(Person person, Tag tag, boolean isAdd) {
        this.person = person;
        this.tag = tag;
        this.isAdd = isAdd;
    }

    /**
     * Formats the tag history entry as a single string for printing
     */
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append(isAdd ? "+" : "-");
        builder.append(" ");
        builder.append(person.getName().toString());
        builder.append(" ");
        builder.append("[");
        builder.append(tag.tagName);
        builder.append("]");
        return builder.toString();
    }

}
