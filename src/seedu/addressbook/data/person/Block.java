package seedu.addressbook.data.person;

/**
 * Represents the block component in an address.
 */
public class Block {
    private String _value;
    
    public Block(String value){
        this._value = value;
    }
    
    public String getValue(){
        return _value;
    }
}
