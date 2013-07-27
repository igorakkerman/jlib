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

import javax.annotation.Nullable;

public class ForwardingEqualsHashCodeStrategy<Obj>
implements EqualsHashCodeStrategy<Obj> {

    private final EqualsStrategy<Obj> equalsStrategy;

    private final HashCodeStrategy<Obj> hashCodeStrategy;

    public ForwardingEqualsHashCodeStrategy(final EqualsStrategy<Obj> equalsStrategy,
                                            final HashCodeStrategy<Obj> hashCodeStrategy) {
        this.equalsStrategy = equalsStrategy;
        this.hashCodeStrategy = hashCodeStrategy;
    }

    @Override
    public boolean equals(final Obj thisObject, @Nullable final Object otherObject) {
        return equalsStrategy.equals(thisObject, otherObject);
    }

    @Override
    public int getHashCode(final Object thisObject) {
        return hashCodeStrategy.getHashCode(thisObject);
    }
}
