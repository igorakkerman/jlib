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

package org.jlib.container.operation.matrix;

import org.jlib.core.language.InvalidArgumentException;

import static org.jlib.core.language.MessageUtility.message;

public class InvalidMatrixHeightException
extends InvalidArgumentException {

    private static final long serialVersionUID = - 7801198256811055948L;

    public InvalidMatrixHeightException(final int height) {
        super(message(height));
    }
}
