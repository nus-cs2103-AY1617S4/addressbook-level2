package seedu.addressbook.data.person;

// A read-only immutable interface to get a printable string representing a bunch of person details.

public interface Printable {
	public String getPrintableString(); 
	
    // Returns a concatenated version of the printable strings of each object.
    default public String getPrintableString(Printable... printables){
    	final StringBuilder printableString = new StringBuilder();
    	for(Printable printable:printables){
    		printableString.append(printable.getPrintableString());
    	}
    	return printableString.toString();
    }
}
