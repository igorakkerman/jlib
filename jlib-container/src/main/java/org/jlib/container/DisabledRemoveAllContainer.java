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

final class DisabledRemoveAllContainer<Item>
extends AbstractDisabledContainer<Item>
implements RemoveAllContainer<Item> {

    /** sole {@link DisabledRemoveAllContainer} instance */
    private static final RemoveAllContainer<?> INSTANCE = new DisabledRemoveAllContainer<>();

    /**
     * Returns the sole {@link DisabledRemoveAllContainer} instance.
     *
     * @return sole {@link DisabledRemoveAllContainer} instance
     */
    @SuppressWarnings("unchecked")
    public static <Item> DisabledRemoveAllContainer<Item> getInstance() {
        return (DisabledRemoveAllContainer<Item>) INSTANCE;
    }

    /**
     * Creates a new {@link DisabledRemoveAllContainer}.
     */
    private DisabledRemoveAllContainer() {
        super();
    }


    @Override
    public void removeAll()
    throws ForbiddenCastException {
        throw new ForbiddenCastException(this);
    }
}
