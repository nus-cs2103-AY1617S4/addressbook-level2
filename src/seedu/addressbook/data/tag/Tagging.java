package seedu.addressbook.data.tag;

import seedu.addressbook.data.person.ReadOnlyPerson;

import java.util.ArrayList;

/*
 * Association class to support the functionality:
 * When AddressBook exits, print out a list of all tags added/deleted during the session.
 */
public class Tagging {
    private final ArrayList<String> sessionTaggings = new ArrayList<>();
    
    public static final String COMMAND_ADD = "add";
    public static final String COMMAND_DELETE = "delete";
    private final String PREPEND_ADD = "+";
    private final String PREPEND_DELETE = "-";

    //overloading method
    public void recordTagging(String command,ReadOnlyPerson toRemove){
        UniqueTagList tagList = toRemove.getTags();
        for(Tag tag : tagList){
            recordTagging(command,toRemove,tag);
        }
    }
    
    // creates and records taggings created/deleted during the session.
    public void recordTagging(String command, ReadOnlyPerson person,Tag tag) {
        String recordTagging = "";
        if (command == COMMAND_ADD) {
            recordTagging = PREPEND_ADD + " " + person.getName().toString() + tag.toString();
        } else if (command == COMMAND_DELETE) {
            recordTagging = PREPEND_DELETE + " " + person.getName().toString() + tag.toString();
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
