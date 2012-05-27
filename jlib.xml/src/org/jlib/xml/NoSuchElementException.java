package org.jlib.xml;

/**
 * Exception thrown when an item specified by name or path does not exist.
 * 
 * @author Igor Akkerman
 *
 */
public class NoSuchItemException
extends Exception {

    // name or path of the item
    private String itemName;
    
    /**
     * Creates a new NoSuchItemException.
     *
     * @param itemName
     *        string specifying the name or path of the item
     */
    public NoSuchItemException(String itemName) {
        this.itemName = itemName;
    }
    
    /**
     * Returns a string representation of this NoSuchItemException.
     * 
     * @return string representation of this NoSuchItemException
     */
    public String toString() {
        return "NoSuchItemException[" + itemName + "]";
    }
}
