package seedu.addressbook.data.tag;

import java.util.ArrayList;

public class Tagging {
	private ArrayList<String> addTag = new ArrayList<String>();
	private ArrayList<String> deleteTag = new ArrayList<String>();
	
	public ArrayList<String> getAddTag(){
		return addTag;
	}
	
	public ArrayList<String> getDeleteTag(){
		return deleteTag;
	}
	
	public void addTag(String string){
		addTag.add(string);
	}
	
	public void deleteTag(String string){
		deleteTag.add(string);
	}
	
}
