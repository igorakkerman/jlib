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

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import static org.jlib.message.MessageUtility.message;
import org.jlib.reflect.programelement.ClassLookupException;
import org.jlib.reflect.programelement.ConstructorInvocationException;
import org.jlib.reflect.programelement.InstanceMethodInvocationException;
import org.jlib.reflect.programelement.InvalidMethodParameterTypesException;
import org.jlib.reflect.programelement.LanguageElementHelper;
import org.jlib.reflect.programelement.MethodInvocationException;
import org.jlib.reflect.programelement.MethodLookupException;

public class ReflectionLanguageElementHelper
    implements LanguageElementHelper {

    @Override
    public Class<?> lookupClass(final String className)
        throws ClassLookupException {
        try {
            return Class.forName(className);
        }
        catch (final ClassNotFoundException | LinkageError throwable) {
            throw new ClassLookupException(className, throwable);
        }
    }

    @Override
    public <EnclosingClassObject>
    Constructor<EnclosingClassObject> lookupConstructor(final Class<EnclosingClassObject> enclosingClass,
                                                        final Class<?>... parameterTypes)
        throws InvalidMethodParameterTypesException {
        try {
            return enclosingClass.getConstructor(parameterTypes);
        }
        catch (final NoSuchMethodException exception) {
            throw new InvalidMethodParameterTypesException(enclosingClass.getName(), enclosingClass.getName(),
                                                           parameterTypes, exception);
        }
    }

    @Override
    public <Obj> Obj invokeConstructor(final Constructor<Obj> constructor, final Object... arguments)
        throws MethodInvocationException {
        try {
            return constructor.newInstance(arguments);
        }
        catch (final ReflectiveOperationException exception) {
            throw new ConstructorInvocationException(message(), constructor);
        }
    }

    protected Method lookupMethod(final Class<?> enclosingClass, final String methodName, final Class<?>[] parameterTypes)
        throws InvalidMethodParameterTypesException {
        try {
            return enclosingClass.getMethod(methodName, parameterTypes);
        }
        catch (final NoSuchMethodException exception) {
            throw new InvalidMethodParameterTypesException(enclosingClass.getName(), methodName, parameterTypes,
                                                           exception);
        }
    }

    @Override
    public Method lookupInstanceMethod(final Class<?> enclosingClass, final String methodName,
                                       final Class<?>... parameterTypes)
        throws InvalidMethodParameterTypesException {
        return lookupMethod(enclosingClass, methodName, parameterTypes);
    }

    @Override
    public Method lookupStaticMethod(final Class<?> enclosingClass, final String methodName,
                                     final Class<?>... parameterTypes)
        throws InvalidMethodParameterTypesException {
        return lookupMethod(enclosingClass, methodName, parameterTypes);
    }

    @Override
    @SuppressWarnings("unchecked")
    public <ReturnValue>
    ReturnValue invokeStaticMethod(final Method method, final Object... arguments)
        throws MethodLookupException {
        try {
            return (ReturnValue) method.invoke(/* static */ null, arguments);
        }
        catch (final ReflectiveOperationException exception) {
            throw new MethodInvocationException(message(), method.getClass().getName(), method.toString());
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public <ReturnValue, EnclosingObject>
    ReturnValue invokeInstanceMethod(final EnclosingObject enclosingObject, final Method method,
                                     final Object... arguments)
        throws MethodInvocationException {
        try {
            return (ReturnValue) method.invoke(enclosingObject, arguments);
        }
        catch (final ReflectiveOperationException exception) {
            throw new InstanceMethodInvocationException(message(), enclosingObject, method.toString());
        }
    }
}
