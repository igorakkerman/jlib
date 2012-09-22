package org.jlib.core.operator;


/**
 * Performs an operation specified by the concrete implementation.
 * 
 * @author Igor Akkerman
 */
public interface HandledOperator {

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
