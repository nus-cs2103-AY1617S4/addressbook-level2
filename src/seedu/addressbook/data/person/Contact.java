package seedu.addressbook.data.person;

public class Contact {
    protected String value;
    private boolean isPrivate;
    
    public Contact(boolean isPrivate){
        this.isPrivate = isPrivate;
    }
    
    public void setValue(String value){
        this.value = value;
    }
    
    public String getValue(){
        return value;
    }
    
    public boolean isPrivate() {
        return isPrivate;
    }
    
    @Override
    public String toString() {
        return value;
    }


    @Override
    public int hashCode() {
        return value.hashCode();
    }

}
