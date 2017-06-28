package seedu.addressbook.data.person;

public class Street {

	private String streetNumber;
	
	public Street(String streetNum) {
		streetNumber = streetNum;
	}
	
	public String getStreetNumber() {
		return streetNumber;
	}
	
    @Override
    public String toString() {
        return getStreetNumber();
    }
    
    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Street // instanceof handles nulls
                && streetNumber.equals(((Street) other).getStreetNumber())); // state check
    }
    
    @Override
    public int hashCode() {
    	return streetNumber.hashCode();
    }
    
}
