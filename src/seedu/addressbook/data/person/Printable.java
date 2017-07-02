package seedu.addressbook.data.person;

import java.util.StringJoiner;

/**
 * Interface for objects printable in the form of Strings.
 */
public interface Printable {
	/**
	 * Returns a printable string of a printable object.
	 */
	public abstract String getPrintableString();
	
	/**
	  * Returns a concatenated version of the printable strings of each object.
	  */
	public static String getPrintableString(Printable... printables){
		StringJoiner concatenatedStrings = new StringJoiner(" ");
		
		for (Printable printable: printables){
			concatenatedStrings = concatenatedStrings.add(printable.getPrintableString());
		}
		return concatenatedStrings.toString();
	}
}
