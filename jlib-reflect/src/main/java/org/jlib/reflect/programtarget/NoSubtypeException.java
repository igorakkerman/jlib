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

package org.jlib.reflect.programtarget;

import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.jlib.core.message.MessageUtility.message;

public class NoSubtypeException
extends ClassException {

    private static final long serialVersionUID = - 7474100445702869755L;

    private final List<String> expectedParentTypeClassNames;

    public NoSubtypeException(final Class<?> clazz, final List<Class<?>> expectedParentTypes) {
        super(message().with("expectedParentTypes", expectedParentTypes), clazz.getName());

        expectedParentTypeClassNames = expectedParentTypes.stream().map(Class::getName).collect(toList());
    }

    public List<String> getExpectedParentTypeClassNames() {
        return expectedParentTypeClassNames;
    }
}
