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

package org.jlib.core.system;

import org.jlib.core.language.UnexpectedStateException;

/**
 * Skeletal implementation of a {@link Cloneable} ensuring {@link #clone()} does not throw a
 * {@link CloneNotSupportedException}.
 *
 * @author Igor Akkerman
 */
public abstract class AbstractCloneable
extends AbstractObject
implements Cloneable {

    @Override
    public Object clone() {
        try {
            return super.clone();
        }
        catch (final CloneNotSupportedException exception) {
            throw new UnexpectedStateException(exception);
        }
    }
}
