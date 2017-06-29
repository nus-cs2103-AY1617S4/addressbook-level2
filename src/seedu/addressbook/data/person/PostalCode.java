package seedu.addressbook.data.person;

public class PostalCode{
	
	private String postalCodeNum;
	
	public PostalCode(String postalCodeNum) {
		this.postalCodeNum = postalCodeNum;
	}
	
	public String getpostalCodeNum() {
		return postalCodeNum;
	}

    public String toString() {
        return getpostalCodeNum();
    }

    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof PostalCode // instanceof handles nulls
                && postalCodeNum.equals(((PostalCode) other).getpostalCodeNum())); // state check
    }

    public int hashCode() {
    	return postalCodeNum.hashCode();
    }
    
}
