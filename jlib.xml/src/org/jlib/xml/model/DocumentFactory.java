package org.jlib.xml;

/**
 * Factory for XML docuemnts.
 * 
 * @author Igor Akkerman
 */
public interface DocumentFactory {
    /**
     * Creates a new document.
     */
    public Document createDocument();
    
    /**
     * Creates a new document with the specified root element.
     * 
     * @param rootElement
     *        root element of the new document
     */
    public Document createDocument(Element rootElement);
}
