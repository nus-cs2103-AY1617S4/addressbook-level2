package seedu.addressbook.data.person;

import java.util.Comparator;

public class NameComparator implements Comparator<Person> {
	public int compare(Person firstPerson, Person secondPerson) {
		return firstPerson.getName().fullName.compareTo(secondPerson.getName().fullName);
	}

	public boolean equals(Person firstPerson, Person secondPerson) {
		return firstPerson.getName().equals(secondPerson.getName());
	}

}
