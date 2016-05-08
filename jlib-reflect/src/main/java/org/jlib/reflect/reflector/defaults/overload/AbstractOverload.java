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

package org.jlib.reflect.reflector.defaults.overload;

import java.lang.reflect.Method;

import static java.util.Collections.singletonList;
import static lombok.AccessLevel.PROTECTED;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.jlib.reflect.programelement.LanguageElementHelper;
import static org.jlib.reflect.programelement.LanguageElementUtility.assertSubtype;
import org.jlib.reflect.programelement.NoSubtypeException;
import org.jlib.reflect.reflector.Overload;

@RequiredArgsConstructor(access = PROTECTED)
@Getter(PROTECTED)
public abstract class AbstractOverload<ReturnValue>
implements Overload<ReturnValue> {

    private final LanguageElementHelper languageElementHelper;
    private final Class<?> enclosingClass;
    private final Class<ReturnValue> returnValueType;

    protected void assertReturnValueTypeValid(final Method method)
    throws NoSubtypeException {
        assertSubtype(method.getReturnType(), singletonList(returnValueType));
    }

    protected Class<?> getEnclosingClass() {
        return enclosingClass;
    }
}
