package seedu.addressbook.data.person;

public interface Printable {

    public String getPrintableString();
    
    default public String getPrintableString(Printable...printables) {
        StringBuilder printableString = new StringBuilder();
        for (Printable object : printables) {
            printableString.append(object.getPrintableString());
        }
        
        return printableString.toString();
    }
}
