package seedu.addressbook.data.person;

public class Contact {

    public String value;
    protected boolean isPrivate;

    
    public boolean isPrivate(){
        return isPrivate; 
    }
    
    public int hasCode(){
        return value.hashCode();
    }
    
    public String toString(){
        return value;
    }
    
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Contact // instanceof handles nulls
                && this.value.equals(((Contact) other).value)); // state check
    }
}