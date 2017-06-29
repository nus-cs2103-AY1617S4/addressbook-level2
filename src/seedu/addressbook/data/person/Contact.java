package seedu.addressbook.data.person;

public abstract class Contact {
    public String value;
    protected boolean isPrivate;
    
    public String toString() {
        return value;
    }
    
    public int hashCode() {
        return value.hashCode();
    }
    
    public boolean isPrivate() {
        return isPrivate;
    }
}
