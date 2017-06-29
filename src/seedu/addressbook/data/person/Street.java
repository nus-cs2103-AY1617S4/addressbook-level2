package seedu.addressbook.data.person;

public class Street {
    private String streetName;
    
    public Street(String streetName) {
        this.streetName = streetName;
    }
    
    public String getStreetName() {
        return streetName;
    }
    
    public void changeStreetName(String newStreetName) {
        this.streetName = newStreetName;
    }
    
    @Override
    public String toString() {
        return streetName;
    }
}
