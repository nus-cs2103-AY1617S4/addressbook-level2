package seedu.addressbook.data.tag;

import seedu.addressbook.data.person.Person;

/**
 * Represents an association or dissociation of a Person and a Tag object.
 */
public class Tagging {
	private final Person _person;
	private final Tag _tag;

	/**
	 * _isAdd is true if a tag is added to a person, and false if a tag is
	 * deleted.
	 */
	private boolean _isAdd;

	public Tagging(Person person, Tag tag, boolean isAdd) {
		_person = person;
		_tag = tag;
		_isAdd = isAdd;
	}

	public boolean isAdd() {
		return _isAdd;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();

		if (isAdd()) {
			builder.append("+ ");
		} else {
			builder.append("- ");
		}

		builder.append(_person.getName() + " " + _tag.toString());
		return builder.toString();
	}
}
