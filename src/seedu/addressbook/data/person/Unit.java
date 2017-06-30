package seedu.addressbook.data.person;
/**
 * Represents the Unit of a Person in the address book.
 * Guarantees: details are present and not null, field values are validated.
 */
public class Unit {
    private String unit;
    
    public Unit(){
        unit = "";
    }
    
    public Unit(String unit){
        this.unit = unit;
    }
    
    public String getUnit(){
        return unit;
    }
}
