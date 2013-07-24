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

package org.jlib.container;

final class DisabledRemoveAll<Item>
extends DisabledContainer<Item>
implements RemoveAll<Item> {

    /** sole {@link DisabledRemoveAll} instance */
    private static final RemoveAll<?> INSTANCE = new DisabledRemoveAll<>();

    /**
     * Returns the sole {@link DisabledRemoveAll} instance.
     *
     * @return sole {@link DisabledRemoveAll} instance
     */
    @SuppressWarnings("unchecked")
    public static <Item> DisabledRemoveAll<Item> getInstance() {
        return (DisabledRemoveAll<Item>) INSTANCE;
    }

    /**
     * Creates a new {@link DisabledRemoveAll}.
     */
    private DisabledRemoveAll() {
        super();
    }


    @Override
    public void removeAll()
    throws ForbiddenCastException {
        throw new ForbiddenCastException(this);
    }
}
