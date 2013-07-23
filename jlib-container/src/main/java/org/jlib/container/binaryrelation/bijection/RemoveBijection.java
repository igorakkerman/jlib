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

package org.jlib.container.binaryrelation.bijection;

import org.jlib.container.binaryrelation.NoSuchPairException;
import org.jlib.container.binaryrelation.RemoveBinaryRelation;

/**
 * Bijection allowing to add new pairs.
 *
 * @param <LeftValue>
 *        type of the values on the left hand side of the bijection
 *
 * @param <RightValue>
 *        type of the values on the right hand side of the bijection
 *
 * @author Igor Akkerman
 */
public interface RemoveBijection<LeftValue, RightValue>
extends Bijection<LeftValue, RightValue>, RemoveBinaryRelation<LeftValue, RightValue> {

    @Override
    public void remove(LeftValue leftValue, RightValue rightValue)
    throws NoSuchPairException;
}
