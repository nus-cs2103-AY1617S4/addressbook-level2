package seedu.addressbook.data.person;

/**
 * Represents a postal code.
 */
public class PostalCode {
    private String _value;
    
    protected PostalCode(String value){
        this._value = value;
    }
    
    public String getValue(){
        return _value;
    }
}
