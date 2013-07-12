/*
 * jlib - Open Source Java Library
 *
 *     www.jlib.org
 *
 *
 *     Copyright 2005-2013 Igor Akkerman
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

package org.jlib.core.value;

/**
 * {@link Accessible} initialized by the constructor.
 *
 * @param <Val>
 *        type of the value
 *
 * @author Igor Akkerman
 */
public class Initialized<Val>
extends Accessible<Val> {

    /** registered {@link Val} */
    private Val value;

    /**
     * Creates a new {@link Initialized}.
     *
     * @param initialValue
     *        initial {@link Val}
     */
    public Initialized(final Val initialValue) {
        super();

        value = initialValue;
    }

    @Override
    public Val getValue() {
        return value;
    }

    /**
     * Registers the new {@link Val}.
     *
     * @param value
     *        new {@link Val}
     */
    protected void setValue(final Val value) {
        this.value = value;
    }
}
