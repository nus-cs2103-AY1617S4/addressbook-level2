package seedu.addressbook.ui;

/**
 * Created by Herman on 28/6/2017.
 */
public class Formatter {
    static final String DIVIDER = "===================================================";
    
    /** A decorative prefix added to the beginning of lines printed by AddressBook */
    private static final String LINE_PREFIX = "|| ";
    
    public String getDivider(){
        return DIVIDER;
    }
    
    public String getLinePrefix(){
        return LINE_PREFIX;
    }
}
