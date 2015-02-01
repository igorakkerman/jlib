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

package org.jlib.codec.base64;

import java.util.Arrays;

import static org.jlib.core.message.MessageUtility.message;

/**
 * Exception thrown if a base64 block contains more than two padding characters or a padding
 * character at a position other than at the end of the block.
 *
 * @author Igor Akkerman
 */

public class InvalidBase64BlockPadException
extends InvalidBase64StreamException {

    private static final long serialVersionUID = 1023903911620993818L;

    /** base64 block containing a wrong padding character */
    private final int[] base64Block;

    /**
     * Creates a new IllegalBase64BlockPadException for the specified base64 block.
     *
     * @param base64Block
     *        array of four integers containing the bad base64 block that contains a wrong padding character
     */
    public InvalidBase64BlockPadException(final int[] base64Block) {
        super(message().with("base64Block", Arrays.toString(base64Block)));

        this.base64Block = base64Block;
    }

    /**
     * Returns the bad base64 block that contains a wrong padding character.
     *
     * @return array of four integers containing the bad base64 block that contains a wrong padding character
     */
    public int[] getBase64Block() {
        return base64Block;
    }
}
