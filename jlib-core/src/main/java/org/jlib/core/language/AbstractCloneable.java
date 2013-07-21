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

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;

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
    @SuppressWarnings("unchecked")
    public Object clone() {
        try {
            final Object clonedObject = super.clone();

            // FIXME: delegate to generic cloner
            BeanUtils.copyProperties(clonedObject, this);

            return clonedObject;
        }
        catch (final CloneNotSupportedException | InvocationTargetException | IllegalAccessException exception) {
            throw new UnexpectedStateException(exception);
        }
    }
}
