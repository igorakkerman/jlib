package org.jlib.xml;

/**
 * XML document.
 * 
 * @author Igor Akkerman
 */
public interface Document
extends Node {

    /**
     * Returns the root element of this document.
     * 
     * @return root element of this document
     */
    public Element getRootElement();

    /**
     * Registers a new root element for this document.
     * 
     * @param rootElement
     *        new root element of this document
     */
    public void setRootElement(Element rootElement);

    /**
     * Adds a namespace to this document.
     * 
     * @param namespace
     *        namespace to add to this document
     */
    public void addNamespace(Namespace namespace);

    /**
     * Adds a namespace to this document specified by its prefix and URI.
     * 
     * @param namespacePrefix
     *        string specifying the prefix of the namespace to add
     * @param namespaceURI
     *        string specifying the URI of the namespace to add
     */
    public void addNamespace(String namespacePrefix, String namespaceURI);

    /**
     * Sets the default namespace of this document to the namespace with the specified URI.
     * 
     * @param namespaceURI
     *        string specifying the URI of the new default namespace
     */
    public void setDefaultNamespace(String namespaceURI);
}
