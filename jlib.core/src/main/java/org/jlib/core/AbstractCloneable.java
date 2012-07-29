package org.jlib.core;

/**
 * Skeletal implementation of a {@link Cloneable}.
 * 
 * @author Igor Akkerman
 */
public abstract class AbstractCloneable
implements Cloneable {

    @Override
    public AbstractCloneable clone() {
        try {
            return (AbstractCloneable) super.clone();
        }
        catch (final CloneNotSupportedException exception) {
            throw new UnexpectedStateException(exception);
        }
    }
}
