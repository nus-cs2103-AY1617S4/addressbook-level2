package seedu.addressbook.data.tag;

import seedu.addressbook.data.person.Person;

/**
 * Association class to display all added/deleted tags of a person
 *
 */
public class Tagging {

    private boolean isStatusAdd;
    private Person person;
    private Tag tag;

    public Tagging(boolean isStatusAdd) {
        this.isStatusAdd = isStatusAdd;
    }

    /**
     * Method to get all Tags added/deleted in a String form.
     */
    public String getAllTags() {
        StringBuilder tagToString = new StringBuilder(1000);
        if (isStatusAdd == true) {
            tagToString.append("+" + tag);
        } else {
            tagToString.append("-" + tag);
        }
        return tagToString.toString();
    }
}
