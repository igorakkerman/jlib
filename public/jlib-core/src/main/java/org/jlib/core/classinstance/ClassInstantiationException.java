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

/**
 * {@link ClassInstanceException} thrown when a class cannot be instantiated. It may be used by factories as a wrapper
 * for any kind of Exceptions occurring when trying to instantiate a class.
 *
 * @author Igor Akkerman
 */
public class ClassInstantiationException
extends ClassInstanceException {

    private static final long serialVersionUID = 160064034539803335L;

    public ClassInstantiationException(final String className) {
        super(className);
    }

    public ClassInstantiationException(final Class<?> clazz) {
        super(clazz);
    }

    public ClassInstantiationException(final String className, final Exception cause) {
        super(className, cause);
    }

    public ClassInstantiationException(final Class<?> clazz, final Exception cause) {
        super(clazz, cause);
    }
}
