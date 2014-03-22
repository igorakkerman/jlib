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

/**
 * <p>
 * {@link Cloneable} of which the {@link #clone()} method has the return type of the implementing class.
 * </p>
 * <p>
 * Implementing this interface makes cloning easier in the following ways:
 * </p>
 * <ul>
 *     <li>
 *         It is ensured that the own type of the implemented class, if specified as type parameter, is returned.
 *     </li>
 *     <li>
 *         It is ensured that the {@link #clone()} method is public.
 *     </li>
 *     <li>
 *         Implementing classes do not need to catch {@link CloneNotSupportedException} if referring to the default
 *         implementation of this interface. The class {@code MyClass} can implement {@code TypedCloneable<Self>} and
 *         instead of
 * <pre>{@code
 * try {
 *     final MyClass clonedInstance = (MyClass) super.clone();
 * }
 * catch(CloneNotSupportedException exception) {
 *     throw new UnexpectedStateException(exception);
 * }}</pre>
 *          simply call
 * <pre>{@code MyClass clonedInstance = TypedCloneable.super.clone();}</pre>
 *      </li>
 * </ul>
 * using  a call to its {@link #clone()} method instead of
 *
 * @param <Self>
 *        own type of the implementing class
 *
 * @author Igor Akkerman
 */
public interface TypedCloneable<Self extends TypedCloneable<? extends Self>>
extends MyCloneable<Self> {

    @SuppressWarnings("unchecked")
    default public Self clone() {
        return null;
//        try {
//            return (Self) myclone();
//        }
//        catch (final CloneNotSupportedException exception) {
//            throw new UnexpectedStateException(exception);
//        }
    }
}
