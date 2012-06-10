package org.jlib.core.valueholder;

import org.jlib.core.JlibException;

/**
 * {@link JlibException} thrown when a requested Value is not accessible.
 * 
 * @author Igor Akkerman
 */
public class ValueNotAccessibleException
extends JlibException {

    /**
     * Creates a new {@link ValueNotAccessibleException}.
     */
    public ValueNotAccessibleException() {
        super();
    }
}