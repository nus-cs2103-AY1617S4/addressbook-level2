package seedu.addressbook.data.person;

/**
 * Represents the unit component in an address.
 */
public class Unit {
    private String _value;
    
    protected Unit(String value){
        this._value = value;
    }
    
    public String getValue(){
        return _value;
    }
}
