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

package org.jlib.text;

import static org.jlib.core.message.MessageUtility.pfmessage;

/**
 * Exception thrown when a {@link CharSequence} begin index is negative.
 *
 * @author Igor Akkerman
 */
public class CharSequenceBeginIndexNegativeException
extends CharSequenceIndexOutOfBoundsException {

    private static final long serialVersionUID = 5947676052783402761L;

    public CharSequenceBeginIndexNegativeException(final CharSequence charSequence, final int beginIndex) {
        super(pfmessage(CS_FORMAT + "beginIndex = %d < 0", charSequence, beginIndex));
    }
}
