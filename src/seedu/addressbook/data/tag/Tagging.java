package seedu.addressbook.data.tag;

import java.util.ArrayList;

import seedu.addressbook.data.person.Person;

// Association class to that prints out list of all the tags added/deleted during the session


public class Tagging {
	private ArrayList<String> allTheTags = new ArrayList<>();
	private final String ADD_COMMAND = "add";
	private final String DELETE_COMMAND = "remove";
	
	// Record tags added/deleted during that session.
	public void trackTagging(String command, Person person, Tag tag) {
		if (command.equals(ADD_COMMAND)) {
			allTheTags.add("+ " + person.getName().toString() + " " + tag.toString());
		}
		else if (command.equals(DELETE_COMMAND)) {
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
