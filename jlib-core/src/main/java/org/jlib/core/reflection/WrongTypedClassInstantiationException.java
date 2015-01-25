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

package org.jlib.core.reflection;

import org.jlib.core.message.Message;

public class WrongTypedClassInstantiationException
extends ClassInstantiationException {

    private static final long serialVersionUID = - 8364015911134861790L;

    private final Class<?> expectedParentClass;

    public WrongTypedClassInstantiationException(final Class<?> clazz, final Class<?> expectedParentClass) {
        super(clazz);

        this.expectedParentClass = expectedParentClass;
    }

    public Class<?> getExpectedParentClass() {
        return expectedParentClass;
    }

    @Override
    protected Message buildMessage() {
        return super.buildMessage().with("expectedParentClass", expectedParentClass);
    }
}
