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

import java.util.List;

import com.google.common.collect.ForwardingList;
import org.checkerframework.checker.nullness.qual.Nullable;

/**
 * <p>
 * {@link ForwardingList} caching the index of the last {@link Item} looked up using {@link #indexOf(Object)} and
 * returning it by a subsequent call to {@link #get(int)} for the same index. The other methods are delegated to the
 * {@link List} specified to the constructor.
 * </p>
 * <p>
 * Note that if the index of the requested {@link Item} is changed in the delegate {@link List} between the calls to
 * {@link #indexOf(Object)} and {@link #get(int)}, the <em>former, now wrong</em>, index will be returned by the latter
 * call. This also happens when the {@link Item} is removed from the delegate {@link List}.
 * </p>
 * <p>
 * TODO: document: indexOf(null)
 * As in all <em>jlib</em> classes, {@code null} {@link Item}s are <em>not</em> permitted and cause undefined behaviour,
 * such as {@link RuntimeException}s or invalid results. Hence, a {@link CachingList} may not be used on delegate
 * {@link List}s containing {@code null} {@link Item}s.
 * </p>
 * <p>
 * The key idea behind this proxy is to be able to use the following idiom without worrying about performance issues due
 * to multiple lookups:
 * </p>
 * <pre>
 * if (list.contains(item)) {
 *     itemIndex = list.indexOf(item);
 *     // commands with index
 * }
 * else {
 *     // commands with no item
 * }</pre>
 * <p>
 * Instead, many developers use the following technique which enforces comparing the result with {@code -1}. This is a
 * discouraged code style and less readable:
 * </p>
 * <pre>
 * // dicouraged by clean coders
 * itemIndex = list.indexOf(item);
 * if (itemIndex != -1) {
 *     // commands with index
 * }
 * else {
 *     // commands with no index
 * }</pre>
 *
 * @param <Item>
 *        type of the values
 *
 * @author Igor Akkerman
 */
public final class CachingList<Item>
extends ForwardingList<Item> {

    /** delegate {@link List} */
    private final List<Item> delegateList;

    /** last looked up index; -1 if unset (for performance reasons) */
    private int lastLookedUpItemIndex;

    /** last looked up {@link Item}; {@code null} if unset (for performance reasons) */
    private @Nullable Object lastLookedUpItem;

    /**
     * Creates a new {@link CachingList}.
     *
     * @param delegateList
     *        delegate {@link List} to which all calls are delegated
     */
    public CachingList(final List<Item> delegateList) {

        this.delegateList = delegateList;
    }

    @Override
    protected List<Item> delegate() {
        return delegateList;
    }

    @Override
    public int indexOf(@Nullable final Object item) {
        if (item == lastLookedUpItem)
            return lastLookedUpItemIndex;

        @SuppressWarnings("ConstantConditions")
        final int itemIndex = super.indexOf(item);

        lastLookedUpItem = item;
        lastLookedUpItemIndex = itemIndex;

        return itemIndex;
    }

    @Override
    public Item remove(final int index) {
        if (index == lastLookedUpItemIndex)
            clearLastLookedUpIndex();

        return super.remove(index);
    }

    @Override
    public void clear() {
        clearLastLookedUpIndex();

        super.clear();
    }

    /**
     * Clears the last looked up contained Key and Item.
     */
    @SuppressWarnings("AssignmentToNull")
    private void clearLastLookedUpIndex() {
        lastLookedUpItem = null;
        lastLookedUpItemIndex = - 1;
    }
}
