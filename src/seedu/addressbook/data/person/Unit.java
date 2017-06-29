package seedu.addressbook.data.person;

public class Unit {

	private String unitNum;
	
	public Unit(String unitNum) {
		this.unitNum = unitNum;
	}
	
	public String getunitNum() {
		return unitNum;
	}
	
    public String toString() {
        return getunitNum();
    }
    
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Unit // instanceof handles nulls
                && unitNum.equals(((Unit) other).getunitNum())); // state check
    }
    
    public int hashCode() {
    	return unitNum.hashCode();
    }
    
}
