package org.jlib.xml;

/**
 * Exception thrown when an attribute specified by name or path does not exist.
 * 
 * @author Igor Akkerman
 *
 */
public class NoSuchAttributeException
extends Exception {

    // name or path of the Attribute
    private String attributeName;
    
    /**
     * Creates a new NoSuchAttributeException.
     *
     * @param attributeName
     *        string specifying the name or path of the Attribute
     */
    public NoSuchAttributeException(String attributeName) {
        this.attributeName = attributeName;
    }
    
    /**
     * Returns a string representation of this NoSuchAttributeException.
     * 
     * @return string representation of this NoSuchAttributeException
     */
    public String toString() {
        return "NoSuchAttributeException[" + attributeName + "]";
    }
}
