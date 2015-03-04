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

package org.jlib.basefunctions.apachecommons.tostring;

import java.util.Optional;

import org.apache.commons.lang3.builder.ToStringStyle;

import org.jlib.reflect.programtarget.MethodLookupException;
import org.jlib.reflect.programtarget.InvalidMethodReturnValueException;
import static org.jlib.reflect.programtarget.reflect_new.Reflectors.useClass;

public class IdentifierOrClassNameToStringStyleSupplier
implements ConfigurableToStringStyleSupplier {

    private String identifierOrClassName;
    private NamedToStringStyleSupplier namedStyleSupplier;

    @Override
    @SuppressWarnings("unchecked")
    public ToStringStyle get()
    throws ToStringStyleNotFoundException {
        try {
            final Optional<ToStringStyle> toStringStyle = namedStyleSupplier.get(identifierOrClassName);

            return toStringStyle.isPresent() ?
                   toStringStyle.get() :
                   // TODO: use service instead of static method when available
                   useClass(identifierOrClassName).withType(ToStringStyle.class)
                                                  .instance();
        }
        catch (final MethodLookupException | InvalidMethodReturnValueException exception) {
            throw new ToStringStyleNotFoundException(exception);
        }
    }

    public void setNamedStyleSupplier(final NamedToStringStyleSupplier namedStyleSupplier) {
        this.namedStyleSupplier = namedStyleSupplier;
    }

    public void setIdentifierOrClassName(final String identifierOrClassName) {
        this.identifierOrClassName = identifierOrClassName;
    }
}
