package seedu.addressbook.data.tag;

import java.util.ArrayList;

/*
 * Association class;
 * To print out all additions and removal of tags when the programme exits
 */

public class Tagging {

    private ArrayList<String> allTagOpRecords = new ArrayList<>();
    private final String ADD = "add";
    private final String REMOVE = "remove";
    
    public void updateTagOpRecord(String command, String name, String tag) {
        if (command.equals(ADD))
            allTagOpRecords.add(" + " + name + " [" + tag + "]");
        else if (command.equals(REMOVE))
            allTagOpRecords.add(" - " + name + " [" + tag + "]");
    }
    
    /*
     * convert TagOpRecords to printable String and return it for printing. 
     */
    public String outputTagRecords() {
        StringBuilder TagRecords = new StringBuilder();
        for (String tag: allTagOpRecords) {
            TagRecords.append(tag + "\n");
        }
        return TagRecords.toString();
    }
}
