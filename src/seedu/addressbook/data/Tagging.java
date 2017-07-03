package seedu.addressbook.data;
import java.util.ArrayList;

public class Tagging {
	 	private ArrayList<String> allTaggingList;
	 	private static final String ADD_COMMAND = "add";
	 	private static final String DELETE_COMMAND = "delete";
	 	
	 	public void recordTagging(String command, String personName, String tagName){
	 		if(command.equals(ADD_COMMAND)){
	 			allTaggingList.add("+ " + personName + tagName);
	 		} else if(command.equals(DELETE_COMMAND)){
	 			allTaggingList.add("- " + personName + tagName);
	 		}
	 	}
	 	
	 	public String getTaggings(){
	 		String tagString = "";
	 		for(String tagName : allTaggingList){
	 		     tagString += ("tag" + "\n") ;
	 		}
	 		return tagString;
	 	}
}
	 	
