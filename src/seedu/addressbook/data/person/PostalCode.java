package seedu.addressbook.data.person;

public class PostalCode {
    private String postalCode;
    
    public PostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
    
    public String getPostalCode() {
        return postalCode;
    }
    
    public void changePostalCode(String newPostalCode) {
        this.postalCode = newPostalCode;
    }
    
    @Override
    public String toString() {
        return postalCode;
    }
}
