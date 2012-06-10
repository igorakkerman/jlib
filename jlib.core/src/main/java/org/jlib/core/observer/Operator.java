package org.jlib.core.observer;

/**
 * Operator that can be observed.
 * 
 * @author Igor Akkerman
 */
public interface Operator {

    /**
     * Performes the operation.
     * 
     * @throws OperatorException
     *         if the operation cannot be completed normally and this should be
     *         handled consequently
     * 
     * @throws RuntimeException
     *         if the operation cannot be completed normally and this should
     *         <em>not</em> be handled consequently
     */
    public void operate()
    throws OperatorException, RuntimeException;
}
