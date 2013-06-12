/*******************************************************************************
 *
 *    jlib - Open Source Java Library
 *
 *    www.jlib.org
 *
 *
 *    Copyright 2012 Igor Akkerman
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 *
 ******************************************************************************/

package org.jlib.core.operator;

import org.jlib.core.JlibException;

/**
 * {@link JlibException} thrown during the operation of an operator.
 *
 * @author Igor Akkerman
 */
public class OperatorException
extends JlibException {

    /** serialVersionUID */
    private static final long serialVersionUID = - 9075612246404744163L;

    /** {@link RuntimeException} that caused this {@link OperatorException} */
    private final RuntimeException cause;

    /**
     * Creates a new {@link OperatorException}.
     *
     * @param messagePattern
     *        {@link String} specifying the message pattern; {1} references
     *        {@code value}
     *
     * @param cause
     *        {@link RuntimeException} that caused this
     *        {@link OperatorException}
     *
     * @param messageArguments
     *        comma separated sequence of {@link Object} message arguments
     */
    public OperatorException(final String messagePattern, final RuntimeException cause, final Object... messageArguments) {
        super(messagePattern, cause, messageArguments);

        this.cause = cause;
    }

    @Override
    public synchronized RuntimeException getCause() {
        return cause;
    }
}
