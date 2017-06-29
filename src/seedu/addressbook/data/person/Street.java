package seedu.addressbook.data.person;

public class Street {

	private String streetNum;
	
	public Street(String streetNum) {
		this.streetNum = streetNum;
	}
	
	public String getstreetNum() {
		return streetNum;
	}
	
    public String toString() {
        return getstreetNum();
    }
    
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Street // instanceof handles nulls
                && streetNum.equals(((Street) other).getstreetNum())); // state check
    }
    
    public int hashCode() {
    	return streetNum.hashCode();
    }
    
}
