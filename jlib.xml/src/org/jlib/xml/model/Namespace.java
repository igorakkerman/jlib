package org.jlib.xml;

/**
 * XML Namespace.
 * 
 * @author Igor Akkerman
 */
public interface Namespace {
    /**
     * Returns the prefix of this namespace.
     * 
     * @return string specifying the prefix
     */
    public String getPrefix();
    
    /**
     * Returns the URI of this namespace
     * 
     * @return string specifying the URI
     */
    public String getURI();
}
