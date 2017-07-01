/**
 * 
 */
package seedu.addressbook.data.person;

/**
 * A read-only interface used to get a printable String from Address,Email,Name,Phone data of a Person.
 */
public interface Printable {

        public String getPrintableString(); 
        
        public static String getPrintableString(Printable ...printables){
            final StringBuilder builder = new StringBuilder();
            for(Printable printable:printables){
                builder.append(printable.getPrintableString());
            }
            return builder.toString();
        }
}
