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

package org.jlib.core.collection;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * {@link Map} Proxy delegating all method calls to another {@link Map} caching
 * the last looked up Value. Unlike in the {@link HashMap} class, as in all jlib
 * classes, neither {@code null} Keys nor {@code null} Values are permitted.
 *
 * @param <Key>
 *        type of the keys
 *
 * @param <Value>
 *        type of the values
 *
 * @author Igor Akkerman
 */
@SuppressWarnings({"ObjectEquality", "NullableProblems", "SuspiciousMethodCalls"})
public class ProxyMap<Key, Value>
implements Map<Key, Value> {

    /** {@link Map} to which */
    private final Map<Key, Value> delegateMap;

    /** last successfully looked up key */
    private Key lastLookedUpContainedKey;

    /** last successfully looked up value for {@link #lastLookedUpContainedKey} */
    private Value lastLookedUpContainedValue;

    /**
     * Creates a new {@link ProxyMap}.
     *
     * @param delegateMap
     *        delegate {@link Map} to which all calls are delegated
     */
    public ProxyMap(final Map<Key, Value> delegateMap) {
        super();

        this.delegateMap = delegateMap;
    }

    @Override
    @SuppressWarnings("unchecked")
    public boolean containsKey(final Object key) {
        if (key == lastLookedUpContainedKey)
            return true;

        final Value value = delegateMap.get(key);

        if (value == null)
            return false;

        lastLookedUpContainedKey = (Key) key;
        lastLookedUpContainedValue = value;

        return true;
    }

    @Override
    public Value get(final Object key) {
        //noinspection ObjectEquality
        return key == lastLookedUpContainedKey
               ? lastLookedUpContainedValue
               : delegateMap.get(key);
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
        if (lastLookedUpContainedKey == key)
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
        lastLookedUpContainedKey = null;
        lastLookedUpContainedValue = null;
    }

    @Override
    public void putAll(final Map<? extends Key, ? extends Value> map) {
        delegateMap.putAll(map);
    }

    @Override
    public Set<Key> keySet() {
        return delegateMap.keySet();
    }

    @Override
    public Collection<Value> values() {
        return delegateMap.values();
    }

    @Override
    public Set<Map.Entry<Key, Value>> entrySet() {
        return delegateMap.entrySet();
    }
}
