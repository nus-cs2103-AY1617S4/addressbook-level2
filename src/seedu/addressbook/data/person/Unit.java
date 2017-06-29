package seedu.addressbook.data.person;

public class Unit {
    private String unitNumber;
    
    public Unit(String unitNumber) {
        this.unitNumber = unitNumber;
    }
    
    public String getUnitNumber() {
        return unitNumber;
    }
    
    public void changeunitNumber(String newUnitNumber) {
        this.unitNumber = newUnitNumber;
    }
    
    @Override
    public String toString() {
        return unitNumber;
    }
}
