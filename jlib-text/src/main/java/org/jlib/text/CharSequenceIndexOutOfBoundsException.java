package org.jlib.text;

import org.jlib.core.message.Message;

/**
 * Exception thrown when a {@link CharSequence} character index is out of bounds.
 *
 * @author Igor Akkerman
 */
public abstract class CharSequenceIndexOutOfBoundsException
extends IndexOutOfBoundsException {

    private static final long serialVersionUID = -4883064375950444974L;

    protected static String CS_FORMAT = "['%s']";

    public CharSequenceIndexOutOfBoundsException(final Message message)  {
        super(message.toString());
    }
}
