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

package org.jlib.core.language;

import org.checkerframework.checker.nullness.qual.Nullable;

import org.jlib.core.operation.Equals;
import org.jlib.core.operation.EqualsHashCode;
import org.jlib.core.operation.HashCode;

public class ForwardingEqualsHashCode<Obj>
implements EqualsHashCode<Obj> {

    private final Equals<Obj> equals;

    private final HashCode<Obj> hashCodeStrategy;

    public ForwardingEqualsHashCode(final Equals<Obj> equals, final HashCode<Obj> hashCodeStrategy) {
        this.equals = equals;
        this.hashCodeStrategy = hashCodeStrategy;
    }

    @Override
    public boolean areEqual(final Obj first, @Nullable final Object second) {
        return equals.areEqual(first, second);
    }

    @Override
    public int hashCode(final Obj object) {
        return hashCodeStrategy.hashCode(object);
    }
}
