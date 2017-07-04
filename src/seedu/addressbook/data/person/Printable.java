package seedu.addressbook.data.person;

public interface Printable {
	
	public abstract String getPrintableString();
	
    public static String getPrintableString(Printable...printables) {
        StringBuilder printableString = new StringBuilder();
        for (Printable object : printables) {
            printableString.append(object.getPrintableString());
        }
        
        return printableString.toString();
    }

}


