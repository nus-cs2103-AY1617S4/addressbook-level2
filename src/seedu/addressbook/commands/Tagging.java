package seedu.addressbook.commands;

import java.util.ArrayList;
import java.util.List;
import java.lang.StringBuilder;

import seedu.addressbook.data.person.Person;
import seedu.addressbook.data.tag.UniqueTagList;
import seedu.addressbook.data.tag.UniqueTagList.DuplicateTagException;
import seedu.addressbook.data.tag.Tag;

/**
 * Associates between Person and Tag, keeping a history of all Tags added/deleted.
 */
public class Tagging {

    private static final boolean ADD = true;

    private final Person person;
    private final Tag tag;
    private final boolean isAdd;

    private static final List<Tagging> taggings = new ArrayList<Tagging>();
    
    /**
     * Private constructor as this class should not be instantiated by the user.
     */
    private Tagging(Person person, Tag tag, boolean isAdd) {
        this.person = person;
        this.tag = tag;
        this.isAdd = isAdd;
    }

    /**
     * Private helper function to instantiate a tagging history entry
     * and add it to the taggings list
     */
    private static void addToTaggings(Person person, Tag tag, boolean isAdd) {
        final Tagging tagging = new Tagging(person, tag, isAdd);
        taggings.add(tagging);
    }

    /** 
     * Executes the command to add a tag to a person.
     *
     * @return whether the tag was successfully added.
     */
    public static boolean executeAddTag(Person person, Tag tag) {
        final UniqueTagList oldTagList = person.getTags();
        try {
            oldTagList.addAll(new UniqueTagList(tag));
            person.setTags(oldTagList);
            addToTaggings(person, tag, ADD);
            return true;
        } catch (DuplicateTagException exception) {
            return false;
        }
    }

    /** 
     * Executes the command to remove a tag from a person.
     *
     * @return whether the tag was successfully removed.
     */
    public static boolean executeRemoveTag(Person person, Tag tag) {
        final UniqueTagList oldTagList = person.getTags();
        if (oldTagList.remove(tag)) {
            person.setTags(oldTagList);
            addToTaggings(person, tag, !ADD);
            return true;
        } else {
            return false;
        }
    }

    public static List<Tagging> getTaggingsList() {
        return taggings;
    }

    /**
     * Alternative getter which returns taggings directly as strings
     */
    public static List<String> getTaggingsStringList() {
        final ArrayList<String> stringList = new ArrayList<String>();
        for (Tagging tagging : taggings) {
            stringList.add(tagging.getTagString());
        }
        return stringList;
    }

    /**
     * Helper function to format tag single history entry as a whole string
     */
    public String getTagString() {
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