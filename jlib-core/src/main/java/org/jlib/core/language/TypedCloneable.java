/*
 * jlib - Open Source Java Library
 *
 *     www.jlib.org
 *
 *
 *     Copyright 2005-2013 Igor Akkerman
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

package org.jlib.core.language;

import org.jlib.core.language.exception.UnexpectedStateException;

/**
 * <p>
 * {@link Cloneable} providing a public {@link #clone()} method with the return type of the extending class.
 * </p>
 * <p>
 * Extending this abstract class reduces boilerplate code in overridden {@link #clone()} methods:
 * </p>
 * <ul>
 *     <li>
 *         It is ensured that the own type of the implemented class is returned, if specified as type parameter.
 *     </li>
 *     <li>
 *         It is ensured that the {@link #clone()} method is public.
 *     </li>
 *     <li>
 *         Extending classes do not need to catch {@link CloneNotSupportedException} if referring to the default
 *         implementation of this interface.
 *         <p>
 *         Example:
 * <pre>{@code
 * class MyClass {
 *     public Object clone() {
 *         try {
 *             final MyClass clonedInstance = (MyClass) super.clone();
 *             ...
 *             return clonedInstance;
 *         }
 *         catch(CloneNotSupportedException exception) {
 *             throw new UnexpectedStateException(exception);
 *         }
 *     }
 * }}</pre>
 *
 * Extending {@link TypedCloneable}, the code can be reduced to:
 * <pre>{@code
 * class MyClass
 * extends TypedCloneable<MyClass> {
 *     public MyClass clone() {
 *         final MyClass clonedInstance = TypedCloneable.super.clone();
 *         ...
 *         return clonedInstance;
 *     }
 * }}</pre>
 *      </li>
 * </ul>
 *
 * @param <Self>
 *        own type of the extending class
 *
 * @author Igor Akkerman
 */
public abstract class TypedCloneable<Self extends TypedCloneable<? extends Self>>
implements Cloneable {

    @SuppressWarnings("unchecked")
    public Self clone() {
        try {
            return (Self) super.clone();
        }
        catch (final CloneNotSupportedException exception) {
            throw new UnexpectedStateException(exception);
        }
    }
}
