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

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import org.jlib.basefunctions.ToStringEngine;

public class ApacheCommonsToStringEngine<Obj>
    implements ToStringEngine<Obj> {

    private final ToStringBuilder builder;

    public ApacheCommonsToStringEngine(final Obj object) {
        builder = new ToStringBuilder(object);
    }

    public ApacheCommonsToStringEngine(final Obj object, final ToStringStyle toStringStyle) {
        builder = new ToStringBuilder(object, toStringStyle);
    }

    @Override
    public ApacheCommonsToStringEngine<Obj> add(final String valueName, final Object value) {
        builder.append(valueName, value);

        return this;
    }

    @Override
    public String toString() {
        return builder.toString();
    }
}
