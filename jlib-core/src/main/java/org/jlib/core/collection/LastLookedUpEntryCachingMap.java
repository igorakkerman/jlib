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

package org.jlib.core.collection;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

import javax.annotation.Nullable;

import com.google.common.base.Optional;

/**
 * Proxy {@link Map} caching the last {@link Value} looked up using {@link #containsKey(Object)} and returning it by a
 * subsequent call to {@link #get(Object)} for the same key {@link Object}. Note that the key {@link Object} is only
 * tested for identity, not for equality. The other methods are delegated to the {@link Map} specified to the
 * constructor. As in all <em>jlib</em> classes, neither {@code null} Keys nor {@code null} {@link Value}s are permitted
 * and cause undefined behaviour, such as {@link RuntimeException}s or invalid results. Hence, a
 * {@link LastLookedUpEntryCachingMap} may not be used on delegate {@link Map}s containing {@code null} {@link Key}s or
 * {@link Value}s.
 *
 * @param <Key>
 *        type of the keys
 *
 * @param <Value>
 *        type of the values
 *
 * @author Igor Akkerman
 */
public class LastLookedUpEntryCachingMap<Key, Value>
implements Map<Key, Value> {

    /** {@link Map} to which all method calls are delegated*/
    private final Map<Key, Value> delegateMap;

    /** last successfully looked up key */
    private Optional<Object> lastLookedUpContainedKey;

    /** last successfully looked up value for {@link #lastLookedUpContainedKey} */
    private Optional<Value> lastLookedUpContainedValue;

    /**
     * Creates a new {@link LastLookedUpEntryCachingMap}.
     *
     * @param delegateMap
     *        delegate {@link Map} to which all calls are delegated
     */
    public LastLookedUpEntryCachingMap(final Map<Key, Value> delegateMap) {
        super();

        this.delegateMap = delegateMap;
    }

    @Override
    public boolean containsKey(final Object key) {
        lookup(key);

        return lastLookedUpContainedValue.isPresent();
    }

    @SuppressWarnings("SuspiciousMethodCalls")
    private void lookup(final Object key) {
        final Value value = delegateMap.get(key);

        lastLookedUpContainedKey = Optional.of(key);
        lastLookedUpContainedValue = Optional.fromNullable(value);
    }

    @Override
    @SuppressWarnings("ReturnOfNull")
    @Nullable
    public Value get(final Object key) {
        return isLastLookedUpKey(key) ?
               (lastLookedUpContainedValue.isPresent() ?
                lastLookedUpContainedValue.get() :
                null) :
               delegateMap.get(key);
    }

    private boolean isLastLookedUpKey(final Object key) {
        return lastLookedUpContainedKey.isPresent() && lastLookedUpContainedKey.get() == key;
    }

    @Override
    public Value put(final Key key, final Value value) {
        return delegateMap.put(key, value);
    }

    @Override
    public int size() {
        return delegateMap.size();
    }

    @Override
    public boolean isEmpty() {
        return delegateMap.isEmpty();
    }

    @Override
    public boolean containsValue(final Object value) {
        return delegateMap.containsValue(value);
    }

    @Override
    public Value remove(final Object key) {
        if (isLastLookedUpKey(key))
            clearLastLookedUpContainedItems();

        return delegateMap.remove(key);
    }

    @Override
    public void clear() {
        clearLastLookedUpContainedItems();

        delegateMap.clear();
    }

    /**
     * Clears the last looked up contained Key and Value.
     */
    protected void clearLastLookedUpContainedItems() {
        lastLookedUpContainedKey = Optional.absent();
        lastLookedUpContainedValue = Optional.absent();
    }

    @Override
    @SuppressWarnings("NullableProblems")
    public void putAll(final Map<? extends Key, ? extends Value> map) {
        delegateMap.putAll(map);
    }

    @Override
    @SuppressWarnings("NullableProblems")
    public Set<Key> keySet() {
        return delegateMap.keySet();
    }

    @Override
    @SuppressWarnings("NullableProblems")
    public Collection<Value> values() {
        return delegateMap.values();
    }

    @Override
    @SuppressWarnings("NullableProblems")
    public Set<Map.Entry<Key, Value>> entrySet() {
        return delegateMap.entrySet();
    }
}
