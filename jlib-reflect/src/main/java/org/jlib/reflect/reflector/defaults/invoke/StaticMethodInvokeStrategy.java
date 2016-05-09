/*
 * jlib - Open Source Java Library
 *
 *     www.jlib.org
 *
 *
 *     Copyright 2005-2016 Igor Akkerman
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

package org.jlib.reflect.reflector.defaults.invoke;

import java.lang.reflect.Method;

import org.jlib.reflect.programelement.LanguageElementHelper;
import org.jlib.reflect.programelement.MethodInvocationException;

public class StaticMethodInvokeStrategy
    extends InvokeStrategy<Method> {

    public StaticMethodInvokeStrategy(final LanguageElementHelper languageElementHelper,
                                      final Method method) {
        super(languageElementHelper, method);
    }

    @Override
    public Object invoke(final Object... arguments)
        throws MethodInvocationException {

        return getLanguageElementHelper().invokeStaticMethod(getMethod(), arguments);
    }
}
