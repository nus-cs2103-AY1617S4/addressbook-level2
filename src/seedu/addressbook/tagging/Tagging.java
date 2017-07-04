package seedu.addressbook.tagging;

import seedu.addressbook.data.person.Person;
import seedu.addressbook.data.tag.Tag;

public class Tagging {
    
    private String commandType;
    private Person person;
    private Tag tag;
    
    public Tagging(String cmd, Person person, Tag tag) {
        commandType = cmd;
        this.person = person;
        this.tag = tag;
    }

    @Override
    public String toString() {
        return commandType + " " + person.getName() + "[ " + tag.tagName + " ]";
    }
}
