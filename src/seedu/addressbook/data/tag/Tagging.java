package seedu.addressbook.data.tag;

import java.util.ArrayList;

/*
 * Keeps track of tags being added or deleted
 * */
public class Tagging {
	private ArrayList<String> allTaggingList;
	private static final String ADD_COMMAND = "add";
	private static final String DELETE_COMMAND = "delete";
	
	/*
	 * Keeps track of tags being added or deleted.
	 * */
	public void recordTagging(String command, String personName, String tagName){
		if(command.equals(ADD_COMMAND)){
			allTaggingList.add("+ " + personName + tagName);
		} else if(command.equals(DELETE_COMMAND)){
			allTaggingList.add("- " + personName + tagName);
		}
	}
	
	/**
	 * @return String with all tags being added or deleted.
	 * */
	public String getAllTaggings(){
		StringBuilder allTagging = new StringBuilder();
		for(String tags : allTaggingList){
			allTagging.append(tags + "\n");
		}
		return allTagging.toString();
	}

}

