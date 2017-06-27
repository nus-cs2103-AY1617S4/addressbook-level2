package seedu.addressbook.data.person;

public class Unit {
    private String _value;
    
    protected Unit(String value){
        this._value = value;
    }
    
    public String getValue(){
        return _value;
    }
}
