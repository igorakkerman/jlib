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

package org.jlib.container.storage.array;

import org.jlib.container.storage.InvalidCapacityException;
import org.jlib.container.storage.InvalidStorageIndexException;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;

public class ArrayStorageTest {

    public void zeroCapacityStorageShouldReturnCorrectCapacity()
    throws Exception {
        final ArrayStorage<Integer> storage = new ArrayStorage<>(0);

        assertThat(storage.capacity()).isEqualTo(0);
    }

    public void positiveCapacityStorageShouldReturnCorrectCapacity()
    throws Exception {
        final ArrayStorage<Integer> storage = new ArrayStorage<>(5);

        assertThat(storage.capacity()).isEqualTo(5);
    }

    @Test(expected = InvalidCapacityException.class)
    public void negativeCapacityStorageReadShouldThrowException()
    throws Exception {
        new ArrayStorage<>(- 1);
    }

    @Test(expected = InvalidStorageIndexException.class)
    public void zeroCapacityStorageReadShouldThrowException()
    throws Exception {
        new ArrayStorage<Integer>(0).get(0);
    }

    @Test(expected = InvalidStorageIndexException.class)
    public void readNegativeIndexShouldThrowException()
    throws Exception {
        new ArrayStorage<Integer>(5).get(- 1);
    }

    @Test
    public void getPreviouslySetItemShouldReturnCorrectItem()
    throws Exception {
        final ArrayStorage<String> storage = new ArrayStorage<>(5);
        storage.set(3, "Test");

        assertThat(storage.get(3)).isEqualTo("Test");
    }

    @Test
    public void getReplacedItemShouldReturnCorrectItem()
    throws Exception {
        final ArrayStorage<String> storage = new ArrayStorage<>(5);
        storage.set(3, "Test");
        storage.set(3, "new");

        assertThat(storage.get(3)).isEqualTo("new");
    }

    @SuppressWarnings("EmptyMethod")
    @Test
    public void testShiftItems()
    throws Exception {
        // TODO: implement
    }

    @SuppressWarnings("EmptyMethod")
    @Test
    public void testCopyItems()
    throws Exception {
        // TODO: implement
    }

    @SuppressWarnings("EmptyMethod")
    @Test
    public void testGetCapacity()
    throws Exception {
        // TODO: implement
    }

    @SuppressWarnings("EmptyMethod")
    @Test
    public void testEnsureCapacityAndShiftItems()
    throws Exception {
        // TODO: implement
    }
}
