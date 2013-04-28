/*******************************************************************************
 * 
 *    jlib - Open Source Java Library
 * 
 *    www.jlib.org
 * 
 * 
 *    Copyright 2012 Igor Akkerman
 * 
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 * 
 *        http://www.apache.org/licenses/LICENSE-2.0
 * 
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 * 
 ******************************************************************************/

package org.jlib.core.valueholder;

/**
 * Modifiable {@link ValueHolder}.
 * 
 * @param <Value>
 *        type of the value
 * 
 * @author Igor Akkerman
 */
public interface ModifiableValueHolder<Value>
extends ValueHolder<Value> {

    /**
     * Registers the new Value.
     * 
     * @param value
     *        new Value
     */
    public void setValue(final Value value);
}
