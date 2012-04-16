package org.jlib.xml;

import java.util.List;

/**
 * XML element.
 * 
 * @author Igor Akkerman
 */
public interface Element extends Node {
    /**
     * Adds an element to this element.
     * 
     * @param element
     *        element to add
     */
    public void addElement(Element element);
    
    /**
     * Creates a new text element and adds it to this element.
     * 
     * @param elementName
     *        string specifying the name of the new child text element
     * @param text
     *        string specifying the text of the new child text element
     *        
     * @return the newly created and added text element
     */
    public Element addTextElement(String elementName, String elementText);
    
    /**
     * Returns the text of this element.
     * 
     * @return stirng specifying the text of this element
     */
    public String getText();
    
    /**
     * Returns the list of child elements of this element.
     * 
     * @return list of the child elements
     */
    public List<Element> getChildElements();
    
    /**
     * Returns the first child element of this element with the specified name.
     * 
     * @param childElementName
     *        string specifying the name of the child element
     *        
     * @return the first child element of this element with the specified name
     * 
     * @throws NoSuchElementException
     *         if this element does not have a child element with the specified name
     */
    public Element getChildElement(String elementName)
    throws NoSuchElementException;

    /**
     * Registers an attribute of this element with the specified name and value.
     * If this element already contains an attribute with the specified name,
     * it is replaced.
     * 
     * @param attributeName
     *        string specifying the name of the attribute
     * @param attributeValue
     *        string specifying the value of the attribute
     */
    public void setAttribute(String attributeName, String attributeValue);
    
    /**
     * Returns the value of the attribute of this element with the specified name.
     * 
     * @param attributeName
     *        string specifying the name of the attribute
     *        
     * @return string specifying the value of the attribute
     * 
     * @throws NoSuchAttributeException
     *         if this element does not have an attribute with the specified name
     */
    public String getAttribute(String attributeName)
    throws NoSuchAttributeException;
    
    /**
     * Returns the namespace of this element.
     * 
     * @return namespace of this element
     */
    public Namespace getNamespace();
    
    /**
     * Registers a new namespace for this element.
     * 
     * @param namespace
     *        new namespace for this element
     */
    public void setNamespace(Namespace namespace);
}
