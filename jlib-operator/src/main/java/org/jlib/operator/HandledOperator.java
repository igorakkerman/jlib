/*
 * jlib - Open Source Java Library
 *
 *     www.jlib.org
 *
 *
 *     Copyright 2005-2015 Igor Akkerman
 *
 *     Licensed under the Apache License, Version 2.0 (the "License");
 *     you may not use this file except in compliance with the License.
 *     You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 *     Unless required by applicable law or agreed to in writing, software
 *     distributed under the License is distributed on an "AS IS" BASIS,
 *     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *     See the License for the specific language governing permissions and
 *     limitations under the License.
 */

package org.jlib.operator;

/**
<<<<<<< HEAD
 * Performs the operation specified by the concrete implementation.
=======
 * Performs an operation specified by the concrete implementation.
>>>>>>> cabaecf59fdcd7e2645b812648df6b6261d832a1
 *
 * @author Igor Akkerman
 */
@FunctionalInterface
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
    @SuppressWarnings({ "ProhibitedExceptionDeclared", "RedundantThrows" })
    void operate()
    throws OperatorException, RuntimeException;
}
