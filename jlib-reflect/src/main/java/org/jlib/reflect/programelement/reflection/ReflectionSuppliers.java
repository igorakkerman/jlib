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

package org.jlib.reflect.programelement.reflection;

public final class ReflectionSuppliers {

    public static ClassLookupSupplier classLookupSupplier() {
        return ReflectionClassLookup::new;
    }

    public static ConstructorLookupSupplier constructorLookupSupplier(){
        return ReflectionConstructorLookup::new;
    }

    public static StaticMethodInvokerSupplier staticMethodInvokerSupplier() {
        return ReflectionStaticMethodInvoker::new;
    }

    public static InstanceMethodInvokerSupplier instanceMethodInvokerSupplier() {
        return ReflectionInstanceMethodInvoker::new;
    }

    public static ConstructorInvokerSupplier constructorInvokerSupplier() {
        return ReflectionConstructorInvoker::new;
    }

    private ReflectionSuppliers() {}
}
