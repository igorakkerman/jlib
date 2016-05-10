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

package org.jlib.reflect.reflector.defaults.methodreturn;

import java.lang.reflect.Executable;

import static java.util.Arrays.asList;
import static lombok.AccessLevel.PROTECTED;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.jlib.reflect.programelement.InvalidReturnTypeException;
import org.jlib.reflect.programelement.LanguageElementHelper;
import static org.jlib.reflect.programelement.LanguageElementUtility.assertReturnTypeInstanceOf;
import org.jlib.reflect.programelement.ProgramElementException;
import org.jlib.reflect.reflector.MethodOverload;
import org.jlib.reflect.reflector.MethodReturn;
import org.jlib.reflect.reflector.defaults.overload.DefaultInstanceMethodOverload;

@RequiredArgsConstructor
public class DefaultMethodReturn<Exe extends Executable, ReturnValue>
implements MethodReturn<ReturnValue> {

    private final LanguageElementHelper languageElementHelper;
    @Getter(PROTECTED)
    private final Exe executable;
    private final ReturnValue returnValue;

    @Override
    public MethodReturn<ReturnValue> returning(final Class<?>... expectedSuperTypes)
        throws InvalidReturnTypeException {

        assertReturnTypeInstanceOf(executable, returnValue, asList(expectedSuperTypes));

        return this;
    }

    @Override
    public MethodOverload<Object> useMethod(final String methodName) {
        return new DefaultInstanceMethodOverload<>(languageElementHelper, returnValue, methodName, Object.class);
    }

    @Override
    public ReturnValue get()
    throws ProgramElementException {
        return returnValue;
    }
}
