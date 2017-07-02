package seedu.addressbook.data.tag;

import java.util.ArrayList;

import seedu.addressbook.data.person.Person;

/** Association class to support the following functionality:
 * When the AddressBook program exits, it should print out a list of all the tags added/deleted during that session.
 */

public class Tagging {
	private ArrayList<String> ALL_TAGS = new ArrayList<>();
	private final String ADD_COMMAND = "add";
	private final String DELETE_COMMAND = "delete";
	
	// Record tags added/deleted during that session.
	public void recordTagging(String command, Person person, Tag tag) {
		if (command == ADD_COMMAND) {
			ALL_TAGS.add("+ " + person.getName().toString() + " " + tag.toString());
		}
		else if (command == DELETE_COMMAND) {
			ALL_TAGS.add("- " + person.getName().toString() + " " + tag.toString());
		}
	}
	
	// To print out a list of all the tags added/deleted during the session, when the AddressBook program exits.
	public String getAllTags(){
		StringBuilder allTags = new StringBuilder();
		for(String tag: ALL_TAGS){
			allTags.append(tag + "\n");
		}
		return allTags.toString();
	}
	
}
