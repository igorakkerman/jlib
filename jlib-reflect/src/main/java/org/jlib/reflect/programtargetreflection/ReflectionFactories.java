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

package org.jlib.reflect.programtargetreflection;

import org.jlib.reflect.programtarget.ClassLookupFactory;
import org.jlib.reflect.programtarget.ConstructorInvokerFactory;
import org.jlib.reflect.programtarget.InstanceMethodInvokerFactory;
import org.jlib.reflect.programtarget.MethodLookupFactory;
import org.jlib.reflect.programtarget.StaticMethodInvokerFactory;

public final class ReflectionFactories {

    public static ClassLookupFactory classLookupFactory() {
        return ReflectionClassLookup::new;
    }

    public static StaticMethodInvokerFactory staticMethodInvokerFactory() {
        return ReflectionStaticMethodInvoker::new;
    }

    public static InstanceMethodInvokerFactory instanceMethodInvokerFactory() {
        return ReflectionInstanceMethodInvoker::new;
    }

    public static ConstructorInvokerFactory constructorInvokerFactory() {
        return ReflectionConstructorInvoker::new;
    }

    public static MethodLookupFactory methodLookupFactory() {
        return ReflectionMethodLookup::new;
    }

    private ReflectionFactories() {}
}
