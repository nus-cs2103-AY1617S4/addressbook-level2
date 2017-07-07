package seedu.addressbook.data.tag;

import seedu.addressbook.data.person.Person;

/**
 * Association class to display all added/deleted tags of a person
 *
 */
public class Tagging {

    private boolean status;
    private Person person;
    private Tag tag;

    public Tagging(boolean status) {
        this.status = status;
    }

    public String getAllTags() {
        StringBuilder tagToString = new StringBuilder(1000);
        if (status == true) {
            tagToString.append("+" + tag);
        } else {
            tagToString.append("-" + tag);
        }
        return tagToString.toString();
    }
}
