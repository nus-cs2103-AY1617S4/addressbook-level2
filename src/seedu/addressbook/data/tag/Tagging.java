package seedu.addressbook.data.tag;

import java.util.ArrayList;

import seedu.addressbook.data.person.Person;

/** Association class to support the following functionality:
 * When the AddressBook program exits, it should print out a list of all the tags added/deleted during that session.
 */

public class Tagging {
	private ArrayList<String> allTheTags = new ArrayList<>();
	private final String ADD_COMMAND = "add";
	private final String DELETE_COMMAND = "remove";
	
	// Record tags added/deleted during that session.
	public void trackTagging(String command, Person person, Tag tag) {
		if (command == ADD_COMMAND) {
			allTheTags.add("+ " + person.getName().toString() + " " + tag.toString());
		}
		else if (command == DELETE_COMMAND) {
			allTheTags.add("- " + person.getName().toString() + " " + tag.toString());
		}
	}
	
	// To print out a list of all the tags added/deleted during the session, when the AddressBook program exits.
	public String getAllTags(){
		StringBuilder allActions = new StringBuilder();
		for(String tag: allTheTags){
			allActions.append(tag + "\n");
		}
		return allActions.toString();
	}
	
}
