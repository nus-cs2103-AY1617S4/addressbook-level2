package seedu.addressbook.data.tag;

import seedu.addressbook.data.person.Person;

import java.util.ArrayList;

/*
 * Association class to support the functionality:
 * When AddressBook exits, print out a list of all tags added/deleted during the session.
 */
public class Tagging {
    private final ArrayList<String> sessionTaggings = new ArrayList<>();
    
    private final String COMMAND_ADD = "add";
    private final String COMMAND_DELETE = "delete";
    private final String PREPEND_ADD = "+";
    private final String PREPEND_DELETE = "-";

    // creates and records taggings created/deleted during the session.
    public void recordTagging(String command, Person person, Tag tag) {
        String recordTagging = "";
        if (command == COMMAND_ADD) {
            recordTagging = PREPEND_ADD + " " + person.getName().toString() + " [" + tag.toString() + "]";
        } else if (command == COMMAND_DELETE) {
            recordTagging = PREPEND_DELETE + " " + person.getName().toString() + " [" + tag.toString() + "]";
        }
        sessionTaggings.add(recordTagging);
    }

    // prints out a list of all of the taggings done during the session.
    public String printAllSessionTaggings() {
        final StringBuilder builder = new StringBuilder();
        for (String sessionTagging : sessionTaggings){
            builder.append(sessionTagging + "\n");
        }
        return builder.toString();
    }

}
