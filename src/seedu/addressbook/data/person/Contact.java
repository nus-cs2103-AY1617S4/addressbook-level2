package seedu.addressbook.data.person;

public class Contact {
	public final String value;
	private boolean isPrivate;
	
	public Contact(String value, boolean isPrivate){
		this.value = value.trim();
		this.isPrivate = isPrivate;
	}
		
	public String toString(){
		return value;
	}
	
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Contact // instanceof handles nulls
                && this.value.equals(((Contact) other).value)); // state check
    }

    public int hashCode() {
        return value.hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }
    
}

