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

import java.util.Map;
import java.util.Optional;

import org.apache.commons.lang3.builder.ToStringStyle;

import static org.jlib.shared.OptionalUtility.optionalOf;

class MapNamedToStringStyleSupplier
    implements NamedToStringStyleSupplier {

    private final Map<String, ToStringStyle> toStringStyles;

    MapNamedToStringStyleSupplier(final Map<String, ToStringStyle> toStringStyles) {
        this.toStringStyles = toStringStyles;
    }

    @Override
    public Optional<ToStringStyle> get(final String identifier) {
        return optionalOf(() -> toStringStyles.get(identifier), toStringStyles.containsKey(identifier));
    }
}
