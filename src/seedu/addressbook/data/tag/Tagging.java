package seedu.addressbook.data.tag;

import seedu.addressbook.data.person.Person;

public class Tagging {
	private String _action;
	private Person _person;
	
	public Tagging(String action, Person person) {
		_action = action;
		_person = person;
	}

	public String getAction() {
		return _action;
	}
	
	public Person getPerson() {
		return _person;
	}
}
