package org.jlib.xml;

import java.util.List;

/**
 * XML item.
 * 
 * @author Igor Akkerman
 */
public interface Item extends Node {
    /**
     * Adds an item to this item.
     * 
     * @param item
     *        item to add
     */
    public void addItem(Item item);
    
    /**
     * Creates a new text item and adds it to this item.
     * 
     * @param itemName
     *        string specifying the name of the new child text item
     * @param text
     *        string specifying the text of the new child text item
     *        
     * @return the newly created and added text item
     */
    public Item addTextItem(String itemName, String itemText);
    
    /**
     * Returns the text of this item.
     * 
     * @return stirng specifying the text of this item
     */
    public String getText();
    
    /**
     * Returns the list of child items of this item.
     * 
     * @return list of the child items
     */
    public List<Item> getChildItems();
    
    /**
     * Returns the first child item of this item with the specified name.
     * 
     * @param childItemName
     *        string specifying the name of the child item
     *        
     * @return the first child item of this item with the specified name
     * 
     * @throws NoSuchItemException
     *         if this item does not have a child item with the specified name
     */
    public Item getChildItem(String itemName)
    throws NoSuchItemException;

    /**
     * Registers an attribute of this item with the specified name and value.
     * If this item already contains an attribute with the specified name,
     * it is replaced.
     * 
     * @param attributeName
     *        string specifying the name of the attribute
     * @param attributeValue
     *        string specifying the value of the attribute
     */
    public void setAttribute(String attributeName, String attributeValue);
    
    /**
     * Returns the value of the attribute of this item with the specified name.
     * 
     * @param attributeName
     *        string specifying the name of the attribute
     *        
     * @return string specifying the value of the attribute
     * 
     * @throws NoSuchAttributeException
     *         if this item does not have an attribute with the specified name
     */
    public String getAttribute(String attributeName)
    throws NoSuchAttributeException;
    
    /**
     * Returns the namespace of this item.
     * 
     * @return namespace of this item
     */
    public Namespace getNamespace();
    
    /**
     * Registers a new namespace for this item.
     * 
     * @param namespace
     *        new namespace for this item
     */
    public void setNamespace(Namespace namespace);
}
