package seedu.addressbook.data.tag;

import java.util.ArrayList;

import seedu.addressbook.data.person.Person;

/**
 * Represents a list of Tagging.
 */
public class TaggingList {
	private ArrayList<Tagging> _taggingList = new ArrayList<Tagging>();

	public void add(Person person, Tag tag, boolean isAdd) {
		_taggingList.add(new Tagging(person, tag, isAdd));
	}

	public void list() {
		for (Tagging tagging : _taggingList) {
			System.out.println(tagging.toString());
		}
	}
}
