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

package org.jlib.basefunctions;

public interface BaseFunctionsDispatcher {

    <Obj> Equals<Obj> genericEquals();

    <Obj> Equals<Obj> genericEquals(String... excludedFields);

    <Obj> EqualsEngine<Obj> equalsEngine(Obj thiz, Object other);

    <Obj> HashCode<Obj> genericHashCode();

    <Obj> HashCode<Obj> genericHashCode(String... excludedFields);

    <Obj> HashCodeEngine<Obj> hashCodeEngine(Obj object);

    <Obj> ToString<Obj> genericToString();

    <Obj> ToStringEngine<Obj> toStringEngine(Obj object);
}
