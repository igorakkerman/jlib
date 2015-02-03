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

package org.jlib.container;

import org.jlib.container.operation.ContainsMultiple;
import org.jlib.container.operation.ContainsSingle;
import org.jlib.container.operation.Count;
import org.jlib.container.operation.IsEmpty;
import org.jlib.container.operation.ToArray;
import org.jlib.container.operation.ToRandomAccessList;
import org.jlib.container.operation.ToSequentialList;
import org.jlib.container.operation.ToSet;

public interface Container<Item>
extends Iterable<Item>,
        ContainsSingle<Item>,
        ContainsMultiple<Item>,
        Count<Item>,
        IsEmpty<Item>,
        ToArray<Item>,
        ToRandomAccessList<Item>,
        ToSequentialList<Item>,
        ToSet<Item> {
    // unifying
}
