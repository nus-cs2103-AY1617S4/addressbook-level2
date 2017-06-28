package seedu.addressbook.data.person;

import java.util.Comparator;

public class NameComparator implements Comparator<Person> {
	public int compare(Person firstPerson, Person secondPerson) {
		return firstPerson.compareName(secondPerson);
	}

	public boolean equals(Person firstPerson, Person secondPerson) {
		return firstPerson.getName().equals(secondPerson.getName());
	}

}
