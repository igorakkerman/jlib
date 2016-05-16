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

package org.jlib.shared;

import java.util.Optional;
import java.util.function.Predicate;
import java.util.function.Supplier;

public final class OptionalUtility {

    private OptionalUtility() {}

    public static <Value> Optional<Value> optionalOf(final Value value, final Predicate<? super Value> predicate) {
        return optionalOf(value, predicate.test(value));
    }

    public static <Value> Optional<Value> optionalOf(final Supplier<Value> value,
                                                     final Predicate<? super Value> predicate) {
        return optionalOf(value.get(), predicate);
    }

    public static <Value> Optional<Value> optionalOf(final Value value, final boolean condition) {
        return condition ?
               Optional.of(value) :
               Optional.empty();
    }

    public static <Value> Optional<Value> optionalOf(final Supplier<Value> value, final boolean condition) {
        return optionalOf(value.get(), condition);
    }
}
