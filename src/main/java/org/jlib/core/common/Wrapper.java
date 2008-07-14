/*
 * jlib - The Free Java Library
 * 
 *    http://www.jlib.org
 *    
 * Copyright (c) 2006-2008 Igor Akkerman
 * 
 * jlib is distributed under the
 *
 *    COMMON PUBLIC LICENSE VERSION 1.0
 *
 *    http://www.opensource.org/licenses/cpl1.0.php
 */

package org.jlib.core.common;

/**
 * <p>
 * Wrapper of any kind of Objects allowing a quasi call-by-reference semantic.
 * </p>
 * <p>
 * For example, a method could be used to convert a specified wrapped String to lower case:
 * </p>
 * 
 * <pre>
 * {@literal
 * private static void toLowerCase(Wrapper<String> wrappedString)
 * throws NullPointerException {
 *     wrappedString.set(wrappedString.get().toLowerCase());
 * }}
 * </pre>
 * 
 * <p>
 * The modified String can then be unwrapped:
 * </p>
 * 
 * <pre>
 * {@literal
 * String big = "HelLO!";
 * Wrapper<String> wrapped = wrap(big);  // Wrapper.wrap by static import
 * toLowerCase(wrapped);
 * String small = wrapped.get();
 * System.out.println(big + " >= " + wrapped + " = " + small);}
 * </pre>
 * 
 * This code prints
 * 
 * <pre>
 * {@literal
 * HelLO! >= hello! = hello!}
 * </pre>
 * 
 * <p>
 * Note that the {@code toString()} method of this class returns the {@code toString()} result from
 * the wrapped Object.
 * </p>
 * 
 * @param <WrappedObject>
 *        type of the Object to wrap
 * @author Igor Akkerman
 */
public class Wrapper<WrappedObject> {

	/**
     * Creates a new Wrapper for the specified Object.
     * 
     * @param <WrappedObject>
     *        type of the Object to wrap
     * @param wrappedObject
     *        Object to wrap
     * @return Wrapper wrapping {@code wrappedObject}
     */
    public static <WrappedObject> Wrapper<WrappedObject> wrap(WrappedObject wrappedObject) {
        return new Wrapper<WrappedObject>(wrappedObject);
    }

    /** Object wrapped by this Wrapper */
    private WrappedObject wrappedObject;

    /**
     * Creates a new Wrapper of the specified Type.
     * 
     * @param wrappedObject
     *        Object wrapped by this Wrapper
     */
    private Wrapper(WrappedObject wrappedObject) {
        super();
        this.wrappedObject = wrappedObject;
    }

    /**
     * Returns the Object wrapped by this Wrapper.
     * 
     * @return wrapped Object
     */
    public final WrappedObject get() {
        return wrappedObject;
    }

    /**
     * Registers the Object wrapped by this Wrapper.
     * 
     * @param wrappedObject
     *        wrapped Object
     */
    public final void set(WrappedObject wrappedObject) {
        this.wrappedObject = wrappedObject;
    }

    /**
     * Returns whether the Object wrapped by the specified Wrapper is equal to the Object wrapped by
     * this wrapper.
     * 
     * @param otherObject
     *        other Wrapper
     * @return {@code true} if the object wrapped by the specified Wrapper is equal to the Object
     *         wrapped by this wrapper or if both wrapped Objects are {@code null}; {@code false}
     *         otherwise
     */
    @Override
    public boolean equals(Object otherObject) {
        if (!(otherObject instanceof Wrapper))
            return false;

        Object otherWrappedObject = ((Wrapper<?>) otherObject).get();

        return wrappedObject != null ? wrappedObject.equals(otherWrappedObject) : otherWrappedObject == null;
    }

    /**
     * Returns the String representation of the wrapped Object.
     * 
     * @return String representation of the wrapped Object
     */
    @Override
    public String toString() {
        return wrappedObject.toString();
    }
}
