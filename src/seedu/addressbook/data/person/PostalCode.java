package seedu.addressbook.data.person;

public class PostalCode{
	
	private String postalCodeNumber;
	
	public PostalCode(String postalCodeNum) {
		postalCodeNumber = postalCodeNum;
	}
	
	public String getPostalCodeNumber() {
		return postalCodeNumber;
	}
	
    @Override
    public String toString() {
        return getPostalCodeNumber();
    }
    
    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof PostalCode // instanceof handles nulls
                && postalCodeNumber.equals(((PostalCode) other).getPostalCodeNumber())); // state check
    }

    @Override
    public int hashCode() {
    	return postalCodeNumber.hashCode();
    }
    
}
