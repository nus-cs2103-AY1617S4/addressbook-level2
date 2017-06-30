package seedu.addressbook.data.person;
/**
 * Represents the Postal Code of a Person in the address book.
 * Guarantees: details are present and not null, field values are validated.
 */
public class PostalCode {
    private String postalCode;
    
    public PostalCode(){
        postalCode = "";
    }
    
    public PostalCode(String postalCode){
        this.postalCode = postalCode;
    }
    
    public String getPostalCode(){
        return postalCode;
    }
    
}
