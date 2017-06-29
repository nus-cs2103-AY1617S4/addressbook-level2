package seedu.addressbook.data.person;


/** Parent class for sub-classes Address,Email, Phone *
*/

public abstract class Contact {
    
    public String value;
    protected boolean isPrivate;
    
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
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
