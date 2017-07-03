package seedu.addressbook.data.tag;

import seedu.addressbook.data.person.Person;
import seedu.addressbook.data.person.ReadOnlyPerson;

/**
 * Association class representing an addition/deletion of Tags for the person
 * @author shuqi
 *
 */
public class Tagging {
	private Tag tag;
	private String action;
	private ReadOnlyPerson person;
	private String personName;
	
	public Tagging(Tag tag, String action, ReadOnlyPerson person2) {
		this.tag = tag;
		this.action = action;
		this.person = person2;
		this.personName = this.person.getName().fullName;
	}
	
	public ReadOnlyPerson getPerson() {
		return this.person;
	}
	
	// get Name of person that Tags was added/deleted
	public String getPersonName() {
		return personName;
	}
	
	public String toString() {
		return action +" "+personName+" "+tag.toString();
	}

}
