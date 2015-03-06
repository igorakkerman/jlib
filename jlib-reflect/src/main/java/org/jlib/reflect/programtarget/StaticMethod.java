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

import static org.jlib.reflect.programtarget.factory.Factories.staticMethodOverloadFactory;
import org.jlib.reflect.programtarget.reflect_new.MethodOverload;

public class StaticMethod<EnclosingClassObject>
implements UntypedMethod {

    private final Class<EnclosingClassObject> enclosingClass;
    private final String staticMethodName;

    public StaticMethod(final Class<EnclosingClassObject> enclosingClass, final String staticMethodName) {
        this.enclosingClass = enclosingClass;
        this.staticMethodName = staticMethodName;
    }

    @Override
    public <ReturnValue>
    MethodOverload<ReturnValue> withReturnType(final Class<ReturnValue> returnValueClass)
    throws NoSubtypeException {
        return staticMethodOverloadFactory().staticMethodOverload(enclosingClass, staticMethodName, returnValueClass);
    }
}
