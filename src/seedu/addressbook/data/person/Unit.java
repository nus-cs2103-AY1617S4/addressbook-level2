package seedu.addressbook.data.person;

public class Unit {

	private String unitNumber;
	
	public Unit(String unitNum) {
		unitNumber = unitNum;
	}
	
	public String getUnitNumber() {
		return unitNumber;
	}
	
    @Override
    public String toString() {
        return getUnitNumber();
    }
    
    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Unit // instanceof handles nulls
                && unitNumber.equals(((Unit) other).getUnitNumber())); // state check
    }
    
    @Override
    public int hashCode() {
    	return unitNumber.hashCode();
    }
    
}
