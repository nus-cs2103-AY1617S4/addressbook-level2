package seedu.addressbook.data.person;

/**
 * Represents the street component in an address.
 */
public class Street {
    private String _value;
    
    public Street(String value){
        this._value = value;
    }
    
    public String getValue(){
        return _value;
    }
}
