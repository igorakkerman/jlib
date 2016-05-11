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

import org.apache.commons.lang3.builder.ToStringStyle;

import org.jlib.reflect.languageelement.ProgramElementException;
import org.jlib.reflect.reflector.ReflectorService;

public class ReflectorClassNameToStringStyleSupplier
implements ClassNameToStringStyleSupplier {

    private ReflectorService reflectorService;

    @Override
    public ToStringStyle get(final String className)
    throws ToStringStyleNotFoundException {
        try {
            return reflectorService.useClass(className)
                                   .withType(ToStringStyle.class)
                                   .instance();
        }
        catch (final ProgramElementException exception) {
            throw new ToStringStyleNotFoundException(exception);
        }
    }

    public void setReflectorService(final ReflectorService reflectorService) {
        this.reflectorService = reflectorService;
    }
}
