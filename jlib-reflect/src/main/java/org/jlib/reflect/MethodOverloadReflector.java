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

package org.jlib.reflect;

public interface MethodOverloadReflector<Value> {

    Method0Reflector<Value> withoutArguments();

    <Argument1> /*
 */ Method1Reflector<Value, Argument1> /*
     */ withArgumentTypes(Class<Argument1> argument1Type);

    <Argument1, Argument2> /*
 */ Method2Reflector<Value, Argument1, Argument2> /*
     */ withArgumentTypes(Class<Argument1> argument1Type, Class<Argument2> argument2Type);

    <Argument1, Argument2, Argument3> /*
 */ Method3Reflector<Value, Argument1, Argument2, Argument3> /*
     */ withArgumentTypes(Class<Argument1> argument1Type, Class<Argument2> argument2Type,
                          Class<Argument3> argument3Type);

   UncheckedMethodReflector<Value> withUncheckedArgumentTypes();
}
