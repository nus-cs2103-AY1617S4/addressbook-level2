package seedu.addressbook.data;


import java.util.ArrayList;

public class Tagging {
    ArrayList<String> tags;
    public static final String addTag = "addTag";
    public static final String delTag = "delTag";
    
    
    public Tagging(){
        tags = new ArrayList<String>();
    }
    
    public void updateTags(String command,String name, String tag){
        if(command.equals(addTag)){
            tags.add(" + " + name + "[" + tag + "]" );
        }
        else if(command.equals(delTag)){
            tags.add(" - " + name + "[" + tag + "]" );
            
        }
    }
    
    public String printTags(){
        String tagString = "";
        for(String tag : tags){
            tagString += ("tag" + "\n") ;
        }
    return tagString;
    }
    
    
}
