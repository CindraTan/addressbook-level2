package seedu.addressbook.data.person;
import seedu.addressbook.data.exception.IllegalValueException;

public class Contact {
    public String value;
    private boolean isPrivate;
    
    public Contact (String val, boolean isPriv, String constraints, String validation) throws IllegalValueException {
    	this.isPrivate = isPriv;
    	String trimmedContact = val.trim();
    	if (!isValidContact (trimmedContact, validation)) {
    		throw new IllegalValueException(constraints);
    	}
    	this.value = trimmedContact;
    }
    
    public boolean isValidContact (String test, String validation) {
    	return test.matches(validation);
    }
    
    @Override
    public String toString() {
    	return value;
    }
    
    @Override
    public boolean equals (Object other) {
    	return other == this 
    			|| (other instanceof Contact
    			&& this.value.equals(((Contact)other).value));	
    }
    
    @Override
    public int hashCode() {
    	 return value.hashCode();
    }
   
    public boolean isPrivate() {
    	return isPrivate;
    }

}
