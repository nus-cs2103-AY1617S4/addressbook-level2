package seedu.addressbook.data.person;

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
		StringBuilder concatenatedStringBuilder = new StringBuilder();
		
		for (Printable printable: printables){
			concatenatedStringBuilder.append(printable.getPrintableString());
		}
		return concatenatedStringBuilder.toString();
	}
}
