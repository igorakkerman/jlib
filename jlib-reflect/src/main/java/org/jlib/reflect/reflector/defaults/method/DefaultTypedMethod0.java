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

package org.jlib.reflect.reflector.defaults.method;

import java.lang.reflect.Executable;

import org.jlib.reflect.languageelement.LanguageElementHandler;
import org.jlib.reflect.languageelement.MethodLookupException;
import org.jlib.reflect.reflector.MethodReturn;
import org.jlib.reflect.reflector.TypedMethod0;
import org.jlib.reflect.reflector.defaults.invoke.InvokeStrategy;
import org.jlib.reflect.reflector.defaults.methodreturn.DefaultMethodReturn;

public class DefaultTypedMethod0<Exe extends Executable, ReturnValue>
    extends AbstractTypedMethod<Exe, ReturnValue>
    implements TypedMethod0<Exe, ReturnValue> {

    private static final Object[] NO_ARGUMENTS = new Object[0];

    public DefaultTypedMethod0(final LanguageElementHandler languageElementHandler,
                               final InvokeStrategy<Exe> invokeStrategy) {

        super(languageElementHandler, invokeStrategy);
    }

    @Override
    @SuppressWarnings("unchecked")
    public MethodReturn<ReturnValue> invoke()
        throws MethodLookupException {

        final ReturnValue returnValue = (ReturnValue) getInvokeStrategy().invoke(NO_ARGUMENTS);

        return new DefaultMethodReturn<>(getLanguageElementHandler(), getInvokeStrategy().getMethod(), returnValue);
    }

    @Override
    public <StaticReturnValue>
    TypedMethod0<Exe, StaticReturnValue> withReturnType(final Class<StaticReturnValue> staticReturnSuperType) {
        return new DefaultTypedMethod0<>(getLanguageElementHandler(), getInvokeStrategy());
    }
}
