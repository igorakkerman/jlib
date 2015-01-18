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

package org.jlib.core.array;

import org.jlib.core.storage.InvalidCapacityException;
import org.jlib.core.storage.InvalidIndexException;
import org.junit.Test;

public class ArrayStorageTest {

    @Test(expected = InvalidIndexException.class)
    public void zeroCapacityReadAccess()
    throws Exception {
        new ArrayStorage<Integer>(0).getItem(0);
    }

    @Test(expected = InvalidIndexException.class)
    public void negativeIndexAccess()
    throws Exception {
        new ArrayStorage<Integer>(5).getItem(-1);
    }

    @Test(expected = InvalidCapacityException.class)
    public void negativeCapacity()
    throws Exception {
        new ArrayStorage<>(-1);
    }

    @SuppressWarnings("EmptyMethod")
    @Test
    public void testEnsureCapacityAndShiftItems()
    throws Exception {
        // TODO: implement
    }

    @SuppressWarnings("EmptyMethod")
    @Test
    public void testGetItem()
    throws Exception {
        // TODO: implement
    }

    @SuppressWarnings("EmptyMethod")
    @Test
    public void testReplaceItem()
    throws Exception {
        // TODO: implement
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
}
