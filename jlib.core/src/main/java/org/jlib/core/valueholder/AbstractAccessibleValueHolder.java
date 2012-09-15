package org.jlib.core.valueholder;

/**
 * Skeletal implementation of an {@link AccessibleValueHolder}.
 * 
 * @param <Value>
 *        type of the value
 * 
 * @author Igor Akkerman
 */
public abstract class AbstractAccessibleValueHolder<Value>
implements AccessibleValueHolder<Value> {

    @Override
    public String toString() {
        return getValue().toString();
    }

    @Override
    public boolean equals(final Object otherObject) {
        if (getClass().equals(otherObject.getClass()))
            return false;

        final InitializedValueHolder<?> otherInitializedValueHolder = (InitializedValueHolder<?>) otherObject;

        return getValue().equals(otherInitializedValueHolder.getValue());
    }

    @Override
    public int hashCode() {
        // TODO: use Apache Commons HashCodeBuilder
        return getValue().hashCode() * 2;
    }
}
