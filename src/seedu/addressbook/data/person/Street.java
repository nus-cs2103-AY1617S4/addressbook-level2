package seedu.addressbook.data.person;
/**
 * Represents the Street of a Person in the address book.
 * Guarantees: details are present and not null, field values are validated.
 */
public class Street {
    private String street;
    
    public Street(){
        street = "";
    }
    
    public Street(String street){
        this.street = street;
    }
    
    public String getStreet(){
        return street;
    }
    
}
