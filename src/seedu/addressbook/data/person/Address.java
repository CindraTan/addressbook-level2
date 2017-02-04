package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's address in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidAddress(String)}
 */
public class Address {

    public static final String EXAMPLE = "123, some street";
    public static final String MESSAGE_ADDRESS_CONSTRAINTS = "Person addresses can be in any format";
    public static final String ADDRESS_VALIDATION_REGEX = ".+";

    public final String value;
    private boolean isPrivate;
    
    public class Block {
    	private final String block;
    	
    	public Block (String val) {
    		block = val;
    	}

		private String getBlock() {
			return block;
		}	
    }
    
    public class Street {
    	private final String street;
    	
    	public Street (String val) {
    		street = val;
    	}

		private String getStreet() {
			return street;
		}
    }
    
    public class Unit {
    	private final String unit;
    	
    	public Unit (String val) {
    		unit = val;
    	}

		private String getUnit() {
			return unit;
		}
    }
    
    public class postalCode {
    	private final String postalcode;
    	
    	public postalCode (String val) {
    		postalcode = val;
    	}

		private String getpostalCode() {
			return postalcode;
		}
    }
    
    private Block block;
    private Street street;
    private Unit unit;
    private postalCode postalcode;
    
    /**
     * Validates given address.
     *
     * @throws IllegalValueException if given address string is invalid.
     */
    public Address(String address, boolean isPrivate) throws IllegalValueException {
        String trimmedAddress = address.trim();
        this.isPrivate = isPrivate;
        if (!isValidAddress(trimmedAddress)) {
            throw new IllegalValueException(MESSAGE_ADDRESS_CONSTRAINTS);
        }
        this.value = trimmedAddress;
        String [] parts = value.split(",");
        block = new Block(parts[0]);
        street = new Street(parts[1]);
        unit = new Unit(parts[2]);
        postalcode = new postalCode(parts[3]);
        
    }

    /**
     * Returns true if a given string is a valid person email.
     */
    public static boolean isValidAddress(String test) {
        return test.matches(ADDRESS_VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) return true;
    	if (other == null || !(other instanceof Address)) return false;
    	if (this.block.equals(((Address)other).block) &&
    			this.street.equals(((Address)other).street) &&
    			this.unit.equals(((Address)other).unit) &&
    			this.postalcode.equals(((Address)other).postalcode)) return true;
    	return false;
    	
    	/*	
    	return other == this // short circuit if same object
                || (other instanceof Address // instanceof handles nulls
                && this.value.equals(((Address) other).value)); // state check
        */
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }
}



