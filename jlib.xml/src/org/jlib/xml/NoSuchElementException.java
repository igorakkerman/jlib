package org.jlib.xml;

/**
 * Exception thrown when an element specified by name or path does not exist.
 * 
 * @author Igor Akkerman
 *
 */
public class NoSuchElementException
extends Exception {

    // name or path of the element
    private String elementName;
    
    /**
     * Creates a new NoSuchElementException.
     *
     * @param elementName
     *        string specifying the name or path of the element
     */
    public NoSuchElementException(String elementName) {
        this.elementName = elementName;
    }
    
    /**
     * Returns a string representation of this NoSuchElementException.
     * 
     * @return string representation of this NoSuchElementException
     */
    public String toString() {
        return "NoSuchElementException[" + elementName + "]";
    }
}
