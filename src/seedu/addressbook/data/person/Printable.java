package seedu.addressbook.data.person;


public interface Printable {
    
    String getPrintableString();
    
    default String getPrintableString(Printable... printables){
        StringBuilder builder = new StringBuilder();
        for(Printable printable : printables){
            builder.append(" ");
            builder.append(printable.getPrintableString());
        }
        return builder.toString();
        
    }
        
}
