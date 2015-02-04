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

package org.jlib.core.classinstance;

import org.jlib.core.exception.ApplicationException;
import org.jlib.core.message.Message;

import static org.jlib.core.message.MessageUtility.message;

public abstract class ClassInstanceException
extends ApplicationException {

    private static final long serialVersionUID = - 5553582053593591383L;

    protected final String className;

    public ClassInstanceException(final String className) {
        this.className = className;
    }

    public ClassInstanceException(final Class<?> clazz) {
        this(clazz.getName());
    }

    public ClassInstanceException(final String className, final Exception cause) {
        this(className);

        initCause(cause);
    }

    public ClassInstanceException(final Class<?> clazz, final Exception cause) {
        this(clazz.getName(), cause);
    }

    public String getClassName() {
        return className;
    }

    @Override
    public String getMessage() {
        return buildMessage().toString();
    }

    protected Message buildMessage() {
        return message().with("className", className);
    }
}
