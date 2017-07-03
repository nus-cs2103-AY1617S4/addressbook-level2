package seedu.addressbook.data.person;
//an interface that allows user to access data on a read-only, immutable basis
public interface Printable {
	public String getPrintableString();
	
	public static String getPrintableString(Printable...Printables){
		StringBuilder printableString = new StringBuilder();
		for(Printable printable: Printables){ 
			printableString.append(printable.getPrintableString());
		}
		return printableString.toString();
	}
}
