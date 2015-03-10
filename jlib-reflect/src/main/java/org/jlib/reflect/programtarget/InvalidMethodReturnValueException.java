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

package org.jlib.reflect.programtarget;

import java.lang.reflect.Executable;

import org.jlib.core.message.Message;

public class InvalidMethodReturnValueException
extends MethodInvocationException {

    private static final long serialVersionUID = - 3511658773401667177L;

    public InvalidMethodReturnValueException(final Message message, final Executable method) {
        super(message, method.getDeclaringClass().getName(), method.getName());
    }

    public InvalidMethodReturnValueException(final Message message, final Executable method, final Exception cause) {
        this(message, method);

        initCause(cause);
    }
}
