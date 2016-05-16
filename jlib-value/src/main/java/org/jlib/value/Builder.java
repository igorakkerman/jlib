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

package org.jlib.value;

/**
 * <p>Skeletal implementation of a builder for application {@link Object}s.</p>
 *
 * @param <Obj>
 *        type of built objects
 *
 * @param <Self>
 *        own type
 */
// TODO: review
public abstract class Builder<Obj, Self extends Builder<Obj, Self>> {

    private Accessible<Obj> object = this::newInstance;

    /**
     * Returns a new instance of the {@link Obj} to build.
     *
     * @return new {@link Obj} instance
     */
    protected abstract Obj newInstance();

    /**
     * Starts building the {@link Obj} using the specified prototype {@link Obj}.
     * All previous initializations are discarded.
     *
     * @param prototype
     *        {@link Obj} instance used as prototype for the built {@link Obj}
     *
     * @return this {@link Builder} to allow chaining
     */
    @SuppressWarnings("unchecked")
    public Self of(final Obj prototype) {
        object = new Initialized<>(prototype);

        return (Self) this;
    }

    /**
     * Returns the built {@link Obj}.
     *
     * @return built {@link Obj}
     */
    public Obj build() {
        return object.get();
    }
}
