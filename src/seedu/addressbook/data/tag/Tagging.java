package seedu.addressbook.data.tag;

import java.util.ArrayList;
import java.util.List;

import seedu.addressbook.data.person.Person;

/**
 * 
 * @author Naren
 * Association class for keeping track of changes to tags
 */
public class Tagging {
	public static enum function {ADD, REMOVE};
	
	public static List<String> ALL_TAGGINGS = new ArrayList<>();
	
	public Tagging(function fn, Person person, Tag tag) {
		switch(fn){
		case ADD:
			ALL_TAGGINGS.add("+ " + person.getName().toString() + " " + tag.toString());
			break;
		case REMOVE:
			ALL_TAGGINGS.add("- " + person.getName().toString() + " " + tag.toString());
			break;
		}
	}
	
	public static String getAllTaggings(){
		StringBuilder allTaggings = new StringBuilder("");
		for(String tagging: ALL_TAGGINGS){
			allTaggings.append(tagging + "\n");
		}
		return allTaggings.toString();
	}

}
