package seedu.addressbook.data.person;

import java.util.Comparator;

/**
 * Compares two Persons based on the first alphabet in their name.
 */
public class PersonNameComparator implements Comparator<ReadOnlyPerson> {
    public int compare(ReadOnlyPerson one, ReadOnlyPerson two){
        return one.getName().toString().compareTo(two.getName().toString());
    }
}
