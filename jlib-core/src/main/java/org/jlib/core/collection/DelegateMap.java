package org.jlib.core.collection;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

import org.jlib.core.system.AbstractObject;

public class DelegateMap<Key, Value>
extends AbstractObject
implements Map<Key, Value> {

    private final Map<Key, Value> delegateMap;

    public DelegateMap(final Map<Key, Value> delegateMap) {
        this.delegateMap = delegateMap;
    }

    protected Map<Key, Value> getDelegateMap() {
        return delegateMap;
    }

    @Override
    @SuppressWarnings("NullableProblems")
    public Set<Entry<Key, Value>> entrySet() {
        return delegateMap.entrySet();
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
    public boolean containsKey(final Object key) {
        return delegateMap.containsKey(key);
    }

    @Override
    public boolean containsValue(final Object value) {
        return delegateMap.containsValue(value);
    }

    @Override
    public Value get(final Object key) {
        return delegateMap.get(key);
    }

    @Override
    public Value put(final Key key, final Value value) {
        return delegateMap.put(key, value);
    }

    @Override
    public Value remove(final Object key) {
        return delegateMap.remove(key);
    }

    @Override
    @SuppressWarnings("NullableProblems")
    public void putAll(final Map<? extends Key, ? extends Value> map) {
        delegateMap.putAll(map);
    }

    @Override
    public void clear() {
        delegateMap.clear();
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
}
