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

package org.jlib.reflect.programtarget.factory;

import org.jlib.reflect.programtarget.reflect_new.Method0;
import org.jlib.reflect.programtarget.reflect_new.Method1;
import org.jlib.reflect.programtarget.reflect_new.Method2;
import org.jlib.reflect.programtarget.reflect_new.Method3;

public interface MethodFactory {

    <ReturnValue>
    Method0<ReturnValue> method0();

    <ReturnValue, Parameter1>
    Method1<ReturnValue, Parameter1> method1();

    <ReturnValue, Parameter1, Parameter2>
    Method2<ReturnValue, Parameter1, Parameter2> method2();

    <ReturnValue, Parameter1, Parameter2, Parameter3>
    Method3<ReturnValue, Parameter1, Parameter2, Parameter3> method3();
}
