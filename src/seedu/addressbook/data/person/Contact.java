package seedu.addressbook.data.person;

public class Contact {
    
    /**
     * Stores any contact-related information, such as a phone number,
     * email address, postal address, etc.
     */
    protected String value;
    
    private boolean isPrivate;
    
    public Contact(boolean isPrivate){
        this.isPrivate = isPrivate;
    }
    
    public String getValue(){
        return value;
    }
    
    @Override
    public String toString() {
        return value;
    }
    
    @Override
    public int hashCode() {
        return value.hashCode();
    }
    
    public boolean isPrivate() {
        return isPrivate;
    }
}
